package com.hl.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.ErrorSubject;
import com.hl.service.ErrorSubjectService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
/**
 * 错题的控制器
 * @author hl
 *
 */
public class ErrorSubjectController {
	
	private List<ErrorSubject> list;
	@Autowired
	private ErrorSubjectService errorSubjectService;
	@RequestMapping("list_error_subject_page.action")
	public String listErrorSubjectPage(String pageNumStr,String pageSizeStr,Model model) {
		int pageNum = (pageNumStr==null)?1:Integer.parseInt(pageNumStr);
		int pageSize = (pageSizeStr==null)?4:Integer.parseInt(pageSizeStr);
		Map<String,Object> result = errorSubjectService.listErrorSubjectPage(pageNum, pageSize);
		model.addAttribute("count", result.get("pages"));
		List<ErrorSubject> list = (List)result.get("list");
		model.addAttribute("errorSubjectList",list);
		return "/jsp/subject/error_subject_list_page.jsp";
	}

	@RequestMapping("list_error_subject_page_updata.action")
	public String listErrorSubjectPageUpdata(String pageNumStr,String pageSizeStr,Model model) {	
		listErrorSubjectPage(pageNumStr,pageSizeStr,model);
		return "/jsp/subject/error_subject_list_page_table.jsp";
	}
	
	/**
	 * 相应前端layui框架的数据表格中的数据（查看所有的错题信息）
	 * @param page 页号
	 * @param limit 页的大小
	 * @return
	 */
	@RequestMapping(value="list_error_subject_page_2.action",produces = {"text/html;charset=utf-8"})
	//produces = {"text/html;charset=utf-8"}解决中文乱码
	public @ResponseBody String listErrorSubjectPage(String page,String limit,String esid) {
		if(esid==null || "".equals(esid)) {
			return tableRender(page, limit);
		}else {
			return tableReload(esid);
		}
		
	}
	
	/**
	 * 表格绑定数据函数（渲染函数）
	 * @param page
	 * @param limit
	 * @return
	 */
	private String tableRender(String page,String limit) {
		int pageNum = (page==null)?1:Integer.parseInt(page);
		int pageSize = (limit==null)?4:Integer.parseInt(limit);
		Map<String,Object> map = errorSubjectService.listErrorSubjectPage(pageNum, pageSize);
		JSONObject json = new JSONObject();
		JSONObject result = new JSONObject();
		JSONArray jsons = new JSONArray();
		//设置头部信息
		result.put("code", 0);
		result.put("msg", "");
		result.put("count", map.get("count"));
		list = (List)map.get("list");
		for (ErrorSubject errorSubject : list) {
			//数据绑定
			json.put("esid", errorSubject.getEsid());
			json.put("userid",errorSubject.getUserid());
			json.put("ekey", errorSubject.getEkey());
			json.put("sid", errorSubject.getSubject().getSid());
			json.put("sstate",errorSubject.getSubject().getSstate());
			json.put("scontent", errorSubject.getSubject().getScontent());
			jsons.add(json);
		}
		result.put("data", jsons);
		return result.toString();
		
	}
	
	/**
	 * 表格重载函数
	 * @param esid
	 * @return
	 */
	private String tableReload(String esid) {
		JSONObject json = new JSONObject();
		JSONObject result = new JSONObject();
		JSONArray jsons = new JSONArray();
		//设置头部信息
		result.put("code", 0);
		result.put("msg", "");
		int i = 0;
		for (ErrorSubject errorSubject : list) {
			if(errorSubject.getEsid().equals(Integer.parseInt(esid))) {
				//数据绑定
				json.put("esid", errorSubject.getEsid());
				json.put("userid",errorSubject.getUserid());
				json.put("ekey", errorSubject.getEkey());
				json.put("sid", errorSubject.getSubject().getSid());
				json.put("sstate",errorSubject.getSubject().getSstate());
				json.put("scontent", errorSubject.getSubject().getScontent());
				jsons.add(json);
				i++;
			}
		}
		result.put("count", i);
		result.put("data", jsons);
		return result.toString();

	}
	
	
	
	
	
	
}
