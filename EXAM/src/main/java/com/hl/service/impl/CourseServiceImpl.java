package com.hl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.entity.Course;
import com.hl.entity.VideoFile;
import com.hl.mapper.CourseMapper;
import com.hl.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseMapper courseMapper;

	@Override
	public List<Course> listCourseByTeacherid(Integer teacherid) {
		
		return courseMapper.listCourseByTeacherid(teacherid);
	}


	

}
