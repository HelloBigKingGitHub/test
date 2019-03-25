package com.hl.formbean;

/**
 * 负责接收用户设置表单数据的bean {email: "1330818611@qq.co", username: "hl", sex: "0", city: "湘潭", motto: "刷刷"}
 * @author hl
 *
 */
public class UserSetBean {
	private String email;
	private String username;
	private String sex;
	private String city;   //所处城市
	private String motto; //人生格言
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMotto() {
		return motto;
	}
	public void setMotto(String motto) {
		this.motto = motto;
	}
	@Override
	public String toString() {
		return "UserSetBean [email=" + email + ", username=" + username + ", sex=" + sex + ", city=" + city + ", motto="
				+ motto + "]";
	}
	
	
	
}
