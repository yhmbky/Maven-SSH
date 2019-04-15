package com.gelai.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.gelai.bean.BaseDict;
import com.gelai.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {

	private BaseDict baseDict = new BaseDict();
	@Override
	public BaseDict getModel() {
		// TODO Auto-generated method stub
		return baseDict;
	}
	
	//注入baseDictService
	private BaseDictService baseDictService;
	public BaseDictService getBaseDictService() {
		return baseDictService;
	}
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	public String findByTypeCode() {
		//调用业务层
		List<BaseDict> list = baseDictService.findByTypeCode(baseDict.getDict_type_code());
		//将list转成json
		/** 
		 * JSONArray : 将数组和list集合转为json
		 * JSONObject : 将对象和map集合转为json
		 * JsonConfig : 转json的配置文件
		 * */
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[] {"dict_enable","dict_memo","dict_sort"});
		JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
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
