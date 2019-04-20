package com.hl.entity;

import java.io.Serializable;

/**
 * 成绩的详情实体类
 * @author hl
 *
 */
public class ScoreDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -77708519137295761L;
	

	private Integer upid; //记录id
	private Integer userid; //用户id
	private Paper paper;  //试卷id 一对一paper数据
	private double score;  //成绩
	public Integer getUpid() {
		return upid;
	}
	public void setUpid(Integer upid) {
		this.upid = upid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "ScoreDeetail [upid=" + upid + ", userid=" + userid + ", paper=" + paper + ", score=" + score + "]";
	}
	
	
}
