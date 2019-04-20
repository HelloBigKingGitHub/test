package com.hl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.Homework;
import com.hl.entity.Message;
import com.hl.entity.Userinfo;
import com.hl.formbean.HomeworkFormBean;
import com.hl.mapper.HomeworkMapper;
import com.hl.service.HomeworkService;

@Service
public class HomeworkServiceImpl implements HomeworkService{

	@Autowired
	private HomeworkMapper homeworkMapper;
	@Override
	public boolean addHomeworkForClass(HomeworkFormBean homeworkFormBean) {
		Homework homework =  HomeworkFormBeanToHomework(homeworkFormBean);
		if(homework==null||homeworkFormBean.getClassid()==null||"".equals(homeworkFormBean.getClassid())) {
			return false;
		}else {
			homework = addHomework(homework); //先增加homework，得到homeworkid，在增加class_homework记录
		}
		if(homework!=null) {
			Integer classid = Integer.parseInt(homeworkFormBean.getClassid());
			return homeworkMapper.insertHomeForClass( homework.getHomeworkid(), classid) > 0;
		}else {
			return false;
		}
	}
	
	


	@Override
	public Homework addHomework(Homework homework) {
		
		int isok = homeworkMapper.insertHomework(homework);
		if(isok>0) {
			return homework;
		}
		else return null;
	}
	
	
	/**
	 * 将表单类HomeworkFormBean转化为数据库封装类Homework
	 * @param homeworkFormBean
	 * @return Homework
	 */
	private Homework HomeworkFormBeanToHomework(HomeworkFormBean homeworkFormBean) {
		if(homeworkFormBean.getIssuerid()==null) {
			return null;
		}
		Homework homework = new Homework();
		homework.setContent(homeworkFormBean.getDownline_desc());
		homework.setFormat(homeworkFormBean.getH_format());
		homework.setTitle(homeworkFormBean.getH_title());
		homework.setIssuerid(Integer.parseInt(homeworkFormBean.getIssuerid()));
		return homework;
	}




	@Override
	public Map<String, Object> getHomeworkFromClass(String pageStr, String limitStr, Userinfo user) {
		if(user.getUserid()==null||pageStr==null||limitStr==null) {
			return null;
		}
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limitStr);
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Message> homeworks = homeworkMapper.getHomeworkFromClass(user.getUserid());
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", homeworks);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}




	@Override
	public Map<String, Object> getHomeworkFromStudent(String pageStr, String limitStr, Userinfo user) {
		if(user.getUserid()==null||pageStr==null||limitStr==null) {
			return null;
		}
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limitStr);
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Homework> homeworks = homeworkMapper.getHomeworkFromStudent(user.getUserid());
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", homeworks);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}
	
	
	

}
