package com.hl.entity;

import java.io.Serializable;

public class Subject implements Serializable{

	public Integer sid;//题目的编号
	public Integer testcount;//测试次数
	public Integer sstate;//题目状态 0禁用  1启用
	public String scontent;//题目题干的内容
	public String skey;//题目的答案
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getTestcount() {
		return testcount;
	}
	public void setTestcount(Integer testcount) {
		this.testcount = testcount;
	}
	public Integer getSstate() {
		return sstate;
	}
	public void setSstate(Integer sstate) {
		this.sstate = sstate;
	}
	public String getScontent() {
		return scontent;
	}
	public void setScontent(String scontent) {
		this.scontent = scontent;
	}
	public String getSkey() {
		return skey;
	}
	public void setSkey(String skey) {
		this.skey = skey;
	}
	@Override
	public String toString() {
		return "Subject [sid=" + sid + ", testcount=" + testcount + ", sstate=" + sstate + ", scontent=" + scontent
				+ ", skey=" + skey + "]";
	}

	
}
