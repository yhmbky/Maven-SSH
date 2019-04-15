package com.gelai.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.gelai.bean.User;
import com.gelai.dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

//	public UserDaoImpl() {
//		super(User.class);
//	}

	/**
	 * 用户注册
	 */
//	@Override
//	public void save(User user) {
//		this.getHibernateTemplate().save(user);
//	}

	/**
	 * 用户登录
	 */
	@Override
	public User login(User user) {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password=?", user.getUser_code(),user.getUser_password());
		User user2 = null;
		if (list.size()>0) {
			user2 = list.get(0);
		}
		return user2;
	}

}
