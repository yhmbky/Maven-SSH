package com.gelai.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gelai.bean.Customer;

public interface BaseDao<T> {

	/**
	 * 添加
	 * @param t
	 */
	public void save(T t);
	
	/**
	 * 修改
	 * @param t
	 */
	public void update(T t);
	
	/**
	 * 删除
	 * @param t
	 */
	public void delete(T t);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public T findById(Serializable id);
	
	/**
	 * 查询总记录数
	 */
	public Integer findCount(DetachedCriteria detachedCriteria);
	
	/**
	 * 模糊查询加分页
	 */
	public List<T> findAll(DetachedCriteria detachedCriteria,Integer begin,Integer pageSize);
	
	/**
	 * 查询全部客户
	 */
	public List<T> findAll1();
	
}
