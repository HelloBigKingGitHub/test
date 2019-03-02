package com.hl.entity;
/**
 * 班级详情实体类 （）
 * @author hl
 *
 */

import java.io.Serializable;
import java.util.List;

public class ClazzDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Userinfo teacher; //班级的班主任
	private List<Userinfo> students; //班级的学生
	private List<Homework> homeworks; //班级布置的作业
	private List<ClazzFile> ClazzFiles; //班级文件
	public Userinfo getTeacher() {
		return teacher;
	}
	public void setTeacher(Userinfo teacher) {
		this.teacher = teacher;
	}
	public List<Userinfo> getStudents() {
		return students;
	}
	public void setStudents(List<Userinfo> students) {
		this.students = students;
	}
	public List<Homework> getHomeworks() {
		return homeworks;
	}
	public void setHomeworks(List<Homework> homeworks) {
		this.homeworks = homeworks;
	}
	public List<ClazzFile> getClazzFiles() {
		return ClazzFiles;
	}
	public void setClazzFiles(List<ClazzFile> clazzFiles) {
		ClazzFiles = clazzFiles;
	}
	@Override
	public String toString() {
		return "ClazzDetail [teacher=" + teacher + ", students=" + students + ", homeworks=" + homeworks
				+ ", ClazzFiles=" + ClazzFiles + "]";
	}
	
	

}
