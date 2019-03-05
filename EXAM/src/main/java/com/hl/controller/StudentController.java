package com.hl.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.Userinfo;
import com.hl.service.UserService;
import com.hl.util.ui.TableUtil;

/**
 * 有关学生操作的控制层(学生知识用户类型的一种)
 * @author hl
 *
 */
@Controller
public class StudentController {
	
	
	@Autowired
	private UserService userService;
	/**
	 * 分页展示所有的学生信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping(value="list_student.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String listStudent(String page,String limit) {
		
		Map<String,Object>map = userService.listStudent(page,limit);
		
		return TableUtil.tableRander(Userinfo.class, map, "list");
		
	}

}
