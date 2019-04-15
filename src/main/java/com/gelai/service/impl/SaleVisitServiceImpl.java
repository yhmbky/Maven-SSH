package com.gelai.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.gelai.bean.PageBean;
import com.gelai.bean.SaleVisit;
import com.gelai.dao.SaleVisitDao;
import com.gelai.service.SaleVisitService;

@Transactional
public class SaleVisitServiceImpl implements SaleVisitService {

	private SaleVisitDao saleVisitDao;
	public SaleVisitDao getSaleVisitDao() {
		return saleVisitDao;
	}
	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}
	
	/**
	 * 模糊查询加分页
	 */
	@Override
	public PageBean<SaleVisit> find(DetachedCriteria detachedCriteria, Integer current, Integer pageSize) {
		PageBean<SaleVisit> pageBean = new PageBean<SaleVisit>();
		//总记录数
		Integer totalCount = saleVisitDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//总页数
		Integer totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		pageBean.setTotalPage(totalPage);
		pageBean.setCurrent(current);
		pageBean.setPageSize(pageSize);
		//每页起始
		Integer begin = (current-1)*pageSize;
		List<SaleVisit> list = saleVisitDao.findAll(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	/**
	 * 添加
	 */
	@Override
	public void save(SaleVisit saleVisit) {
		saleVisitDao.save(saleVisit);
	}
	
	/**
	 * 根据id查询
	 */
	@Override
	public SaleVisit findById(Integer visit_id) {
		SaleVisit saleVisit = saleVisitDao.findById(visit_id);
		return saleVisit;
	}
	
	/**
	 * 修改
	 */
	@Override
	public void update(SaleVisit saleVisit) {
		saleVisitDao.update(saleVisit);
	}
	
	/**
	 * 删除
	 */
	@Override
	public void delete(SaleVisit saleVisit) {
		saleVisitDao.delete(saleVisit);
	}
	
}
