package com.hl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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

	
	/**
	 * 
	 * <p>Title: insert</p>  
	 * <p>Description: 插入课程信息，需要映射id值</p> 
	 * <p>data:2019年4月18日 下午10:39:52 </p> 
	 * @param course
	 * @return
	 */
	int insertCourse(Course course);

	/**
	 * 
	 * <p>Title: insertCourseFile</p>  
	 * <p>Description: 为课程添加文件</p> 
	 * <p>data:2019年4月18日 下午10:39:56 </p> 
	 * @param courseid
	 * @param fileid
	 * @return
	 */
	int insertCourseFile(@Param("courseid") int courseid, @Param("fileid")int fileid);


	/**
	 * 
	 * <p>Title: listCourseByTeacheridAndCoursename</p>  
	 * <p>Description: 根据课程创建教师，和课程名称来分页查询课程信息</p> 
	 * <p>data:2019年4月20日 下午3:42:13 </p> 
	 * @param userid
	 * @param coursename
	 * @return
	 */
	List<Course> listCourseByTeacheridAndCoursename(@Param("userid")int userid, @Param("coursename")String coursename);

	
	
	/**
	 * 
	 * <p>Title: deleteCourseByCourseid</p>  
	 * <p>Description: 根据指定的课程id删除课程</p> 
	 * <p>data:2019年4月20日 下午5:52:45 </p> 
	 * @param courseidInt
	 * @return
	 */
	int deleteCourseByCourseid(int courseidInt);
}
