package com.hl.service.impl;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.Course;
import com.hl.entity.File;
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

}
