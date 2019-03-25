package com.hl.entity;

import java.io.Serializable;

/**
 * 对应文件表的实体类
 * @author admin
 *
 */
public class File implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 522130088496980L;
	
	private Integer fileid;
	private String filename;    //文件名
	private String fileurl;      //文件网络访问路径
	private String uploadpath;  //上传本地路径
	private String type;
	public Integer getFileid() {
		return fileid;
	}
	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	public String getUploadpath() {
		return uploadpath;
	}
	public void setUploadpath(String uploadpath) {
		this.uploadpath = uploadpath;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "File [fileid=" + fileid + ", filename=" + filename + ", fileurl=" + fileurl + ", uploadpath="
				+ uploadpath + ", type=" + type + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileid == null) ? 0 : fileid.hashCode());
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + ((fileurl == null) ? 0 : fileurl.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uploadpath == null) ? 0 : uploadpath.hashCode());
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
		File other = (File) obj;
		if (fileid == null) {
			if (other.fileid != null)
				return false;
		} else if (!fileid.equals(other.fileid))
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (fileurl == null) {
			if (other.fileurl != null)
				return false;
		} else if (!fileurl.equals(other.fileurl))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (uploadpath == null) {
			if (other.uploadpath != null)
				return false;
		} else if (!uploadpath.equals(other.uploadpath))
			return false;
		return true;
	}
	
	

}
