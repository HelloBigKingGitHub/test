package com.hl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.Userinfo;
import com.hl.service.UserService;

import net.sf.json.JSONObject;

/**
 * 有关老师操作的控制层
 * @author hl
 *
 */
@Controller
public class TeacherController {
	
	@Autowired
	private UserService userService;
	/**
	 * 分页展示所有的学生信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="list_teacher.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String listStudent() {
		JSONObject result = new JSONObject();
		List<Userinfo> list = new ArrayList<>();
		list = userService.listTeacher();
		result.put("teacherList", list);
		return result.toString();
		
		
	}


}
