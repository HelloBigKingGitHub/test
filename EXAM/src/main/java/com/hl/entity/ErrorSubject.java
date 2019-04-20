package com.hl.entity;

import java.io.Serializable;

/**
 * 有关，错题的实体类
 * @author admin
 *
 */
public class ErrorSubject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5407447560231314409L;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ekey == null) ? 0 : ekey.hashCode());
		result = prime * result + ((esid == null) ? 0 : esid.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErrorSubject other = (ErrorSubject) obj;
		if (ekey == null) {
			if (other.ekey != null)
				return false;
		} else if (!ekey.equals(other.ekey))
			return false;
		if (esid == null) {
			if (other.esid != null)
				return false;
		} else if (!esid.equals(other.esid))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
	

	
	
}
