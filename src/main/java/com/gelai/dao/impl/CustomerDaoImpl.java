package com.gelai.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gelai.bean.Customer;
import com.gelai.bean.PageBean;
import com.gelai.dao.CustomerDao;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

//	public CustomerDaoImpl() {
//		super(Customer.class);
//	}
	
	/**
	 * 客户添加
	 */
//	public void save(Customer customer) {
//		this.getHibernateTemplate().save(customer);
//	}
	

	/**
	 * 模糊查询加查询总记录数
	 */
//	@Override
//	public Integer findCount(DetachedCriteria detachedCriteria) {
//		detachedCriteria.setProjection(Projections.rowCount());
//		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
//		int count = 0;
//		if (list.size()>0) {
//			count = list.get(0).intValue();
//		}
//		return count;
//	}
	
	/**
	 * 模糊查询加客户分页查找
	 */
//	public List<Customer> findAll(DetachedCriteria detachedCriteria,Integer begin,Integer pageSize) {
//		detachedCriteria.setProjection(null);
//		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
//		return list;
//	}

	
	/**
	 * 根据id查询
	 */
//	@Override
//	public Customer findById(Long cust_id) {
//		Customer customer = this.getHibernateTemplate().get(Customer.class, cust_id);
//		return customer;
//	}

	/**
	 * 客户删除
	 */
//	@Override
//	public void delete(Customer customer) {
//		this.getHibernateTemplate().delete(customer);
//	}

	/**
	 * 客户修改
	 * @param customer
	 */
//	@Override
//	public void update(Customer customer) {
//		this.getHibernateTemplate().update(customer);
//	}
	
	/**
	 * 查询全部客户
	 */
//	public List<Customer> findAll1(){
//		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
//	}
}
