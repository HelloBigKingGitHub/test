package com.hl.entity;

import java.io.Serializable;

/**
 * 考试系统用户的基本信息实体类
 * @author hl
 *
 */
public class Userinfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer userid; //用户id
	private Integer roleid; //用户角色id
	private String usertel; //用户电话号码，登录时使用
	private String userpwd;  //用户密码
	private String usertruename; //用户这是姓名
	private Integer userstate; //用户的状态
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsertruename() {
		return usertruename;
	}
	public void setUsertruename(String usertruename) {
		this.usertruename = usertruename;
	}
	public Integer getUserstate() {
		return userstate;
	}
	public void setUserstate(Integer userstate) {
		this.userstate = userstate;
	}
	@Override
	public String toString() {
		return "Userinfo [userid=" + userid + ", roleid=" + roleid + ", usertel=" + usertel + ", userpwd=" + userpwd
				+ ", usertruename=" + usertruename + ", userstate=" + userstate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roleid == null) ? 0 : roleid.hashCode());
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		result = prime * result + ((userpwd == null) ? 0 : userpwd.hashCode());
		result = prime * result + ((userstate == null) ? 0 : userstate.hashCode());
		result = prime * result + ((usertel == null) ? 0 : usertel.hashCode());
		result = prime * result + ((usertruename == null) ? 0 : usertruename.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Userinfo other = (Userinfo) obj;
		if (roleid == null) {
			if (other.roleid != null)
				return false;
		} else if (!roleid.equals(other.roleid))
			return false;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		if (userpwd == null) {
			if (other.userpwd != null)
				return false;
		} else if (!userpwd.equals(other.userpwd))
			return false;
		if (userstate == null) {
			if (other.userstate != null)
				return false;
		} else if (!userstate.equals(other.userstate))
			return false;
		if (usertel == null) {
			if (other.usertel != null)
				return false;
		} else if (!usertel.equals(other.usertel))
			return false;
		if (usertruename == null) {
			if (other.usertruename != null)
				return false;
		} else if (!usertruename.equals(other.usertruename))
			return false;
		return true;
	}


}
