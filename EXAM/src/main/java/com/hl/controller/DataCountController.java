package com.hl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.Userinfo;
import com.hl.service.ScoreService;

import net.sf.json.JSONObject;

/**
 * 
 * <p>Title: DataCountController</p>  
 * <p>Description: 图标数据展示控制器</p>  
 * @author huangliang 
 * @date 2019年4月17日
 */
@Controller
public class DataCountController {
	
	@Autowired
	private ScoreService  scoreService;
	
	@RequestMapping(value="get_user_score_for_chart.action",produces= {"text/html;charset=utf-8"})
	@ResponseBody
	public String getUserScoreForChart(HttpSession session) {
		JSONObject result = new JSONObject();
		Userinfo  user = (Userinfo) session.getAttribute("crruentUser"); 
		Map<String, String> listScoreByUser = scoreService.listScoreByUserForChart(user);
	    result.put("data", listScoreByUser);
		return result.toString();
	}

}
