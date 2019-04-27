package com.hl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.entity.RPostBar;
import com.hl.mapper.RPostBarMapper;
import com.hl.service.RPostBarService;
import com.hl.util.string.StringUtil;

@Service
public class RPostBarServiceImpl implements RPostBarService{
	
	 
	
	private static Logger logger = Logger.getLogger(RPostBarServiceImpl.class);
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

}
