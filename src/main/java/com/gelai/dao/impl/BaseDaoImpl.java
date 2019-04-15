package com.gelai.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gelai.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	//使用构造方法获得class
//	//提供构造方法：在构造方法内传入具体的值
//	public BaseDaoImpl(Class clas) {
//		this.clas = clas;
//	}
//
	private Class clas;
	//通过反射机制获得class
	public BaseDaoImpl() {
		//正在被调用的那个类的class
		Class clas = this.getClass();
		//获得带有泛型的父类
		Type type = clas.getGenericSuperclass();
		//将type强转成参数化类型
		ParameterizedType  pa = (ParameterizedType) type;
		//通过参数化类型获得实际化类型参数    得到一个实际类型参数的数组
		Type[] types = pa.getActualTypeArguments();
		//得到第一个实际类型参数
		this.clas = (Class) types[0];
		
	}

	
	
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(clas, id);
	}

	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		int count = 0;
		if (list.size()>0) {
			count = list.get(0).intValue();
		}
		return count;
	}
	
	@Override
	public List<T> findAll(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

	@Override
	public List<T> findAll1() {
		return (List<T>) this.getHibernateTemplate().find("from "+clas.getSimpleName());
	}


}
