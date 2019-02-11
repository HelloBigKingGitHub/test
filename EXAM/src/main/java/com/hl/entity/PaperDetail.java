package com.hl.entity;

import java.io.Serializable;

/**
 * 试卷的详细信息记录实体
 * @author hl
 *
 */
public class PaperDetail implements Serializable{
	private Paper paper; //实现一对一关联
	private double  paggregatescore;//试卷的总分
	private String ptime;//试卷的考试时间
	private Integer testdegree;//试卷测试次数
	private double avescore;//试卷考试的平均分
	private Integer pdid;//试卷详细信息记录id好
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public double getPaggregatescore() {
		return paggregatescore;
	}
	public void setPaggregatescore(double paggregatescore) {
		this.paggregatescore = paggregatescore;
	}
	public String getPtime() {
		return ptime;
	}
	public void setPtime(String ptime) {
		this.ptime = ptime;
	}
	public Integer getTestdegree() {
		return testdegree;
	}
	public void setTestdegree(Integer testdegree) {
		this.testdegree = testdegree;
	}
	public double getAvescore() {
		return avescore;
	}
	public void setAvescore(double avescore) {
		this.avescore = avescore;
	}
	public Integer getPdid() {
		return pdid;
	}
	public void setPdid(Integer pdid) {
		this.pdid = pdid;
	}
	@Override
	public String toString() {
		return "PaperDetail [paper=" + paper + ", paggregatescore=" + paggregatescore + ", ptime=" + ptime
				+ ", testdegree=" + testdegree + ", avescore=" + avescore + ", pdid=" + pdid + "]";
	}
	

}
