package com.hl.entity;

import java.io.Serializable;
import java.sql.Date;

import com.hl.util.date.SimpleDateFormatUtil;

/**
 * 
 * <p>Title: RPostBar</p>  
 * <p>Description: 回帖表实体类</p>  
 * @author huangliang 
 * @date 2019年4月24日
 */
public class RPostBar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8814787004797732997L;
	
	private Integer rpbid;
	private String rquescontent;
	private Date rqtime;
	private Integer userid;
	private Integer pbid;
	public Integer getRpbid() {
		return rpbid;
	}
	public void setRpbid(Integer rpbid) {
		this.rpbid = rpbid;
	}
	public String getRquescontent() {
		return rquescontent;
	}
	public void setRquescontent(String rquescontent) {
		this.rquescontent = rquescontent;
	}
	public String getRqtime() {
		return SimpleDateFormatUtil.getInstance().format(rqtime.getTime());
	}
	public void setRqtime(Date rqtime) {
		this.rqtime = rqtime;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getPbid() {
		return pbid;
	}
	public void setPbid(Integer pbid) {
		this.pbid = pbid;
	}
	
	

}
