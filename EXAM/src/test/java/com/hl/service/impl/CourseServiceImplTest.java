package com.hl.service.impl;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.Course;
import com.hl.service.CourseService;

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

}
