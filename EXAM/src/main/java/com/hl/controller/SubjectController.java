package com.hl.controller;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.ChoseSubject;
import com.hl.entity.SubjectDetail;
import com.hl.formbean.ChoseSubjectFormBean;
import com.hl.service.SubjectService;
import com.hl.util.ui.TableUtil;

import net.sf.json.JSONObject;



/**
 * 试题的控制层
 * @author hl
 *
 */
@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	/**
	 * 分页展示试题信息
	 * @param page 当前页
	 * @param limit 分页大小
	 * @param scontent 试题题干的内容
	 * @return
	 */
	@RequestMapping(value="list_subject_page.action",produces = {"text/html;charset=utf-8"})
	public @ResponseBody String listSubjectPage(String page,String limit,String scontent) {
		if(scontent!=null) {
			//return tableReload(page, limit,scontent);
			Integer pageNum = (page == null?1:Integer.parseInt(page));
			Integer pageSize = (limit == null?10:Integer.parseInt(limit));
			Map<String, Object> map = subjectService.listChoseSubjectLikeScontentPage(pageNum, pageSize, scontent);
			return TableUtil.tableRander(ChoseSubject.class, map, "list");
		}else {
			//return tableRender(page, limit);
			Integer pageNum = (page == null?1:Integer.parseInt(page));
			Integer pageSize = (limit == null?10:Integer.parseInt(limit));
			Map<String, Object> map = subjectService.listChoseSubjectPage(pageNum, pageSize);
			return TableUtil.tableRander(ChoseSubject.class, map, "list");
		}
		
	}
	
	/**
	 * 增加一条试题数据
	 * @return 操作数
	 */
	@RequestMapping(value="add_subject.action",produces = {"text/html;charset=utf-8"},method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody String addSubject(@RequestBody ChoseSubjectFormBean choseSubjectFrom) {
		
		//System.out.println(choseSubject);
		//ChoseSubject choseSubject = new ChoseSubject();
		ChoseSubject choseSubject = choseSubjectFormBeanToChoseSubject(choseSubjectFrom);
		
		boolean  isok = subjectService.insertChoseSubject(choseSubject);
		if(isok) {
			return "添加成功";
		}else { 
			return "添加失败";
		}
	}

	/**
	 * 添加一条试题数据，如果成功得到该添加的试题的sid
	 * @param choseSubjectFrom
	 * @return
	 * @throws SQLException 
	 */
	@RequestMapping(value="add_subject_and_get_sid.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String addsubjectAndGetSid(@RequestBody ChoseSubjectFormBean choseSubjectFrom) throws SQLException {
		
		ChoseSubject choseSubject = choseSubjectFormBeanToChoseSubject(choseSubjectFrom);
		int flag = subjectService.insertSubjectAndGetSid(choseSubject);
		if(flag>0) {
			return choseSubject.getSid()+"";
		}else {
			
			throw new SQLException("数据操作异常");
		}
	}
	
	
	@RequestMapping(value="updata_subject.action" ,produces= {"text/html;charset=utf-8"})
	public @ResponseBody String updataSubject(@RequestBody ChoseSubjectFormBean choseSubjectFrom) {
		
		ChoseSubject choseSubject = choseSubjectFormBeanToChoseSubject(choseSubjectFrom);
		boolean isok = subjectService.updataChoseSubject(choseSubject);
		if(isok) {
			return "更新成功";
		}else { 
			return "更新失败";
		}
		//System.out.println(choseSubject);
		//return null;
	}
	
	@RequestMapping(value="get_subject_detail.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String getSubjectDetail(String sid) {
		
		SubjectDetail sd = subjectService.getSubjectDetail(sid);
		JSONObject result = new JSONObject();
		String msg = "no";
		if(sd!=null) {
			result.put("sd", sd);
			msg = "isok";
		}
		result.put("msg", msg);
		return result.toString();
	}
	
	
	/**
	 * 表单数据和数据库数据实体类转化
	 * @param choseSubjectFrom
	 * @return
	 */
	private ChoseSubject choseSubjectFormBeanToChoseSubject(ChoseSubjectFormBean choseSubjectFrom) {
		//将表单数据绑定到数据库的实体类中
		ChoseSubject choseSubject = new ChoseSubject();
		if(choseSubjectFrom.getSid()!=null&&!("".equals(choseSubjectFrom.getSid()))) {//判断前端是否传了sid字段
			choseSubject.setSid(Integer.parseInt(choseSubjectFrom.getSid()));
		}
		choseSubject.setScontent(choseSubjectFrom.getScontent());
		choseSubject.setSa(choseSubjectFrom.getSa());
		choseSubject.setSb(choseSubjectFrom.getSb());
		choseSubject.setSc(choseSubjectFrom.getSc());
		choseSubject.setSd(choseSubjectFrom.getSd());
		choseSubject.setSkey(choseSubjectFrom.getSkey());
		choseSubject.setTestcount(0);
		if(choseSubjectFrom.getSstate()!=null&& !("".equals(choseSubjectFrom.getSstate()))) {
			
			choseSubject.setSstate(Integer.parseInt(choseSubjectFrom.getSstate()));
		}
		return choseSubject;
	}
		

}
