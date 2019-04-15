package com.gelai.dao;

import com.gelai.bean.User;

public interface UserDao extends BaseDao<User>{

	/**
	 * 用户注册
	 */
	//public void save(User user);
	/**
	 * 用户登录
	 */
	public User login(User user);
}
