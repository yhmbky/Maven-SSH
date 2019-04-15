package com.gelai.dao;

import java.util.List;

import com.gelai.bean.BaseDict;

public interface BaseDictDao {
	/**
	 * 字典类的dao的接口
	 */
	
	/**
	 * 查询字典类将其赋值给添加页面
	 * @return
	 */
	public List<BaseDict> findByTypeCode(String dict_type_code);
}
