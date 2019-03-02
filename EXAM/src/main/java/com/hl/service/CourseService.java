package com.hl.service;

import java.util.List;

import com.hl.entity.Course;

/**
 * 负责管理课程的服务层
 * @author hl
 *
 */
public interface CourseService {

	/**
	 * 通过老师id查询出所有符合条件的课程
	 * @param teacherid
	 * @return 课程集合
	 */
	List<Course> listCourseByTeacherid(Integer teacherid);
	
	
	

}
