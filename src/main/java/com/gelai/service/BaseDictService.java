package com.gelai.service;

import java.util.List;

import com.gelai.bean.BaseDict;

public interface BaseDictService {
	/**
	 * 字典类的业务层的接口
	 */
	
	/**
	 * 查询字典类将其赋值给添加页面
	 * @return
	 */
	public List<BaseDict> findByTypeCode(String dict_type_code);
}
