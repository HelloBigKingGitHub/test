package com.hl.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.ChoseSubject;
import com.hl.formbean.ChoseSubjectFormBean;
import com.hl.service.SubjectService;
import com.hl.util.ui.TableUtil;



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
	 * 表单数据和数据库数据实体类转化
	 * @param choseSubjectFrom
	 * @return
	 */
	private ChoseSubject choseSubjectFormBeanToChoseSubject(ChoseSubjectFormBean choseSubjectFrom) {
		//将表单数据绑定到数据库的实体类中
		ChoseSubject choseSubject = new ChoseSubject();
		choseSubject.setScontent(choseSubjectFrom.getScontent());
		choseSubject.setSa(choseSubjectFrom.getSa());
		choseSubject.setSb(choseSubjectFrom.getSb());
		choseSubject.setSc(choseSubjectFrom.getSc());
		choseSubject.setSd(choseSubjectFrom.getSd());
		choseSubject.setSkey(choseSubjectFrom.getSkey());
		choseSubject.setTestcount(0);
		choseSubject.setSstate(Integer.parseInt(choseSubjectFrom.getSstate()));
		return choseSubject;
	}
		

}
