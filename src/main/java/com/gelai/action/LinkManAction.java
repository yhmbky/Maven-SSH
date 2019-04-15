package com.gelai.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.gelai.bean.Customer;
import com.gelai.bean.LinkMan;
import com.gelai.bean.PageBean;
import com.gelai.service.CustomerService;
import com.gelai.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

	//注入service
	private LinkManService linkManService;
	private CustomerService customerService;
	public LinkManService getLinkManService() {
		return linkManService;
	}
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	//获得linkman
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		return linkMan;
	}
	
	private Integer current = 1;
	private Integer pageSize = 3;
	private String lkmName;
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
	public String getLkmName() {
		return lkmName;
	}
	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}
	/**
	 * 联系人分页查询
	 */ 
	public String find() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		if (lkmName!=null) {
			detachedCriteria.add(Restrictions.like("lkm_name", "%"+lkmName+"%"));
		}
		PageBean<LinkMan> pageBean = linkManService.findAll(detachedCriteria, current, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 跳转到添加页面并获取客户的数据
	 */
	public String saveUI() {
		//获得客户的全部数据
		List<Customer> list = customerService.findAll1();
		//将数据放入值栈
		ActionContext.getContext().getValueStack().set("LinkManlist", list);
		return "saveUI";
	}
	
	/**
	 * 添加联系人
	 */
	public String save() {
		linkManService.save(linkMan);
		return "save";
	}
	
	/**
	 * 修改联系人    获得客户的全部数据   获得该联系人的全部数据
	 */
	public String edit() {
		//获得客户的全部数据
		List<Customer> list = customerService.findAll1();
		//将数据放入值栈
		ActionContext.getContext().getValueStack().set("LinkManlist", list);
		linkMan = linkManService.findById(linkMan.getLkm_id());
		return "edit";
	}
	public String update() {
		linkManService.update(linkMan);
		return "update";
	}
	
	/**
	 * 删除联系人
	 */
	public String delete() {
		linkManService.delete(linkMan);
		return "delete";
	}
	
	/**
	 *查询全部联系人 
	 */
	public String findAll1() {
		List<LinkMan> list = linkManService.findAll1();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] {"customer"});
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
