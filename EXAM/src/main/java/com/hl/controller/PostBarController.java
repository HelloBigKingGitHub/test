package com.hl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.PostBar;
import com.hl.entity.RPostBar;
import com.hl.entity.Userinfo;
import com.hl.service.PostBarService;

import net.sf.json.JSONObject;

/**
 * 
 * <p>Title: PostBarController</p>  
 * <p>Description: 问答贴吧控制器</p>  
 * @author huangliang 
 * @date 2019年4月24日
 */
@Controller
public class PostBarController {
	
	@Autowired
	private PostBarService postBarService;

	/**
	 * 
	 * <p>Title: addPostBar</p>  
	 * <p>Description:  添加一条帖子（发帖）</p> 
	 * <p>data:2019年4月24日 下午9:19:27 </p> 
	 * @param title
	 * @param content
	 * @param reward
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "add_postbar.action", produces = { "html/text;charset=utf-8" })
	@ResponseBody
	public String addPostBar( String title, String content, String reward, HttpSession session) {
		JSONObject result = new JSONObject();
		Userinfo user = (Userinfo) session.getAttribute("crruentUser");
		String msg = "发帖失败";
		int isok = postBarService.addPostBar(title,content,reward,user);	
		if(isok == 2) {
			msg = "请确认是否登录，赏金必须为正整数";
		}else if(isok == 0) {
			msg = "发帖成功";
		}else if(isok == 1) {
			
		}else {
			msg = "系统故障联系管理员";
		}
		result.put("msg", msg);
		return result.toString();
	}
	
	
	/**
	 * 
	 * <p>Title: showPostBarList</p>  
	 * <p>Description: 展示帖子列表</p> 
	 * <p>data:2019年4月27日 下午3:39:14 </p> 
	 * @return
	 */
	@RequestMapping(value = "show_postbar_list.action", produces = { "html/text;charset=utf-8" })
	@ResponseBody
	public String showPostBarList(String page, String limit, String title) {
		JSONObject result = new JSONObject();
		Map<String,Object> postBarList = postBarService.listPostBarByTitle(page, limit, title);
		result.put("count", (long)postBarList.get("count"));
		result.put("PostBars", (List<PostBar>)postBarList.get("list"));
		return result.toString();
	}
	
	/**
	 * 
	 * <p>Title: showPostBarList</p>  
	 * <p>Description: 根据id的到一个帖子和他的回帖</p> 
	 * <p>data:2019年4月27日 下午3:39:14 </p> 
	 * @return
	 */
	@RequestMapping(value = "show_postbar_detail.action", produces = { "html/text;charset=utf-8" })
	@ResponseBody
	public String showPostBarDetail(String pbid) {
		JSONObject result = new JSONObject();
		Map<String,Object> postBarList = postBarService.showPostBarDetailByPbid(pbid);
		result.put("postbar", (PostBar)postBarList.get("postbar"));
		result.put("rpostbars", (List<RPostBar>)postBarList.get("rpostbars"));
		return result.toString();
	}
	
}
