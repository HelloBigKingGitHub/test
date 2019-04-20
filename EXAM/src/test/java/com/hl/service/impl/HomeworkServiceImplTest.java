package com.hl.service.impl;


import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.Homework;
import com.hl.entity.Userinfo;
import com.hl.formbean.HomeworkFormBean;
import com.hl.service.HomeworkService;

public class HomeworkServiceImplTest extends BaseTest{

	@Autowired
	private HomeworkService homeworkService;
	@Test
	public void testAddHomeworkForClass() {
		HomeworkFormBean homeworkFormBean = new HomeworkFormBean();
		homeworkFormBean.setClassid("1");
		homeworkFormBean.setIssuerid("6");
		homeworkFormBean.setDownline_desc("测试内容");
		homeworkFormBean.setH_format("测试");
		homeworkFormBean.setH_title("测试标题");
		System.out.println(homeworkService.addHomeworkForClass(homeworkFormBean));
	}
	
	@Test
	public void testGetHomeworkFromClass() {
		Userinfo user = new Userinfo();
		user.setUserid(3);
		String page = "1";
		String limit = "10";
		Map<String, Object> homeworkFromClass = homeworkService.getHomeworkFromClass(page, limit, user);
		List<Homework> list = (List<Homework>) homeworkFromClass.get("list");
		for (Homework homework : list) {
			System.out.println(homework);
		}
	}
	
	@Test
	public void getHomeworkFromStudent() {
		
		Userinfo user = new Userinfo();
		user.setUserid(3);
		String page = "1";
		String limit = "10";
		Map<String, Object> homeworkFromStudent = homeworkService.getHomeworkFromStudent(page, limit, user);
		List<Homework> list = (List<Homework>) homeworkFromStudent.get("list");
		for (Homework homework : list) {
			System.out.println(homework);
		}
	}

}
