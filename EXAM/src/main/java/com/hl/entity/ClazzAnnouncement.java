package com.hl.entity;
import java.io.Serializable;
import java.sql.Date;
import com.hl.util.date.SimpleDateFormatUtil;

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
	
	private Integer caid;
	private Integer classid;
	private String classname;
	private Date catime;
	private String catitle;
	private String camsg;
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
	public String  getCatime() {//json数据类型对sql.date的不支持性，进行字符创转型。
		
		return SimpleDateFormatUtil.getInstance().format(catime);
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
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		return "ClazzAnnouncement [caid=" + caid + ", classid=" + classid + ", classname=" + classname + ", catime="
				+ catime + ", catitle=" + catitle + ", camsg=" + camsg + "]";
	}
	
	
}
