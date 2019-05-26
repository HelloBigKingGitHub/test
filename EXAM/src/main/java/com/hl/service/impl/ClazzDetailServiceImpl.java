package com.hl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.entity.ClazzAnnouncement;
import com.hl.entity.File;
import com.hl.entity.UserDetail;
import com.hl.mapper.ClazzDetailMapper;
import com.hl.service.ClazzDetailService;
import com.hl.util.string.StringUtil;
/**
 * 
 * <p>Title: ClazzDetailServiceImpl</p>  
 * <p>Description: 班级详细信息的服务层</p>  
 * @author huangliang 
 * @date 2019年5月6日
 */
@Service
public class ClazzDetailServiceImpl implements ClazzDetailService{

	@Autowired
	private ClazzDetailMapper clazzDetailMapper;
	
	
	@Override
	public List<File> getFilesByClassid(String classid) {
		if(!StringUtil.isInteger(classid)) {
			return new ArrayList<>(0);
		}
		int classidInt = Integer.parseInt(classid);
		return clazzDetailMapper.getFilesByClassid(classidInt);
	}

	@Override
	public UserDetail getTeacherByClassid(String classid) {
		if(!StringUtil.isInteger(classid)) {
			return new UserDetail();
		}
		int classidInt = Integer.parseInt(classid);
		return clazzDetailMapper.getTeacherByClassid(classidInt);
	}

	@Override
	public List<UserDetail> getStudentsByClassid(String classid) {
		if(!StringUtil.isInteger(classid)) {
			return new ArrayList<>(0);
		}
		int classidInt = Integer.parseInt(classid);
		return clazzDetailMapper.getStudentsByClassid(classidInt);
	}

	@Override
	public List<ClazzAnnouncement> getAnnouncementsByClassid(String classid) {
		if(!StringUtil.isInteger(classid)) {
			return new ArrayList<>(0);
		}
		int classidInt = Integer.parseInt(classid);
		return clazzDetailMapper.getAnnouncementsByClassid(classidInt);
	}

}
