package com.hl.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 试题详情实体类
 * @author admin
 *
 */
public class SubjectDetail implements Serializable{

	
	private Integer testcount;  //测试次数
	private Integer errorcount;
	private List<Paper> papers;
	public Integer getTestcount() {
		return testcount;
	}
	public void setTestcount(Integer testcount) {
		this.testcount = testcount;
	}
	public Integer getErrorcount() {
		return errorcount;
	}
	public void setErrorcount(Integer errorcount) {
		this.errorcount = errorcount;
	}
	public List<Paper> getPapers() {
		return papers;
	}
	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}
	@Override
	public String toString() {
		return "SubjectDetail [testcount=" + testcount + ", errorcount=" + errorcount + ", papers=" + papers + "]";
	}
	
	
}
