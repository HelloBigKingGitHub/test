package com.hl.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.entity.ClazzAnnouncement;
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

}
