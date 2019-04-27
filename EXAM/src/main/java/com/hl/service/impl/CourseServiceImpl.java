package com.hl.service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.Course;
import com.hl.entity.ErrorSubject;
import com.hl.entity.File;
import com.hl.entity.Userinfo;
import com.hl.mapper.CourseMapper;
import com.hl.service.CourseService;
import com.hl.service.FileService;
import com.hl.util.date.SimpleDateFormatUtil;
import com.hl.util.file.FileUploadUtil;
import com.hl.util.string.StringUtil;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseMapper courseMapper;
	
	@Autowired
	private FileService fileService;

	@Override
	public List<Course> listCourseByTeacherid(Integer teacherid) {
		
		return courseMapper.listCourseByTeacherid(teacherid);
	}

	
	@Override
	public boolean addCourse(Userinfo user, MultipartFile file, HttpServletRequest request, String coursedetail,
			String coursename, String starttime, String endtime) {
		// 1.先上传文件，调用文件的服务层
		File courseIcon = fileService.uploadFile(file, request, user, "icon");
		if (courseIcon == null || courseIcon.getFileid() == null) {
			return false;
		}
		SimpleDateFormat  sdf = SimpleDateFormatUtil.getInstance();
		Course course = new Course();
		try {
			System.out.println(starttime);
			System.out.println(endtime);
			java.util.Date startDate = sdf.parse(starttime);
			Date sqlStartDate = new Date(startDate.getTime());
			course.setStarttime(sqlStartDate);
			java.util.Date endDate = sdf.parse(endtime);
			Date sqlEndDate = new Date(endDate.getTime());
			course.setEndtime(sqlEndDate);
			course.setCoursedetail(coursedetail);
			course.setCoursename(coursename);
			course.setTeacherid(user.getUserid());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		boolean courseInsertIsok = courseMapper.insertCourse(course) > 0;
		boolean addFileToCourseIsok = false;
		if (!courseInsertIsok) { // 如果数据更新失败，就要删除刚刚上传的本地文件
			FileUploadUtil.removeLocalFile(courseIcon.getFileurl());
		} else {
			addFileToCourseIsok = addFileToCourse(course.getCourseid(), courseIcon.getFileid());
		}
		return courseInsertIsok && addFileToCourseIsok;
	}

	@Override
	public boolean addFileToCourse(int courseid, int fileid) {
		System.out.println("courseid="+courseid);
		System.out.println("fileid="+fileid);
		return courseMapper.insertCourseFile(courseid, fileid) > 0;
	}


	@Override
	public Map<String, Object> listCourseByTeacher(Userinfo user, String pageStr, String limitStr, String coursename) {
		if(!StringUtil.isInteger(pageStr)||!StringUtil.isInteger(limitStr)) {
			return new HashMap<String,Object>(0);
		}
		int userid = user.getUserid();
		Map<String,Object> result = new HashMap<>();
		int pageInt = Integer.parseInt(pageStr);
		int limit = Integer.parseInt(limitStr);
		Page<Object> page = PageHelper.startPage(pageInt, limit, true);
		List<Course> list = courseMapper.listCourseByTeacheridAndCoursename(userid,coursename);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}


	@Override
	public boolean deleteCourseByCourseid(String courseid) {
		if(!StringUtil.isInteger(courseid)) {
			return false;
		}
		int courseidInt = Integer.parseInt(courseid);
		return courseMapper.deleteCourseByCourseid(courseidInt) > 0;
	}


	@Override
	public int addVedio2Course(MultipartFile file, Userinfo user, HttpServletRequest request, String courseid,
			String coursename) {
		
		if(courseid == null || "".equals(courseid) || coursename == null || "".equals(coursename)) {
			return 2;  //表示没有选中需要添加视频的课程。
			
		}
		//1.先上传文件（视频文件）
		File courseVideo = fileService.uploadFile(file, request, user, "courseVideo");
		if (courseVideo == null || courseVideo.getFileid() == null) {
			return 1; //表示上传失败
		}
		
		//2.跟新course_file表的数据
		boolean addFileToCourseIsok = addFileToCourse(Integer.parseInt(courseid), courseVideo.getFileid());
		if(!addFileToCourseIsok) {  //course_file表跟新失败
			FileUploadUtil.removeLocalFile(courseVideo.getFileurl());
			return 1;
		}
		return 0;
	}


	@Override
	public List<File> listFileFromCourse(String courseid, String fileType) {

		if(!StringUtil.isInteger(courseid)) {
			return new ArrayList<File>();
		}
		int courseidInt = Integer.parseInt(courseid);
		
		List<File> list =  fileService.listFileFromCourse(courseidInt,fileType);
		return list;
	}


	@Override
	public Map<String, Object> listStudentCourse(String limitStr, String pageStr, String coursename, Userinfo user) {
		
		if(!StringUtil.isInteger(pageStr)||!StringUtil.isInteger(limitStr)) {
			return new HashMap<String,Object>(0);
		}
		int userid = user.getUserid();
		Map<String,Object> result = new HashMap<>();
		int pageInt = Integer.parseInt(pageStr);
		int limit = Integer.parseInt(limitStr);
		Page<Object> page = PageHelper.startPage(pageInt, limit, true);
		List<Course> list = courseMapper.listStudentCourse(userid,coursename);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}


	@Override
	public Map<String, Object> listCourse4Student(String pageStr, String limitStr, String teacherid, String teachername,
			String coursename, String starttime, String endtime, String coursedetail) {
		if(!StringUtil.isInteger(pageStr)||!StringUtil.isInteger(limitStr)) {
			return new HashMap<String,Object>(0);
		}
		Integer teacheridInt = null;
		if(StringUtil.isInteger(teacherid)) {
			teacheridInt = Integer.parseInt(teacherid);
		}
		Map<String,Object> result = new HashMap<>();
		int pageInt = Integer.parseInt(pageStr);
		int limit = Integer.parseInt(limitStr);
		Page<Object> page = PageHelper.startPage(pageInt, limit, true);
		List<Course> list = courseMapper.listCourse4Student( teacheridInt,  teachername,
				 coursename,  starttime,  endtime,  coursedetail);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}


	@Override
	public int userJoinCourse(Userinfo user, String courseid) {
		if(!StringUtil.isInteger(courseid)) {
			return 2;  //报名失败
		}
		int courseidInt = Integer.parseInt(courseid);
		int userid = user.getUserid();
		if(courseMapper.courseOfUserIsExist(userid,courseidInt) > 0) {
			return 1; //已经报名参加
		}else {
			return  courseMapper.userJoinCourse(userid,courseidInt) - 1;
		}
	}


	@Override
	public boolean userExitCourse(Userinfo user, String courseid) {

		if(!StringUtil.isInteger(courseid)) {
			return false;
		}
		int courseidInt = Integer.parseInt(courseid);
		int userid = user.getUserid();
		return courseMapper.userExitCourse(userid,courseidInt) > 0;
	}
	
	




	

}
