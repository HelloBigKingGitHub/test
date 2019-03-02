package com.hl.mapper;

import java.util.List;

import com.hl.entity.Course;

/**
 * 对数据库中课程表操作的mapper接口
 * @author hl
 *
 */
public interface CourseMapper {

	/**
	 * 根据老师的编号查询出老师所教学的课程
	 * @param teacherid
	 * @return 课程列表
	 */
	List<Course> listCourseByTeacherid(Integer teacherid);
}
