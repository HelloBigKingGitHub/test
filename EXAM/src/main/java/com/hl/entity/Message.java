package com.hl.entity;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * 对应数据库message表的实体类
 * @author hl
 *
 */
public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7430230237740033610L;
	
	private Integer messageid;
	private Userinfo sendUser;  //消息发送人
	private Userinfo receiveUser;  //消息接受人
	private String mtitle;
	private String msg;
	private String mtype;
	private Date mtime;
	private Integer mstate;
	public Integer getMessageid() {
		return messageid;
	}
	public void setMessageid(Integer messageid) {
		this.messageid = messageid;
	}
	public Userinfo getSendUser() {
		return sendUser;
	}
	public void setSendUser(Userinfo sendUser) {
		this.sendUser = sendUser;
	}
	public Userinfo getReceiveUser() {
		return receiveUser;
	}
	public void setReceiveUser(Userinfo receiveUser) {
		this.receiveUser = receiveUser;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMtype() {
		return mtype;
	}
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}
	public String getMtime() {
		String dateStr = "0000-00-00";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		dateStr = sdf.format(new java.util.Date(mtime.getTime()));
		return dateStr;//日期转化，json格式不支持sql日期类型
	}
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	public Integer getMstate() {
		return mstate;
	}
	public void setMstate(Integer mstate) {
		this.mstate = mstate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Message [messageid=" + messageid + ", sendUser=" + sendUser + ", receiveUser=" + receiveUser
				+ ", mtitle=" + mtitle + ", msg=" + msg + ", mtype=" + mtype + ", mtime=" + mtime + ", mstate=" + mstate
				+ "]";
	}
	
	

}
