package com.hl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.Collect;
import com.hl.entity.Userinfo;
import com.hl.mapper.CollectMapper;
import com.hl.service.CollectService;
import com.hl.util.string.StringUtil;

@Service
public class CollectServiceImpl implements CollectService{

	@Autowired
	private CollectMapper collectMapper;
	@Override
	public boolean userCollectSubject(Userinfo user, String sid) {
		int sidInt = Integer.parseInt(sid);
		int userid = user.getUserid();
		String contenttype = "subject_collect";
		if(collectMapper.collectIsExist(userid,0,sidInt) > 0) {
            return false;			
		}
		return collectMapper.insertCollect(userid,sidInt,0,contenttype) > 0;
	}

	@Override
	public boolean userCollectPaper(Userinfo user, String pid) {
		int pidInt = Integer.parseInt(pid);
		int userid = user.getUserid();
		if(collectMapper.collectIsExist(userid,pidInt,0) > 0) {  //如果收藏已经存在就不在收藏
            return false;			
		}
		String contenttype = "paper_collect";
		return collectMapper.insertCollect(userid,0,pidInt,contenttype) > 0;
	}

	@Override
	public Map<String, Object> getUserCollect(String limitStr, String pageStr, String contentType, Userinfo user) {
		if(!StringUtil.isInteger(pageStr)||!StringUtil.isInteger(limitStr)) {
			return new HashMap<String,Object>(0);
		}
		int userid = user.getUserid();
		Map<String,Object> result = new HashMap<>();
		int pageInt = Integer.parseInt(pageStr);
		int limit = Integer.parseInt(limitStr);
		Page<Object> page = PageHelper.startPage(pageInt, limit, true);
		List<Collect> list = collectMapper.listCollectByUserid(userid,contentType);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}

	@Override
	public boolean deleteConlletByConllectid(String collectid) {
		if(!StringUtil.isInteger(collectid)) {
			return false;
		}else {
			int collectidInt = Integer.parseInt(collectid);
			return collectMapper.deleteConlletByConllectid(collectidInt);
		}
	}

}
