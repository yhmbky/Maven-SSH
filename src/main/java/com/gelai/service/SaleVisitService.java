package com.gelai.service;

import org.hibernate.criterion.DetachedCriteria;

import com.gelai.bean.PageBean;
import com.gelai.bean.SaleVisit;

public interface SaleVisitService {

	/**
	 * 模糊查询加分页
	 */
	public PageBean<SaleVisit> find(DetachedCriteria detachedCriteria, Integer current, Integer pageSize);

	/**
	 * 添加
	 */
	public void save(SaleVisit saleVisit);

	/**
	 * 根据id查询
	 */
	public SaleVisit findById(Integer visit_id);
	
	/**
	 * 修改
	 */
	public void update(SaleVisit saleVisit);
	
	/**
	 * 删除
	 */
	public void delete(SaleVisit saleVisit);

}
