package com.hl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

	
	

}
