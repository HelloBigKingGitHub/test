package com.hl.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.Course;
import com.hl.service.CourseService;
import net.sf.json.JSONObject;

/**
 * 有关课程的控制层
 * @author hl
 *
 */
@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	/**
	 * 获取当前用户的所有课程
	 * @return
	 */
	@RequestMapping(value="get_crruentUser_course.action",produces= {"html/text;charset=utf-8"})
	public @ResponseBody String getCrruentUserCourse(String crruentUserid) {
		
		JSONObject result = new JSONObject();
		List<Course> list = null;
		String msg = "";
		Integer code = 0;
		if(crruentUserid==null||crruentUserid=="") {
			msg = "没有获取到用户信息，请先登录";
			code = 1;
		}else {
			msg = "成功获取到用户信息";
			Integer teacherid = Integer.parseInt(crruentUserid);
			list = courseService.listCourseByTeacherid(teacherid);
		}
		result.put("msg", msg);
		result.put("code", code);
		result.put("courseList", list);
		return result.toString();
	}
}
