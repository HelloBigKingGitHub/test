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


	/**
	 * 
	 * <p>Title: listStudentCourse</p>  
	 * <p>Description: 展示学生所有的课程信息</p> 
	 * <p>data:2019年4月21日 下午2:38:42 </p> 
	 * @param userid
	 * @param coursename
	 * @return
	 */
	List<Course> listStudentCourse(@Param("userid")int userid, @Param("coursename")String coursename);


	/**
	 * 
	 * <p>Title: listCourse4Student</p>  
	 * <p>Description: 多条件为检索课程信息</p> 
	 * <p>data:2019年4月21日 下午3:33:42 </p> 
	 * @param teacheridInt
	 * @param teachername
	 * @param coursename
	 * @param starttime
	 * @param endtime
	 * @param coursedetail
	 * @return
	 */
	List<Course> listCourse4Student(@Param("teacherid")Integer teacheridInt, @Param("teachername")String teachername, 
			@Param("coursename")String coursename, @Param("starttime")String starttime, @Param("endtime")String endtime, 
			@Param("coursedetail")String coursedetail);


	/**
	 * 
	 * <p>Title: courseOfUserIsExist</p>  
	 * <p>Description: 判断user是否加入了课程</p> 
	 * <p>data:2019年4月22日 下午9:49:56 </p> 
	 * @param userid
	 * @param courseidInt
	 * @return
	 */
	int courseOfUserIsExist(@Param("userid")int userid, @Param("courseid")int courseid);


	/**
	 * 
	 * <p>Title: userJoinCourse</p>  
	 * <p>Description: 用户报名课程</p> 
	 * <p>data:2019年4月22日 下午10:10:43 </p> 
	 * @param userid
	 * @param courseidInt
	 * @return
	 */
	int userJoinCourse(@Param("userid")int userid, @Param("courseid")int courseid);

	/**
	 * 
	 * <p>Title: userExitCourse</p>  
	 * <p>Description: 学生退出课程</p> 
	 * <p>data:2019年4月22日 下午10:54:12 </p> 
	 * @param userid
	 * @param courseidInt
	 * @return
	 */
	int userExitCourse(@Param("userid")int userid, @Param("courseid")int courseid);
}
