package com.hl.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.ChoseSubject;
import com.hl.entity.PaperDetail;
import com.hl.service.ExamService;

/**
 * 管理考试的控制器，对考试中用户的相关操作进行处理
 * @author hl
 *
 */
@Controller
public class ExamController {
	@Autowired
	private ExamService service;
	
	/**
	 * 开始考试，根据前端选择的考试试卷，把数据库中的试题响应给前端页面
	 * @return
	 */
	@RequestMapping("test_start.action")
	public @ResponseBody String startTest(String pid,HttpSession session) {
		//System.out.println(pid);
		Map<PaperDetail, List<ChoseSubject>> map = service.startTest(pid);
		Set<PaperDetail> keySet = map.keySet();
		for (PaperDetail paperDetail : keySet) {
			//System.out.println(paperDetail);
			//System.out.println(map.get(paperDetail));
			session.setAttribute("paperDetail", paperDetail);
			session.setAttribute("choseSubjects", map.get(paperDetail));
			System.out.println("test*****"+session.getAttribute("paperDetail"));
			System.out.println("test*****"+session.getAttribute("choseSubjects"));
		}
		return "/jsp/paper/paper.jsp";
	}
	@RequestMapping("test_submit.action")
	public @ResponseBody String submitTest(String str,HttpSession session) {
		//System.out.println(str);
		String requestStr[] = str.split(",");
		Map<String ,Object> answerMap = new HashMap<String ,Object>();
		//System.out.println(requestStr);
		for (String string : requestStr) {
			System.out.println(string);
			String[] kv = string.split(":");
			answerMap.put(kv[0], kv[1]);
		}
		//得到当前用户，添加到map集合中方便后续调用
		answerMap.put("crruentUser", session.getAttribute("crruentUser"));
		//调用service层服务
		boolean isok = service.submitTest(answerMap);
		return isok?"true":"false";
	}

}
