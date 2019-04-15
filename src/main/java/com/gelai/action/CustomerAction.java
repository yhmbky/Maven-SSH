package com.gelai.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.gelai.bean.Customer;
import com.gelai.bean.PageBean;
import com.gelai.service.CustomerService;
import com.gelai.util.Tool;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	private Integer current = 1;
	private Integer pageSize = 3;
	private String custName;
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		if(current==null) {
			current=1;
		}
		this.current = current;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		if (pageSize==null) {
			pageSize=3;
		}
		this.pageSize = pageSize;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}

	//注入service
	private CustomerService customerService;
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	private String uploadFileName;
	private File upload;
	private String uploadContextType;
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}
	
	/**
	 * 跳转到添加页面的方法
	 * @return
	 */
	public String saveUI() {
		//查询字典数据
		return "saveUI";
	}
	
	/**
	 * 添加客户
	 */
	public String save() {
		//上传图片
		if (upload!=null) {
			//设置文件上传的路径
			String path = ServletActionContext.getRequest().getRealPath("imgs/");
			//处理文件名
			String fileName = Tool.dateFileName(uploadFileName);
			//目录分离
			String path2 = Tool.getPath(fileName);
			//判断目录是否存在
			File f = new File(path+path2);
			if (!f.exists()) {
				f.mkdirs();
			}
			//文件上传
			File file = new File(path+fileName);
			try {
				FileUtils.copyFile(upload, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//设置cust_image
			customer.setCust_image(path+fileName);
		}
		customerService.save(customer);
		return "save";
	}
	
	/**
	 * 客户分页查找
	 */
	public String find() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		if (custName!=null) {
			detachedCriteria.add(Restrictions.like("cust_name", "%"+custName+"%"));
		}
		if (customer.getBaseDictSource()!=null&&customer.getBaseDictSource().getDict_id()!=null) {
			detachedCriteria.add(Restrictions.eq("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
		}
		if (customer.getBaseDictIndustry()!=null&&customer.getBaseDictIndustry().getDict_id()!=null) {
			detachedCriteria.add(Restrictions.eq("baseDictIndustry.dict_id", customer.getBaseDictIndustry().getDict_id()));
		}
		if (customer.getBaseDictLevel()!=null&&customer.getBaseDictLevel().getDict_id()!=null) {
			detachedCriteria.add(Restrictions.eq("baseDictLevel.dict_id", customer.getBaseDictLevel().getDict_id()));
		}
		PageBean<Customer> pageBean = customerService.findAll(detachedCriteria, current, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 客户删除
	 */
	public String delete() {
		customer = customerService.findById(customer.getCust_id());
		//删除图片
		if (customer.getCust_image() != null) {
			File file = new File(customer.getCust_image());
			file.delete();
		}
		customerService.delete(customer);
		return "delete";
	}
	
	/**
	 * 根据id查询客户并将数据输入到edit页面上
	 */
	public String edit() {
		customer = customerService.findById(customer.getCust_id());
		return "edit";
	}
	
	/**
	 * 客户修改
	 */
	public String update() {
		System.out.println(customer.getCust_mobile()+":"+customer.getCust_name());
		System.out.println(customer.getCust_id());
		String cust_image = customer.getCust_image();
		if (!"".equals(cust_image)||cust_image!=null) {
			File f = new File(cust_image);
			f.delete();
		}
		if (upload!=null) {
			//设置文件上传的路径
			String path = ServletActionContext.getRequest().getRealPath("imgs/");
			//处理文件名
			String fileName = Tool.dateFileName(uploadFileName);
			//目录分离
			String path2 = Tool.getPath(fileName);
			//创建目录
			File fi = new File(path);
			if (!fi.exists()) {
				fi.mkdirs();
			}
			//上传文件
			File file = new File(path+fileName);
			try {
				FileUtils.copyFile(upload, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			customer.setCust_image(path+fileName);
		}
		customerService.update(customer);
		return "update";
	}
	
	public String findAll1() {
		List<Customer> list = customerService.findAll1();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] {"linkManSet","baseDictSource","baseDictIndustry","baseDictLevel"});
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
		//将json打印到页面中
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=UTF-8");
		try {
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
}
