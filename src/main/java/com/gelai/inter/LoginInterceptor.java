package com.gelai.inter;

import org.apache.struts2.ServletActionContext;

import com.gelai.action.UserAction;
import com.gelai.bean.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断session中是否有登陆信息
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
		if (user!=null) {
			invocation.invoke();
		} else {
			return "login";
		}
		return null;
	}

}
