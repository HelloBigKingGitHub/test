package com.hl.formbean;
/**
 * 登录页面表单的实体分装类
 * @author admin
 *
 */
public class LoginFormBean {

	
	private String usertel;//用户电话号码
	private String userpwd;//用户密码
	private String imgCode;//登录时输入的图片验证码信息
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
	public String getImgCode() {
		return imgCode;
	}
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	@Override
	public String toString() {
		return "LoginFormBean [usertel=" + usertel + ", userpwd=" + userpwd + ", imgCode=" + imgCode + "]";
	}
	
	
	
}
