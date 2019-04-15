package com.gelai.service.impl;

import java.util.List;

import com.gelai.bean.BaseDict;
import com.gelai.dao.BaseDictDao;
import com.gelai.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	/**
	 * 字典类的业务层的实现类
	 */
	
	//注入baseDictDao
	private BaseDictDao baseDictDao;
	public BaseDictDao getBaseDictDao() {
		return baseDictDao;
	}
	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}
	
	/**
	 * 查询字典类将其赋值给添加页面
	 * @return
	 */
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		List<BaseDict> list = baseDictDao.findByTypeCode(dict_type_code);
		return list;
	}
}
