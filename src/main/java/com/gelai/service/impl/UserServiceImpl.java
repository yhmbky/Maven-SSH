package com.gelai.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gelai.bean.User;
import com.gelai.dao.UserDao;
import com.gelai.service.UserService;
import com.gelai.util.Tool;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class UserServiceImpl implements UserService {

	//注入dao
	private UserDao userDao;
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	/**
	 * 用户注册
	 */
	@Override
	public void regist(User user) {
		//将密码进行加密存储   防止密码泄露
		String user_password = Tool.md5(user.getUser_password());
		user.setUser_password(user_password);
		user.setUser_state("1");
		userDao.save(user);
	}
	
	/**
	 * 用户登录
	 */
	@Override
	public User login(User user) {
		//将密码进行加密
		user.setUser_password(Tool.md5(user.getUser_password()));
		User user2 = userDao.login(user);
		return user2;
	}
	/**
	 * 查询全部用户
	 */
	@Override
	public List<User> findAll1() {
		List<User> list = userDao.findAll1();
		return list;
	}

}
