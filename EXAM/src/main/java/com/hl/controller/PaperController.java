package com.hl.controller;

import java.util.HashMap;
import java.util.List;

import javax.interceptor.AroundTimeout;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.ChoseSubject;
import com.hl.entity.PaperDetail;
import com.hl.entity.Userinfo;
import com.hl.formbean.PaperFormBean;
import com.hl.service.PaperCheckService;
import com.hl.service.PaperService;
import com.hl.service.SubjectService;
import com.hl.util.ui.TableUtil;

import net.sf.json.JSONObject;

@Controller
/**
 * 实现试卷的的控制器
 * @author hl
 *
 */
public class PaperController {
	@Autowired
	private PaperService service;
	
	@Autowired
	private PaperCheckService paperCheckService;
	
	@Autowired
	private SubjectService subjectService;
	
	/**
	 * 相应前端查看所有的试卷的方法
	 * @return
	 */
	@RequestMapping("/paper_list.action")
	public String paperList(Model model) {
		model.addAttribute("papers", service.PaperList());
		return "/jsp/paper/paper_list.jsp";
	}
	
	/**
	 * 根据相关条件进行分页查询
	 * @param page 当前页面
	 * @param limit 分页大小
	 * @param teacherid 老师id
	 * @param paperid 试卷编号
	 * @param papername 试卷title
	 * @return
	 */
	@RequestMapping(value="list_paper.action" ,produces= {"text/html;charset=utf-8"})
	public @ResponseBody String listPaper(String page,String limit,String teacherid,String paperid,String papername) {
		
		HashMap <String,Object>map = (HashMap<String, Object>) service.listPaper( page, limit,teacherid,papername,paperid);
		return TableUtil.tableRander(PaperDetail.class, map, "list");
	}
	
	
	/**
	 * 预览试卷
	 */
	@RequestMapping(value="paper_preview.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String paperPreview( @RequestBody List<String> subjectidList) {
		if(subjectidList!=null && subjectidList.size()!=0) { //判断传过来的数据不是空值才进行下一步操作
			JSONObject result = new JSONObject();
			List<ChoseSubject> list = subjectService.listChoseSubjectByIds(subjectidList);
			result.put("subjectList", list);
			return result.toString();
		}
		return null;
	}
	
	/**
	 * 添加试卷
	 */
	@RequestMapping(value="add_paper.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String addPaper(@RequestBody PaperFormBean paperFormBean,HttpSession session) {
		Userinfo  currentUser = (Userinfo) session.getAttribute("crruentUser"); //得到当前用户。应为是当前用户创建的试卷
		JSONObject result = new JSONObject();
		String msg = "";
		
		try {
			service.addPaper(paperFormBean , currentUser);
			msg = "添加成功";
		} catch (Exception e) {
			msg = "添加失败";
			e.printStackTrace();
		}
		result.put("msg", msg);
		return result.toString();
	}
	
	/**
	 * 查询出所有需要该老师审查的试卷
	 * @param teacherid
	 * @return
	 */
	@RequestMapping(value="list_check_paper_by_teacherid.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String listCheckPaperListByTeacherId(String page, String limit, String teacherid) {
		HashMap <String,Object>map = (HashMap<String, Object>) paperCheckService.listCheckPaperByTeacherId( page, limit,teacherid);
		return TableUtil.tableRander(PaperDetail.class, map, "list");
		
	}

	

}
