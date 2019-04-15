package com.gelai.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.gelai.bean.PageBean;
import com.gelai.bean.SaleVisit;
import com.gelai.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class SaleVisitAction implements ModelDriven<SaleVisit>{

	private SaleVisit saleVisit = new SaleVisit();
	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}
	
	private SaleVisitService saleVisitService;
	public SaleVisitService getSaleVisitService() {
		return saleVisitService;
	}
	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}
	
	private Integer current = 1;
	private Integer pageSize = 3;
	private String visit_time;
	private String visit_endtime;
	public Integer getCurrent() {
		return current;
	}
	public void setCurrent(Integer current) {
		if(current==null) {
			current = 1;
		}
		this.current = current;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize==null) {
			pageSize = 3;
		}
		this.pageSize = pageSize;
	}
	public String getVisit_time() {
		return visit_time;
	}
	public void setVisit_time(String visit_time) {
		this.visit_time = visit_time;
	}
	public String getVisit_endtime() {
		return visit_endtime;
	}
	public void setVisit_endtime(String visit_endtime) {
		this.visit_endtime = visit_endtime;
	}
	public String find() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
		if (visit_time!=null) {
			detachedCriteria.add(Restrictions.ge("visit_time", visit_time));
		}
		if (visit_endtime!=null) {
			detachedCriteria.add(Restrictions.le("visit_time", visit_endtime));
		}
		PageBean<SaleVisit> pageBean = saleVisitService.find(detachedCriteria,current,pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String saveUI() {
		
		return "saveUI";
	}
	
	/**
	 * 添加
	 * @return
	 */
	public String save() {
		saleVisitService.save(saleVisit);
		return "save";
	}
	
	/**
	 * 跳转到修改页面    并根据id获得值    并将值赋给页面
	 * @return
	 */
	public String edit() {
		saleVisit = saleVisitService.findById(saleVisit.getVisit_id());
		return "edit";
	}
	
	/**
	 * 修改
	 * @return
	 */
	public String update() {
		saleVisitService.update(saleVisit);
		return "update";
	}
	
	/**
	 * 删除
	 * @return
	 */
	public String delete() {
		saleVisitService.delete(saleVisit);
		return "delete";
	}
}
