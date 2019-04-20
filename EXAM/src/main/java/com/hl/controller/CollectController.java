package com.hl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.Clazz;
import com.hl.entity.Collect;
import com.hl.entity.ErrorSubject;
import com.hl.entity.Userinfo;
import com.hl.service.CollectService;
import com.hl.util.string.StringUtil;
import com.hl.util.ui.TableUtil;

import net.sf.json.JSONObject;

/**
 * 
 * <p>Title: CollectController</p>  
 * <p>Description:对用户收藏的控制器 </p>  
 * @author huangliang 
 * @date 2019年4月14日
 */
@Controller
public class CollectController {
	
	@Autowired
	private CollectService collectService;
	
	/**
	 * 用户收集试题subject
	 * @param session
	 * @param sid
	 * @return
	 */
	@RequestMapping(value="user_collect_subject.action",produces= {"text/html;charset=utf-8"})
	@ResponseBody
	public String userCollectSubject(HttpSession session, String sid) {
		Userinfo  user = (Userinfo) session.getAttribute("crruentUser"); //得到当前用户
		String msg = "收藏失败，请确认数据是否正常，或是否重复收藏";
		JSONObject result = new JSONObject();
		if(!StringUtil.isInteger(sid)) {
			msg = "数据有误";
		}else {
			boolean isok = collectService.userCollectSubject(user,sid);
			if(isok) {
				msg = "收藏成功";
			}
		}
		result.put("msg", msg);
		return result.toString();
	}
	
	
	/**
	 * 用户收集试卷
	 * @param session
	 * @param pid
	 * @return
	 */
	@RequestMapping(value="user_collect_paper.action",produces= {"text/html;charset=utf-8"})
	@ResponseBody
	public String userCollectPaper(HttpSession session, String pid) {
		Userinfo  user = (Userinfo) session.getAttribute("crruentUser"); //得到当前用户。应为是当前用户创建的试卷
		String msg = "收藏失败";
		JSONObject result = new JSONObject();
		if(!StringUtil.isInteger(pid)) {
			msg = "数据有误";
		}else {
			boolean isok = collectService.userCollectPaper(user,pid);
			if(isok) {
				msg = "收藏成功";
			}
		}
		result.put("msg", msg);
		return result.toString();
	}
	
	/**
	 * 
	 * <p>Title: userGetErrorSubjcet</p>  
	 * <p>Description: </p> 
	 * <p>data:2019年4月15日 下午9:26:14 </p> 
	 * @param limit
	 * @param page
	 * @param contentType
	 * @param session
	 * @return
	 */
	@RequestMapping(value="user_get_collect.action",produces= {"text/html;charset=utf-8"})
	@ResponseBody
	public String userGetErrorSubjcet(String limit ,String page,String contentType,HttpSession session) {
		Userinfo  user = (Userinfo) session.getAttribute("crruentUser"); //得到当前用户。 
		Map<String,Object> collectList = collectService.getUserCollect(limit,page,contentType,user);
		return TableUtil.tableRander(Collect.class, collectList, "list");
	}
	
	
	/**
	 * 
	 * <p>Title: userDeleteCollect</p>  
	 * <p>Description: 用户删除自己的收藏</p> 
	 * <p>data:2019年4月16日 下午10:11:43 </p> 
	 * @param collectid
	 * @return
	 */
	@RequestMapping(value="user_delete_collect.action",produces= {"text/html;charset=utf-8"})
	@ResponseBody
	public String userDeleteCollect(String collectid) {
		JSONObject result = new JSONObject();
		String msg = "删除失败，数据异常";
		boolean isok = collectService.deleteConlletByConllectid(collectid);
		if(isok) {
			msg = "删除成功";
		}
		result.put("msg", msg);
		return result.toString();
	}
	
	
	
	

}
