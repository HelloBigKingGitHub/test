package com.hl.formbean;
/**
 * 负责接收前端注册表单中信息的Javabean类，需要与与数据库交互的实体bean类做区分
 * 前端表单中提交什么信息，此bean中就有哪些私有属性
 * @author admin
 *
 */
public class RegFormBean {
	private String usertel; //表单提交上来的电话号码
	private String userpwd;  //表单提交上来的密码
	private String phoneCode;  //表单提交上来的手机验证码
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
	public String getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}
	@Override
	public String toString() {
		return "RegFormBean [usertel=" + usertel + ", userpwd=" + userpwd + ", phoneCode=" + phoneCode + "]";
	}
	

}
