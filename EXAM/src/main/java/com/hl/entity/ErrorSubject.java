package com.hl.entity;

import java.io.Serializable;

/**
 * 有关，错题的实体类
 * @author admin
 *
 */
public class ErrorSubject implements Serializable{
	private Integer esid;
	private Integer userid;
	private String ekey;  //错误答案
	private Subject subject;
	@Override
	public String toString() {
		return "ErrorSubject [esid=" + esid + ", userid=" + userid + ", ekey=" + ekey + ", subject=" + subject + "]";
	}
	public Integer getEsid() {
		return esid;
	}
	public void setEsid(Integer esid) {
		this.esid = esid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getEkey() {
		return ekey;
	}
	public void setEkey(String ekey) {
		this.ekey = ekey;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	
}
