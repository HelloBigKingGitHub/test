package com.hl.entity;

import java.io.Serializable;

/**
 * 对应班级表的实体类
 * @author hl
 *
 */
public class Clazz implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer classid;
	private String classname;
	private Integer classteacherid; //班主任id （数据库中对应外键是用户id）
	private Integer peoplenum;    //班级中的人数
	private Integer maxpeoplenum;  //班级允许最大的人数
	private String classdesrible;  //描述（或者是班主任寄语）
	private String classtype;      //班级类型
	private Integer classstate;    //班级状态
	public String getClassdesrible() {
		return classdesrible;
	}
	public void setClassdesrible(String classdesrible) {
		this.classdesrible = classdesrible;
	}
	public String getClasstype() {
		return classtype;
	}
	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}
	public Integer getClassstate() {
		return classstate;
	}
	public void setClassstate(Integer classstate) {
		this.classstate = classstate;
	}
	private ClazzDetail clazzDetail; //班级详细信息 多表连接 （一对一）
	
	public ClazzDetail getClazzDetail() {
		return clazzDetail;
	}
	public void setClazzDetail(ClazzDetail clazzDetail) {
		this.clazzDetail = clazzDetail;
	}
	public Integer getClassid() {
		return classid;
	}
	public void setClassid(Integer classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public Integer getClassteacherid() {
		return classteacherid;
	}
	public void setClassteacherid(Integer classteacherid) {
		this.classteacherid = classteacherid;
	}
	public Integer getPeoplenum() {
		return peoplenum;
	}
	public void setPeoplenum(Integer peoplenum) {
		this.peoplenum = peoplenum;
	}
	public Integer getMaxpeoplenum() {
		return maxpeoplenum;
	}
	public void setMaxpeoplenum(Integer maxpeoplenum) {
		this.maxpeoplenum = maxpeoplenum;
	}
	@Override
	public String toString() {
		return "Clazz [classid=" + classid + ", classname=" + classname + ", classteacherid=" + classteacherid
				+ ", peoplenum=" + peoplenum + ", maxpeoplenum=" + maxpeoplenum + ", classdesrible=" + classdesrible
				+ ", classtype=" + classtype + ", classstate=" + classstate + ", clazzDetail=" + clazzDetail + "]";
	}

	
}
