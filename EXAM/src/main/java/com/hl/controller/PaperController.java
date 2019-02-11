package com.hl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hl.service.PaperService;

@Controller
/**
 * 实现试卷的的控制器
 * @author hl
 *
 */
public class PaperController {
	@Autowired
	private PaperService service;
	
	/**
	 * 相应前端查看所有的试卷的方法
	 * @return
	 */
	@RequestMapping("/paper_list.action")
	public String paperList(Model model) {
		model.addAttribute("papers", service.PaperList());
		return "/jsp/paper/paper_list.jsp";
	}
	

}
