package com.hl.formbean;

public class ClazzFormBean {
	
	private String classname;
	private String classdesrible;
	private String classtype;
	private String classstate;
	private String maxclasspeople;
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
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
	public String getClassstate() {
		return classstate;
	}
	public void setClassstate(String classstate) {
		this.classstate = classstate;
	}
	public String getMaxclasspeople() {
		return maxclasspeople;
	}
	public void setMaxclasspeople(String maxclasspeople) {
		this.maxclasspeople = maxclasspeople;
	}
	@Override
	public String toString() {
		return "ClazzFormBean [classname=" + classname + ", classdesrible=" + classdesrible + ", classtype=" + classtype
				+ ", classstate=" + classstate + ", maxclasspeople=" + maxclasspeople + "]";
	}
	
	

}
