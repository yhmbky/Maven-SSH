package com.gelai.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gelai.bean.User;
import com.gelai.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	private User user1;
	public User getUser1() {
		return user1;
	}
	public void setUser1(User user1) {
		this.user1 = user1;
	}

	//注入UserService
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/**
	 * 注册
	 * @return
	 */
	public String regist() {
		userService.regist(user);
		return "login";
	}
	
	/**
	 * 登录
	 * @return
	 */
	public String login() {
		User user2 = userService.login(user);
		String str = "";
		if (user2!=null) {
			//登录成功
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", user2);
			str = "success";
		} else {
			//登录失败
			//添加错误信息
			this.addActionError("账号或密码错误");
			str = "login";
		}
		return str;
	}
	
	/**
	 * 查询全部用户
	 */
	public String findAll1() {
		List<User> list = userService.findAll1();
		JSONArray jsonArray = JSONArray.fromObject(list);
		//将json打印到页面中
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=UTF-8");
		try {
			response.getWriter().print(jsonArray.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NONE;
	}
}
