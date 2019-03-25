package com.hl.entity;

import java.io.Serializable;

/**
 * 映射paper_check表的实体类
 * @author hl
 *
 */
public class PaperCheck implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6757043171870966026L;
	
	private Integer papercheckid; //审查记录id
	private Paper paper;          //被审查的试卷
	private Userinfo checkteacher; //审查试卷的老师
	private String checkcontent;   //审查的批语
	public Integer getPapercheckid() {
		return papercheckid;
	}
	public void setPapercheckid(Integer papercheckid) {
		this.papercheckid = papercheckid;
	}
	public Paper getPaper() {
		return paper;
	}
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public Userinfo getCheckteacher() {
		return checkteacher;
	}
	public void setCheckteacher(Userinfo checkteacher) {
		this.checkteacher = checkteacher;
	}
	public String getCheckcontent() {
		return checkcontent;
	}
	public void setCheckcontent(String checkcontent) {
		this.checkcontent = checkcontent;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "PaperCheck [papercheckid=" + papercheckid + ", paper=" + paper + ", checkteacher=" + checkteacher
				+ ", checkcontent=" + checkcontent + "]";
	}
	
	
	

}
