package com.hl.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.ClazzAnnouncement;
import com.hl.entity.Message;
import com.hl.entity.Userinfo;
import com.hl.mapper.ClazzAnnouncementMapper;
import com.hl.service.ClazzAnnouncementService;

@Service
public class ClazzAnnouncementServiceImpl implements ClazzAnnouncementService{
	
	@Autowired
	private ClazzAnnouncementMapper clazzAnnouncementMapper;

	@Override
	public boolean addClassAnnouncement(String classid, String catitle, String camsg) {
		if(classid==null || "".equals(classid)) {
			return false;
		}
		Integer clazzid = Integer.parseInt(classid);
		ClazzAnnouncement clazzAnnouncement = new ClazzAnnouncement();
		clazzAnnouncement.setCamsg(camsg);
		clazzAnnouncement.setCatitle(catitle);
		clazzAnnouncement.setClassid(clazzid);
		Date nowDate = new Date();
		clazzAnnouncement.setCatime(new java.sql.Date(nowDate.getTime()));
		return clazzAnnouncementMapper.insertClazzAnnouncement(clazzAnnouncement) > 0;
	}

	@Override
	public Map<String, Object> getAnnountcement(String pageStr, String limitStr, Userinfo user) {
		if(user.getUserid()==null||pageStr==null||limitStr==null) {
			return null;
		}
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limitStr);
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Message> announcement = clazzAnnouncementMapper.getClassAnnouncementOfUser(user.getUserid());
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", announcement);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}

}
