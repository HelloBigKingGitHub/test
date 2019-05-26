package com.hl.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.ChoseSubject;
import com.hl.entity.PaperDetail;
import com.hl.entity.ScoreDetail;
import com.hl.entity.Userinfo;
import com.hl.formbean.PaperFormBean;
import com.hl.interceptor.LoginInterceptor;
import com.hl.service.ExamService;
import com.hl.service.PaperCheckService;
import com.hl.service.PaperService;
import com.hl.service.ScoreService;
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
	
	private static Logger logger = Logger.getLogger(PaperController.class);
	
	@Autowired
	private PaperService service;
	
	@Autowired
	private ExamService examService;
	
	@Autowired
	private PaperCheckService paperCheckService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ScoreService scoreService;
	
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
	 * 老师组编试卷时预览试卷
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
	 * 学生查看试卷时进行试卷预览（试卷查看功能）
	 * @param pid
	 * @return
	 */
	@RequestMapping(value="student_preview_paper.action",produces= {"text/html;charset=utf-8"})
	@ResponseBody
	public String studentPreview(String pid) {
		JSONObject result = new JSONObject();
		Map<PaperDetail, List<ChoseSubject>> map = examService.startTest(pid);
		Set<PaperDetail> keySet = map.keySet();
		for (PaperDetail paperDetail : keySet) {
			result.put("paperDetail", paperDetail);
			result.put("choseSubjects", map.get(paperDetail));
		}
		return result.toString();
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
	
	/**
	 * 得到当前用户的全部成绩
	 * @param teacherid
	 * @return
	 */
	@RequestMapping(value="get_score_of_user.action",produces= {"text/html;charset=utf-8"})
	@ResponseBody
	public String getScoreOfUsre(String page, String limit, String pid, String ptitle, String teacherid, HttpSession session) {
		Userinfo  user = (Userinfo) session.getAttribute("crruentUser"); //得到当前用户。应为是当前用户创建的试卷
		Map <String,Object>map = scoreService.listScoreByUser( page, limit,user,pid,ptitle,teacherid);
		return TableUtil.tableRander(ScoreDetail.class, map, "list");
	}
	
	
	/**
	 * 
	 * <p>Title: deleteCheckPaper</p>  
	 * <p>Description: 推诿指定的审查任务</p> 
	 * <p>data:2019年5月2日 下午4:04:58 </p> 
	 * @param pid
	 * @param checkteacherid
	 * @return
	 */
	@RequestMapping(value="delete_check_paper.action",produces= {"text/html;charset=utf-8"})
	@ResponseBody
	public String deleteCheckPaper(String pid, String checkteacherid) {
		JSONObject result = new JSONObject();
		String msg = "推诿失败";
		boolean isok = paperCheckService.deleteCheckPaper(pid,checkteacherid);
		if(isok) {
			msg = "推诿成功";
		}
		result.put("msg", msg);
		return result.toString();
	}
	
	
	/**
	 * 
	 * <p>Title: paperCheckResult</p>  
	 * <p>Description: 查看审查结果</p> 
	 * <p>data:2019年5月2日 下午5:21:49 </p> 
	 * @param pid
	 * @param checkteacherid
	 * @return
	 */
	@RequestMapping(value="paper_check_result.action",produces= {"text/html;charset=utf-8"})
	@ResponseBody
	public String paperCheckResult(String pid, String checkteacherid) {
		JSONObject result = new JSONObject();
		ArrayList<String> msg = new ArrayList<String>();
		msg.add("暂时没有审查结果");
		result.put("msg", msg);
		List<String> cs = paperCheckService.getCheckResult(pid);
		if(cs != null && cs.size()!=0) {
			result.put("msg", cs);
		}
		return result.toString();
		
	}
	
	/**
	 * 
	 * <p>Title: checkPaper</p>  
	 * <p>Description: 审查试卷</p> 
	 * <p>data:2019年5月2日 下午5:22:06 </p> 
	 * @return
	 */
	@RequestMapping(value="check_paper.action",produces= {"text/html;charset=utf-8"})
	@ResponseBody
	public String checkPaper(HttpSession session, String pid, String checkcontent ) {
		logger.info("==============进入试卷审查action=================");
		JSONObject result = new JSONObject();
		Userinfo  user = (Userinfo) session.getAttribute("crruentUser");
		String msg = "审查失败";
		boolean isok = paperCheckService.CheckPaper(pid,checkcontent,user);
		if(isok) {
			msg = "审查成功";
		}
		result.put("msg", msg);
		return result.toString();
	}
	

}
