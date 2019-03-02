package com.hl.entity;

import java.io.Serializable;

public class VideoFile implements Serializable{
	
	private Integer fileid;
	private Integer courseid;
	private String filename;
	private String url;
	private String uploadpath;
	public String getUploadpath() {
		return uploadpath;
	}
	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}
	public Integer getFileid() {
		return fileid;
	}
	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}
	public Integer getCourseid() {
		return courseid;
	}
	public void setCourseid(Integer courseid) {
		this.courseid = courseid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "VideoFile [fileid=" + fileid + ", courseid=" + courseid + ", filename=" + filename + ", url=" + url
				+ ", uploadpath=" + uploadpath + "]";
	}
	
	
	

}
