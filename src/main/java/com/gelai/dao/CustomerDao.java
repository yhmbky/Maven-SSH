package com.gelai.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.gelai.bean.Customer;
import com.gelai.bean.PageBean;

public interface CustomerDao extends BaseDao<Customer>{
	
	/**
	 * 客户添加
	 */
	//public void save(Customer customer);
	
	/**
	 * 客户分页查找
	 */
	//public List<Customer> findAll(DetachedCriteria detachedCriteria,Integer begin,Integer pageSize);
	
	/**
	 * 查询总记录数
	 */
	//public Integer findCount(DetachedCriteria detachedCriteria);
	
	/**
	 * 根据id查询
	 */
	//public Customer findById(Long cust_id);
	
	/**
	 * 客户删除
	 */
	//public void delete(Customer customer);
	
	/**
	 * 客户修改
	 * @param customer
	 */
	//public void update(Customer customer);
	
	/**
	 * 查询全部客户
	 */
	//public List<Customer> findAll1();
}
