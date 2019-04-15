package com.gelai.service;

import java.util.List;

import com.gelai.bean.User;

public interface UserService {

	/**
	 * 用户注册
	 */
	public void regist(User user);
	/**
	 * 用户登录
	 */
	public User login(User user);
	
	/**
	 * 查询全部用户
	 */
	public List<User> findAll1();
}
