package com.hl.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.entity.RPostBar;
import com.hl.entity.Userinfo;
import com.hl.mapper.RPostBarMapper;
import com.hl.service.PostBarService;
import com.hl.service.RPostBarService;
import com.hl.util.string.StringUtil;

@Service
public class RPostBarServiceImpl implements RPostBarService{
	
	 
	
	private static Logger logger = Logger.getLogger(RPostBarServiceImpl.class);
	
	@Autowired
	private PostBarService postBarService;
	@Autowired
	private RPostBarMapper rPostBarMapper;
	@Override
	public List<RPostBar> showRPostBarByPbid(String pbid) {

		if(!StringUtil.isInteger(pbid)) {
			return new ArrayList<>(0);
		}
		int pbidInt = Integer.parseInt(pbid);
		logger.info("===========查询帖子的回帖||pbidInt="+pbidInt+"===========");
		return rPostBarMapper.listRPostBar(pbidInt);
	}
	
	@Override
	public boolean receivePostBar(String pbid, String rquescontent, Userinfo user) {
		logger.info("===========回复指定的帖子||pbid="+pbid+"===========");
		if(!StringUtil.isInteger(pbid) || user == null || rquescontent == null || "".equals(rquescontent)) {
			return false;
		}
		int pbidInt = Integer.parseInt(pbid);
		int userid = user.getUserid();
		Date rqtime = new Date(new java.util.Date().getTime());
		RPostBar rPostBar = new RPostBar();
		rPostBar.setPbid(pbidInt);
		rPostBar.setRqtime(rqtime);
		rPostBar.setRquescontent(rquescontent);
		rPostBar.setUserid(userid);
		int result = rPostBarMapper.addRPostBar(rPostBar);
		if(result > 0) { //更新帖子表中回帖的数据字段
			postBarService.updatePostBarByPbid(1, null, null, pbid);
		}
		return result > 0;
	}

}
