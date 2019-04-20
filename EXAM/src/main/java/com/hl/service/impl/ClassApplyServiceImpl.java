package com.hl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.mapper.ClassApplyMapper;
import com.hl.service.ClassApplyService;

@Service
public class ClassApplyServiceImpl implements ClassApplyService{

	@Autowired
	private ClassApplyMapper classApplyMapper;
	@Override
	public boolean insertClassApply(Integer classid, Integer userid) {
		
		return classApplyMapper.insertClassApply(classid, userid) > 0;
	}

}
