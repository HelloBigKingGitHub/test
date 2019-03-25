package com.hl.entity;

import java.io.Serializable;

/**
 * 对应数据库中班级文件表的实体类
 * @author hl
 *
 */
public class ClazzFile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cfid;
    private Clazz clazz;
    private File file;
    private String title;
	public Integer getCfid() {
		return cfid;
	}
	public void setCfid(Integer cfid) {
		this.cfid = cfid;
	}
	public Clazz getClazz() {
		return clazz;
	}
	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "ClazzFile [cfid=" + cfid + ", clazz=" + clazz + ", file=" + file + ", title=" + title + "]";
	}

    
}
