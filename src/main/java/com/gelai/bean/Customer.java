package com.gelai.bean;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	/**
	 * `cust_id` bigint(32) NOT NULL auto_increment COMMENT '客户编号(主键)',
  `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
  `cust_user_id` bigint(32) default NULL COMMENT '负责人id',
  `cust_create_id` bigint(32) default NULL COMMENT '创建人id',
  `cust_source` varchar(32) default NULL COMMENT '客户信息来源',
  `cust_industry` varchar(32) default NULL COMMENT '客户所属行业',
  `cust_level` varchar(32) default NULL COMMENT '客户级别',
  `cust_linkman` varchar(64) default NULL COMMENT '联系人',
  `cust_phone` varchar(64) default NULL COMMENT '固定电话',
  `cust_mobile` varchar(16) default NULL COMMENT '移动电话',
	 */
	private Long cust_id;
	private String cust_name;
	/*private String cust_source; 
	private String cust_industry; 
	private String cust_level;*/
	/**
	 * 字典与客户成一对多关系，需要在一的一方配置多的对象
	 */
	private BaseDict baseDictSource;
	private BaseDict baseDictIndustry;
	private BaseDict baseDictLevel;
	private String cust_phone;
	private String cust_mobile;
	private String cust_image;
	private Set<LinkMan> linkManSet = new HashSet<LinkMan>();
	public Set<LinkMan> getLinkManSet() {
		return linkManSet;
	}
	public void setLinkManSet(Set<LinkMan> linkManSet) {
		this.linkManSet = linkManSet;
	}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	public BaseDict getBaseDictSource() {
		return baseDictSource;
	}
	public void setBaseDictSource(BaseDict baseDictSource) {
		this.baseDictSource = baseDictSource;
	}
	public BaseDict getBaseDictIndustry() {
		return baseDictIndustry;
	}
	public void setBaseDictIndustry(BaseDict baseDictIndustry) {
		this.baseDictIndustry = baseDictIndustry;
	}
	public BaseDict getBaseDictLevel() {
		return baseDictLevel;
	}
	public void setBaseDictLevel(BaseDict baseDictLevel) {
		this.baseDictLevel = baseDictLevel;
	}
	public String getCust_image() {
		return cust_image;
	}
	public void setCust_image(String cust_image) {
		this.cust_image = cust_image;
	}
}
