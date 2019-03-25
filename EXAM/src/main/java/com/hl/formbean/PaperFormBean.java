package com.hl.formbean;

import java.util.List;

public class PaperFormBean {

	private String pname;  //试卷标题
	private String ptime; //考试时间
	private String paggregatescore;  //试卷总分
	private String checkteacher;     //审查老师
	private List<String> subjectidList;  //试卷中试题编号集合
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public String getPaggregatescore() {
		return paggregatescore;
	}
	public void setPaggregatescore(String paggregatescore) {
		this.paggregatescore = paggregatescore;
	}
	public String getCheckteacher() {
		return checkteacher;
	}
	public void setCheckteacher(String checkteacher) {
		this.checkteacher = checkteacher;
	}
	public List<String> getSubjectidList() {
		return subjectidList;
	}
	public void setSubjectidList(List<String> subjectidList) {
		this.subjectidList = subjectidList;
	}
	@Override
	public String toString() {
		return "PaperFormBean [pname=" + pname + ", ptime=" + ptime + ", paggregatescore=" + paggregatescore
				+ ", checkteacher=" + checkteacher + ", subjectidList=" + subjectidList + "]";
	}
	
	
}
