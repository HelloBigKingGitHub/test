package com.hl.entity;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 
 * 数据库中clazz_announcement表对应的实体类
 * @author hl
 *
 */
public class ClazzAnnouncement implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8366848663681607221L;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private Integer caid;
	private Integer classid;
	private Date catime;
	private String catitle;
	private String camsg;
	@Override
	public String toString() {
		return "ClazzAnnouncement [caid=" + caid + ", classid=" + classid + ", catime=" + catime + ", catitle="
				+ catitle + ", camsg=" + camsg + "]";
	}
	
	
	public Integer getCaid() {
		return caid;
	}
	public void setCaid(Integer caid) {
		this.caid = caid;
	}
	public Integer getClassid() {
		return classid;
	}
	public void setClassid(Integer classid) {
		this.classid = classid;
	}
	public String  getCatime() {
		return sdf.format(catime);
	}
	public void setCatime(Date catime) {
		this.catime = catime;
	}
	public String getCatitle() {
		return catitle;
	}
	public void setCatitle(String catitle) {
		this.catitle = catitle;
	}
	public String getCamsg() {
		return camsg;
	}
	public void setCamsg(String camsg) {
		this.camsg = camsg;
	}
	
}
