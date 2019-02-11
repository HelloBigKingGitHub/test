package com.hl.entity;

import java.io.Serializable;

/**
 * 用户成绩单的实体对象
 * @author admin
 *
 */
public class Score implements Serializable{

	private Integer upid; //记录id
	private Integer userid; //用户id
	private Integer pid;  //试卷id
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
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Score [upid=" + upid + ", userid=" + userid + ", pid=" + pid + ", score=" + score + "]";
	}
	
	
}
