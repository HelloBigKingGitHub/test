package com.hl.service.impl;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.Course;
import com.hl.entity.File;
import com.hl.entity.Userinfo;
import com.hl.service.CourseService;
import com.hl.util.date.SimpleDateFormatUtil;

import net.sf.json.JSONObject;

public class CourseServiceImplTest extends BaseTest{
	
	@Autowired
	private CourseService courseSerivce;

	@Test
	public void testListCourseByTeacherid() {
		
		List<Course>list = courseSerivce.listCourseByTeacherid(6);
		JSONObject json = new JSONObject();
		json.put("list", list);
		System.out.println(json.toString());
	}
	
	@Test
	public void testString2Date() {
		String time = "2019-01-21";
		SimpleDateFormat  sdf = SimpleDateFormatUtil.getInstance();
		try {
			java.util.Date date = sdf.parse(time);
			Date sqlDate = new Date(date.getTime());
			System.out.println(sqlDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeleteCourse() {
		String courseid = "7";
		boolean deleteCourseByCourseid = courseSerivce.deleteCourseByCourseid(courseid);
		
		System.out.println(deleteCourseByCourseid);
	}
	
	@Test
	public void testGetFielFromCourse() {
		String courseid = "6";
		String fileType = "";
		List<File> listFileFromCourse = courseSerivce.listFileFromCourse(courseid, fileType);
		for (File file : listFileFromCourse) {
			System.out.println(file);
		}
	}
	
	@Test
	public void testListStudentCourse() {
		Userinfo user = new Userinfo();
		user.setUserid(3);
		String limit = "10";
		String page = "1";
		String coursename = null;
		Map<String, Object> listStudentCourse = courseSerivce.listStudentCourse(limit, page, coursename, user);
		List<Course> list = (List<Course>)listStudentCourse.get("list");
		for (Course course : list) {
			System.out.println(course);
		}
	}
	
	@Test
	public void testListCourse4Student() {
		
		String limit = "10";
		String page = "1";
		String teacherid = "";
		String teachername = "黄亮";
		String coursename = "";
		String starttime = "2019-04-01";
		String endtime = "2019-04-26";
		String coursedetail = "";
		Map<String, Object> listCourse4Student = courseSerivce.listCourse4Student(page, limit, teacherid, teachername, coursename, 
				starttime, endtime, coursedetail);
		List<Course> list = (List<Course>)listCourse4Student.get("list");
		for (Course course : list) {
			System.out.println(course);
		}
		
	}
	
	@Test
	public void testUserJoinCourse() {
		Userinfo user = new Userinfo();
		user.setUserid(3);
		String courseid = "7";
		int userJoinCourse = courseSerivce.userJoinCourse(user, courseid);
		System.out.println(userJoinCourse);
	}

}
