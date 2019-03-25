package com.hl.service.impl;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
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

}
