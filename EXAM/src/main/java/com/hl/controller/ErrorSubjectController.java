package com.hl.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hl.entity.ErrorSubject;
import com.hl.service.ErrorSubjectService;

@Controller
/**
 * 错题的控制器
 * @author admin
 *
 */
public class ErrorSubjectController {
	
	@Autowired
	private ErrorSubjectService errorSubjectService;
	@RequestMapping("list_error_subject_page.action")
	public String ListErrorSubjectPage(String pageNumStr,String pageSizeStr,Model model) {
		int pageNum = (pageNumStr==null)?1:Integer.parseInt(pageNumStr);
		int pageSize = (pageSizeStr==null)?4:Integer.parseInt(pageSizeStr);
		Map<String,Object> result = errorSubjectService.listErrorSubjectPage(pageNum, pageSize);
		model.addAttribute("count", result.get("pages"));
		List<ErrorSubject> list = (List)result.get("list");
		model.addAttribute("errorSubjectList",list);
		return "/jsp/subject/error_subject_list_page.jsp";
	}

	@RequestMapping("list_error_subject_page_updata.action")
	public String ListErrorSubjectPageUpdata(String pageNumStr,String pageSizeStr,Model model) {	
		ListErrorSubjectPage(pageNumStr,pageSizeStr,model);
		return "/jsp/subject/error_subject_list_page_table.jsp";
	}
	
	
	
	
}
