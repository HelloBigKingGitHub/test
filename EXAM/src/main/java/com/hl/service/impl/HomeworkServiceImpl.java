package com.hl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.entity.Homework;
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
	
	
	

}
