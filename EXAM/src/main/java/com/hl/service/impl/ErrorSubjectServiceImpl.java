package com.hl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.ErrorSubject;
import com.hl.entity.Subject;
import com.hl.entity.Userinfo;
import com.hl.mapper.ErrorSubjectMapper;
import com.hl.service.ErrorSubjectService;

@Service
public class ErrorSubjectServiceImpl implements ErrorSubjectService{
	@Autowired
	private ErrorSubjectMapper errorSubjectMapper;

	@Override
	public boolean addErrorSubject(ErrorSubject errorSubject) {
		// TODO Auto-generated method stub
		return errorSubjectMapper.insertErrorSubject(errorSubject)>0;
	}

	@Override
	public ErrorSubject ErrorSubjectIsExist(ErrorSubject errorSubject) {
		// TODO Auto-generated method stub
		return errorSubjectMapper.errorSubjectIsExist(errorSubject);
	}

	@Override
	public List<ErrorSubject> listErrorSubject() {
		
		return errorSubjectMapper.listErrorSubject();
	}

	@Override
	public Map<String,Object> listErrorSubjectPage(Integer pageNum, Integer pageSize) {
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<ErrorSubject> list = listErrorSubject();
		int pages = page.getPages();
		result.put("list", list);
		result.put("pages", pages);
		return result;
	}

	@Override
	public Set<Userinfo> queryUserOfErrorSubject(Subject subject) {
		// TODO Auto-generated method stub
		return errorSubjectMapper.queryUserOfErrorSubject(subject);
	}
	
	

}
