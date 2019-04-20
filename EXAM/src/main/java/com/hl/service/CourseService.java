package com.hl.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.hl.entity.Course;
import com.hl.entity.File;
import com.hl.entity.Userinfo;

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

	
	/**
	 * 
	 * <p>Title: addFileToCourse</p>  
	 * <p>Description: 为课程添加文件</p> 
	 * <p>data:2019年4月18日 下午10:34:42 </p> 
	 * @param courseid
	 * @param fileid
	 * @return
	 */
	boolean addFileToCourse(int courseid, int fileid);

	/**
	 * 
	 * <p>Title: addCourse</p>  
	 * <p>Description: 添加课程(老师行为)</p> 
	 * <p>data:2019年4月18日 下午9:37:40 </p> 
	 * @param user
	 * @param file
	 * @param request
	 * @param course
	 * @return
	 */
	boolean addCourse(Userinfo user, MultipartFile file, HttpServletRequest request, String coursedetail,
			String coursename, String starttime, String endtime);


	/**
	 * 
	 * <p>Title: listCourseByTeacher</p>  
	 * <p>Description: 分页展示老师开设的课程</p> 
	 * <p>data:2019年4月20日 下午3:32:16 </p> 
	 * @param user
	 * @param page
	 * @param limit
	 * @return
	 */
	Map<String, Object> listCourseByTeacher(Userinfo user, String page, String limit, String coursename);


	/**
	 * 
	 * <p>Title: deleteCourseByCourseid</p>  
	 * <p>Description: 根据课程id值删除相应的课程</p> 
	 * <p>data:2019年4月20日 下午5:46:44 </p> 
	 * @param courseid
	 * @return
	 */
	boolean deleteCourseByCourseid(String courseid);


	/**
	 * 
	 * <p>Title: addVedio2Course</p>  
	 * <p>Description: 给课程添加视频</p> 
	 * <p>data:2019年4月20日 下午6:31:36 </p> 
	 * @param file
	 * @param user
	 * @param request
	 * @param courseid
	 * @param coursename
	 * @return code 状态码  0：表示成功  1：表示添加失败  2：表示没有选中视频
	 */
	int addVedio2Course(MultipartFile file, Userinfo user, HttpServletRequest request, String courseid,
			String coursename);


	/**
	 * 
	 * <p>Title: listFileFromCourse</p>  
	 * <p>Description: 通过课程id和文件type属性查询出所有的文件信息</p> 
	 * <p>data:2019年4月20日 下午8:32:41 </p> 
	 * @param courseid
	 * @param fileType
	 * @return
	 */
	List<File> listFileFromCourse(String courseid, String fileType);

}
