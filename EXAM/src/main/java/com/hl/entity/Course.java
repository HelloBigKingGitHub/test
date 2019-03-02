package com.hl.entity;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 有关课程表的试题类
 * @author hl
 *
 */
public class Course implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer courseid;
	private String coursename;  //课程名字
	private Integer teacherid; //老师编号
	private String coursedetail; //课程详细信息描述
	private Date strattime; //课程开始时间
	private Date endtime;  //课程介绍时间
	public Integer getCourseid() {
		return courseid;
	}
	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public Integer getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}
	public String getCoursedetail() {
		return coursedetail;
	}
	public void setCoursedetail(String coursedetail) {
		this.coursedetail = coursedetail;
	}
	public String getStrattime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return  df.format(strattime);
	}
	public void setStrattime(Date strattime) {
		this.strattime = strattime;
	}
	public String getEndtime() {  
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //进行格式化处理转化为字符串是应为包含sql.date数据的对象在json中的toString方法中会报错
		return  df.format(strattime);
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", coursename=" + coursename + ", teacherid=" + teacherid
				+ ", coursedetail=" + coursedetail + ", strattime=" + strattime.toString() + ", endtime=" + endtime.toString() + "]";
	}
	
	

}
