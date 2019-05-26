package com.hl.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.PostBar;
import com.hl.entity.RPostBar;
import com.hl.entity.Userinfo;
import com.hl.mapper.PostBarMapper;
import com.hl.service.PostBarService;
import com.hl.service.RPostBarService;
import com.hl.util.date.SimpleDateFormatUtil;
import com.hl.util.string.StringUtil;

/**
 * 
 * <p>Title: PostBarServiceImpl</p>  
 * <p>Description: 帖子服务层实现类</p>  
 * @author huangliang 
 * @date 2019年4月24日
 */
@Service
public class PostBarServiceImpl implements PostBarService{

	@Autowired
	private PostBarMapper postBarMapper;
	@Autowired
	private RPostBarService rPostBarService;
	
	@Override
	public int addPostBar(String title, String content, String reward, Userinfo user) {
		
		if(!StringUtil.isInteger(reward) || user == null) {
			return 2;
		}
		int rewardInt = Integer.parseInt(reward);
		PostBar postBar = new  PostBar();
		Date questime = new Date(new java.util.Date().getTime());
		postBar.setQuestime(questime);
		postBar.setQuescontent(content);
		postBar.setReward(rewardInt);
		postBar.setUserid(user.getUserid());
		postBar.setQuestitle(title);
		return postBarMapper.addPostBar(postBar) - 1;
		
	}
	
	@Override
	public int updatePostBarByPbid(int quescount, String liulancount, String liulantime, String qbid) {
		// TODO Auto-generated method stub
		if(!StringUtil.isInteger(qbid)) {
			return -1;
		}
		int pbid = Integer.parseInt(qbid);
		return postBarMapper.update(quescount,liulancount,liulantime,pbid);
	}
	@Override
	public Map<String, Object> listPostBarByTitle(String pageStr, String limitStr, String title) {
		if(!StringUtil.isInteger(limitStr) || !StringUtil.isInteger(pageStr)) {
			return new HashMap<>(0);
		}
		Map<String,Object> result = new HashMap<>();
		int pageInt = Integer.parseInt(pageStr);
		int limit = Integer.parseInt(limitStr);
		Page<Object> page = PageHelper.startPage(pageInt, limit, true);
		List<PostBar> list = postBarMapper.listPostBarByTitle(title);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
		
	}
	@Override
	public List<RPostBar> showRPostBarByPbid(String pbid) {
		// TODO Auto-generated method stub
		return rPostBarService.showRPostBarByPbid(pbid);
	}

	@Override
	public Map<String, Object> showPostBarDetailByPbid(String pbid) {
		if(!StringUtil.isInteger(pbid)) {
			return new HashMap<>(0);
		}
		Map<String, Object> result = new HashMap<>(); 
		int pbidInt = Integer.parseInt(pbid);
		//1.修改帖子的浏览次数，和最后一次浏览时间
		java.util.Date newDate = new java.util.Date();
		String liulantime = SimpleDateFormatUtil.getInstance().format(newDate);
		updatePostBarByPbid(0, "add",liulantime, pbid);
		
		//2.查询所有的回帖
		List<RPostBar> RPostBars = showRPostBarByPbid(pbid);
		//3.查询帖子的信息
		PostBar postbar = postBarMapper.getPostBarByPbid(pbidInt);
		result.put("postbar", postbar);
		result.put("rpostbars", RPostBars);
		return result;
	}

	@Override
	public Map<String, Object> listUserPostBarByTitle(String pageStr, String limitStr, String title, Userinfo user) {
		if(!StringUtil.isInteger(limitStr) || !StringUtil.isInteger(pageStr) || user == null) {
			return new HashMap<>(0);
		}
		int userid = user.getUserid();
		Map<String,Object> result = new HashMap<>();
		int pageInt = Integer.parseInt(pageStr);
		int limit = Integer.parseInt(limitStr);
		Page<Object> page = PageHelper.startPage(pageInt, limit, true);
		List<PostBar> list = postBarMapper.listUserPostBarByTitle(title,userid);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}

}
