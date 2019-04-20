package com.hl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.Homework;
import com.hl.entity.Userinfo;
import com.hl.formbean.HomeworkFormBean;
import com.hl.service.HomeworkService;

import net.sf.json.JSONObject;

/**
 * 作业的控制层
 * @author hl
 *
 */
@Controller
public class HomeworkController {
	
	@Autowired
	private HomeworkService homeworkService;
	
	/**
	 * 给整班级发布作业
	 * @param homeworkFormBean
	 * @return
	 */
	@RequestMapping(value="issuer_homework_for_class.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String issuerHomeworkForClass( @RequestBody HomeworkFormBean homeworkFormBean) {
		
		String msg = "";
		JSONObject result = new JSONObject();
		System.out.println(homeworkFormBean);
		boolean isok = homeworkService.addHomeworkForClass(homeworkFormBean);
		if(isok) {
			msg = "作业发布成功";
		}else {
			msg = "作业发布失败";
		}
		result.put("msg", msg);
		return result.toString();
	}
	
	/**
	 * 从班级中的得到作业信息
	 * @return
	 */
	@RequestMapping(value="get_homework_from_class.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String getHomeworkFromClass(String page, String limit, HttpSession session) {
		
		String msg = "";
		JSONObject result = new JSONObject();
		Userinfo user = (Userinfo) session.getAttribute("crruentUser");
		//boolean isok = homeworkService.addHomeworkForClass(homeworkFormBean);
		Map<String, Object> annoucement = homeworkService.getHomeworkFromClass(page,limit,user);
		result.put("count", (long)annoucement.get("count"));
		result.put("homeworks", (List<Homework>)annoucement.get("list"));
		return result.toString();
	}
	
	
	/**
	 * 从个人中得到作业信息
	 * @return
	 */
	@RequestMapping(value="get_homework_from_student.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String getHomeworkFromStudent(String page, String limit, HttpSession session) {
		String msg = "";
		JSONObject result = new JSONObject();
		//boolean isok = homeworkService.addHomeworkForClass(homeworkFormBean);
		Userinfo user = (Userinfo) session.getAttribute("crruentUser");
		Map<String, Object> annoucement = homeworkService.getHomeworkFromStudent(page,limit,user);
		result.put("count", (long)annoucement.get("count"));
		result.put("homeworks", (List<Homework>)annoucement.get("list"));
		return result.toString();
		
	}

	
	

}
