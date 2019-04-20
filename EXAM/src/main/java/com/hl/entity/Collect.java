package com.hl.entity;

import java.io.Serializable;

/**
 * 
 * <p>Title: Collect</p>  
 * <p>Description:用户收集表对应的试题类 </p>  
 * @author huangliang 
 * @date 2019年4月15日
 */
public class Collect implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 638534109031283787L;
	
	private int collectid;
	private int sid;
	private int pid;
	private int userid;
	private String contentType;
	public int getCollectid() {
		return collectid;
	}
	public void setCollectid(int collectid) {
		this.collectid = collectid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	@Override
	public String toString() {
		return "Collect [collectid=" + collectid + ", sid=" + sid + ", pid=" + pid + ", userid=" + userid
				+ ", contentType=" + contentType + "]";
	}
	

}
