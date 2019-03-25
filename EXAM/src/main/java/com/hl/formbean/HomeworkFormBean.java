package com.hl.formbean;

import java.util.Arrays;

/**
 * 封装作业表单数据的试题类
 * @author hl
 *
 */
public class HomeworkFormBean {
	//{h_title: "阿萨德", h_format: "", pname: "", vname: "", downline_desc: "啊撒打算大所大"}

	private String h_title; //作业的标题
	private String classid; //班级编号
	private String issuerid;//发布人的编号
	private String[] finishuserid;//完成人编号（只有教师对单独一个人或者部分人发布作业的时候才会传输该数据）
	private String h_format; //作业的形式 （视频或者考试）
	private String pname;   //试卷名称
	private String vname;   //视频名称
	private String downline_desc; //线下作业的内容描述
	
	
	public String getIssuerid() {
		return issuerid;
	}
	public void setIssuerid(String issuerid) {
		this.issuerid = issuerid;
	}
	public String getH_title() {
		return h_title;
	}
	public void setH_title(String h_title) {
		this.h_title = h_title;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String[] getFinishuserid() {
		return finishuserid;
	}
	public void setFinishuserid(String[] finishuserid) {
		this.finishuserid = finishuserid;
	}
	public String getH_format() {
		return h_format;
	}
	public void setH_format(String h_format) {
		this.h_format = h_format;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getDownline_desc() {
		return downline_desc;
	}
	public void setDownline_desc(String downline_desc) {
		this.downline_desc = downline_desc;
	}
	@Override
	public String toString() {
		return "HomeworkFormBean [h_title=" + h_title + ", classid=" + classid + ", issuerid=" + issuerid
				+ ", finishuserid=" + Arrays.toString(finishuserid) + ", h_format=" + h_format + ", pname=" + pname
				+ ", vname=" + vname + ", downline_desc=" + downline_desc + "]";
	}
	
	
	
	
}
