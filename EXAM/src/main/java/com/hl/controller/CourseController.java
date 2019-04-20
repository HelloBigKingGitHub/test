package com.hl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hl.entity.Course;
import com.hl.entity.File;
import com.hl.entity.Userinfo;
import com.hl.service.CourseService;
import com.hl.util.ui.TableUtil;

import net.sf.json.JSONObject;

/**
 * 有关课程的控制层
 * 
 * @author hl
 *
 */
@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	/**
	 * 获取当前用户的所有课程
	 * 
	 * @return
	 */
	@RequestMapping(value = "get_crruentUser_course.action", produces = { "html/text;charset=utf-8" })
	public @ResponseBody String getCrruentUserCourse(String crruentUserid) {

		JSONObject result = new JSONObject();
		List<Course> list = null;
		String msg = "";
		Integer code = 0;
		if (crruentUserid == null || crruentUserid == "") {
			msg = "没有获取到用户信息，请先登录";
			code = 1;
		} else {
			msg = "成功获取到用户信息";
			Integer teacherid = Integer.parseInt(crruentUserid);
			list = courseService.listCourseByTeacherid(teacherid);
		}
		result.put("msg", msg);
		result.put("code", code);
		result.put("courseList", list);
		return result.toString();
	}

	@RequestMapping(value = "add_course.action", produces = { "html/text;charset=utf-8" })
	@ResponseBody
	public String addCourse(MultipartFile file, HttpServletRequest request, HttpSession session) {
		Userinfo user = (Userinfo) session.getAttribute("crruentUser");
		JSONObject result = new JSONObject();
		String msg = "添加失败";
		String coursedetail = request.getParameter("coursedetail");
		String coursename = request.getParameter("coursename");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");

		boolean isok = courseService.addCourse(user, file, request, coursedetail, coursename, starttime, endtime);
		if (isok) {
			msg = "添加成功";
		}
		result.put("msg", msg);
		return result.toString();

	}

	@RequestMapping(value = "list_course_by_teacher.action", produces = { "html/text;charset=utf-8" })
	@ResponseBody
	public String listCourseByTeacher(String page, String limit, String coursename, HttpSession session) {

		Userinfo user = (Userinfo) session.getAttribute("crruentUser");
		Map<String, Object> map = courseService.listCourseByTeacher(user, page, limit, coursename);
		return TableUtil.tableRander(Course.class, map, "list");

	}

	/**
	 * 
	 * <p>Title: deleteCourseByCourseid</p>  
	 * <p>Description: 通过课程id删除课程</p> 
	 * <p>data:2019年4月20日 下午8:27:21 </p> 
	 * @param courseid
	 * @return
	 */
	@RequestMapping(value = "delete_course_by_courseid.action", produces = { "html/text;charset=utf-8" })
	@ResponseBody
	public String deleteCourseByCourseid(String courseid) {
		JSONObject result = new JSONObject();
		String msg = "删除失败";
		if (courseService.deleteCourseByCourseid(courseid)) {
			msg = "删除成功";
		}
		result.put("msg", msg);
		return result.toString();

	}
	

	/**
	 * 
	 * <p>Title: addVedio2Course</p>  
	 * <p>Description: 往课程中添加视频</p> 
	 * <p>data:2019年4月20日 下午8:27:50 </p> 
	 * @param file
	 * @param request
	 * @param session
	 * @param courseid
	 * @param coursename
	 * @return
	 */
	@RequestMapping(value = "add_video_to_course.action", produces = { "html/text;charset=utf-8" })
	@ResponseBody
	public String addVedio2Course(MultipartFile file, HttpServletRequest request, HttpSession session, String courseid, String coursename) {
		// System.out.println("文件上传开始");
		Userinfo user = (Userinfo) session.getAttribute("crruentUser");
		JSONObject result = new JSONObject();
		int code = 0; // 返回状态码
		String msg = "";// 返回信息
		JSONObject data = new JSONObject(); // 返回数据
		code = courseService.addVedio2Course(file,user,request,courseid,coursename);
		switch (code) {
		case 0:
			msg = "添加成功";
			break;
		case 1:
			msg = "添加失败，使用正确的数据";
			break;
		case 2:
			msg = "请您先选择您需要添加视频的课程。。";
			break;

		default:
			msg = "系统出现未知错误，请联系技术支持人员:18573244627";
			break;
		}
		result.put("code", code);
		result.put("msg", msg);
		result.put("data", data);
		// System.out.println("文件上传结束");
		return result.toString();
	}
	
	/**
	 * 
	 * <p>Title: getVediosFromCourse</p>  
	 * <p>Description: 从课程中的得到所有文件的信息（icon：图标  video：视频）</p> 
	 * <p>data:2019年4月20日 下午8:28:15 </p> 
	 * @param courseid
	 * @return
	 */
	@RequestMapping(value = "get_videos_from_course.action", produces = { "html/text;charset=utf-8" })
	@ResponseBody
	public String getVediosFromCourse(String courseid,String fileType) {
		JSONObject result = new JSONObject();
		List<File> list = courseService.listFileFromCourse(courseid,fileType);
		result.put("files", list);
		return result.toString();
	}
	

}
