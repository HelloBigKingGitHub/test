package com.hl.entity;

import java.io.Serializable;

/**
 * 对应数据库中作业表的实体类
 * @author hl
 *
 */
public class Homework implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer homeworkid; //作业编号
	private Integer issuerid;  //发布作业老师的编号
	private String title;      //作业标题
	private String format;    //作业形式
	private String content;   //作业内容
	
	public Integer getHomeworkid() {
		return homeworkid;
	}
	public void setHomeworkid(Integer homeworkid) {
		this.homeworkid = homeworkid;
	}
	public Integer getIssuerid() {
		return issuerid;
	}
	public void setIssuerid(Integer issuerid) {
		this.issuerid = issuerid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Homework [homeworkid=" + homeworkid + ", issuerid=" + issuerid + ", title=" + title + ", format="
				+ format + ", content=" + content + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((homeworkid == null) ? 0 : homeworkid.hashCode());
		result = prime * result + ((issuerid == null) ? 0 : issuerid.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Homework other = (Homework) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (homeworkid == null) {
			if (other.homeworkid != null)
				return false;
		} else if (!homeworkid.equals(other.homeworkid))
			return false;
		if (issuerid == null) {
			if (other.issuerid != null)
				return false;
		} else if (!issuerid.equals(other.issuerid))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	 

}
