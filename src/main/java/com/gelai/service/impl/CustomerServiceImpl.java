package com.gelai.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.gelai.bean.Customer;
import com.gelai.bean.PageBean;
import com.gelai.dao.CustomerDao;
import com.gelai.service.CustomerService;

@Transactional
public class CustomerServiceImpl implements CustomerService {

	//注入dao
	private CustomerDao customerDao;
	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	/**
	 * 客户添加
	 */
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}
	
	/**
	 * 客户分页查找
	 */
	@Override
	public PageBean<Customer> findAll(DetachedCriteria detachedCriteria, Integer current,Integer pageSize) {
		PageBean<Customer> pageBean = new PageBean<Customer>();
		//封装当前页数
		pageBean.setCurrent(current);
		//封装每页记录数
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = customerDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		Integer totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		pageBean.setTotalPage(totalPage);
		//封装每页查询到的数据集合
		//每页从哪开始
		Integer begin = (current-1)*pageSize;
		List<Customer> list = customerDao.findAll(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	/**
	 * 根据id查询
	 */
	@Override
	public Customer findById(Long cust_id) {
		Customer customer = customerDao.findById(cust_id);
		return customer;
	}
	/**
	 * 客户删除
	 */
	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}
	
	/**
	 * 客户修改
	 * @param customer
	 */
	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}
	
	/**
	 * 查询全部客户
	 */
	public List<Customer> findAll1(){
		List<Customer> list = customerDao.findAll1();
		return list;
		
	}
}
