package com.gelai.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gelai.bean.BaseDict;
import com.gelai.dao.BaseDictDao;

public class BaseDictDaoImpl extends HibernateDaoSupport implements BaseDictDao {
	/**
	 * 字典类的dao的实现类
	 */
	
	/**
	 * 查询字典类将其赋值给添加页面
	 * @return
	 */
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		List<BaseDict> list = (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code=?", dict_type_code);
		return list;
	}
}
