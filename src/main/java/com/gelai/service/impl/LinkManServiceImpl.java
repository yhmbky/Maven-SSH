package com.gelai.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.gelai.bean.LinkMan;
import com.gelai.bean.PageBean;
import com.gelai.dao.LinkManDao;
import com.gelai.service.LinkManService;

@Transactional
public class LinkManServiceImpl implements LinkManService {

	//注入dao
	private LinkManDao linkManDao;
	public LinkManDao getLinkManDao() {
		return linkManDao;
	}
	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
	
	/**
	 * 模糊查询加分页查询
	 */
	@Override
	public PageBean<LinkMan> findAll(DetachedCriteria detachedCriteria, Integer current,Integer pageSize) {
		PageBean<LinkMan> pageBean = new PageBean<LinkMan>();
		//封装当前页数
		pageBean.setCurrent(current);
		//封装每页记录数
		pageBean.setPageSize(pageSize);
		//封装总记录数
		Integer totalCount = linkManDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		Integer totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		pageBean.setTotalPage(totalPage);
		//封装每页查询到的数据集合
		//每页从哪开始
		Integer begin = (current-1)*pageSize;
		List<LinkMan> list = linkManDao.findAll(detachedCriteria, begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	/**
	 * 联系人添加
	 * @param linkMan
	 */
	@Override
	public void save(LinkMan linkMan) {
		linkManDao.save(linkMan);
	}
	
	/**
	 * 根据id查联系人
	 * @param lkm_id
	 * @return
	 */
	@Override
	public LinkMan findById(Long lkm_id) {
		return linkManDao.findById(lkm_id);
	}
	
	/**
	 * 修改联系人
	 * @param linkMan
	 */
	@Override
	public void update(LinkMan linkMan) {
		linkManDao.update(linkMan);
	}
	
	/**
	 * 删除联系人
	 */
	@Override
	public void delete(LinkMan linkMan) {
		linkManDao.delete(linkMan);
	}
	
	/**
	 * 查询全部联系人
	 */
	@Override
	public List<LinkMan> findAll1() {
		List<LinkMan> list = linkManDao.findAll1();
		return list;
	}
	
}
