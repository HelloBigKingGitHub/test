package com.hl.entity;

import java.io.Serializable;

/**
 * 对应数据库表中userdetail表的实体类
 * @author admin
 *
 */
public class UserDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6356836850815692071L;
	
	private Integer udid;
	private Userinfo user;
	private String sex;
	private String motto;//人生格言
	private Integer follow; //跟随人数
	private String icon;//头像图片路径
	private String email; //邮件地址
	private String ucity;//所在城市
	public Integer getUdid() {
		return udid;
	}
	public void setUdid(Integer udid) {
		this.udid = udid;
	}
	public Userinfo getUser() {
		return user;
	}
	public void setUser(Userinfo user) {
		this.user = user;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	public Integer getFollow() {
		return follow;
	}
	public void setFollow(Integer follow) {
		this.follow = follow;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserDetail [udid=" + udid + ", user=" + user + ", sex=" + sex + ", motto=" + motto + ", follow="
				+ follow + ", icon=" + icon + ", email=" + email + ", ucity=" + ucity + "]";
	}
	
	
	

}
