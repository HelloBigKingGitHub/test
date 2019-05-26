package com.hl.entity;

import java.io.Serializable;

/**
 * 
 * <p>Title: ClassApply</p>  
 * <p>Description: 班级申请信息实体类</p>  
 * @author huangliang 
 * @date 2019年5月4日
 */
public class ClassApply implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5804403282354738255L;
	
	@Override
	public String toString() {
		return "ClassApply [clazz=" + clazz + ", userinfo=" + userinfo + ", applyid=" + applyid + "]";
	}
	private Clazz clazz;
	private Userinfo userinfo;
	private int applyid;
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	public int getApplyid() {
		return applyid;
	}
	public void setApplyid(int applyid) {
		this.applyid = applyid;
	}
	

}
