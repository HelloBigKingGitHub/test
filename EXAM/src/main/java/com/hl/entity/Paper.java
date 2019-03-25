package com.hl.entity;

import java.io.Serializable;

/**
 * 试卷的实体类
 * @author hl
 *
 */
public class Paper implements Serializable{

	private Integer pid; //试卷编号
	private String pname;//试卷名称
	private Integer pstate;//试卷的状态 0表示禁用 1表示启用
	private Integer teacherid; //组编老师编号
	public Integer getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}
	private PaperDetail pdetail;//试卷的详细信息（为一个对象，实行数据库表的一对一）
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getPstate() {
		return pstate;
	}
	public void setPstate(Integer pstate) {
		this.pstate = pstate;
	}
	public PaperDetail getPdetail() {
		return pdetail;
	}
	public void setPdetail(PaperDetail pdetail) {
		this.pdetail = pdetail;
	}
	@Override
	public String toString() {
		return "Paper [pid=" + pid + ", pname=" + pname + ", pstate=" + pstate + ", teacherid=" + teacherid
				 + "]";
	}
	

}
