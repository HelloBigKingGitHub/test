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
import com.hl.entity.ErrorSubject;
import com.hl.entity.Subject;
import com.hl.entity.Userinfo;
import com.hl.mapper.ErrorSubjectMapper;
import com.hl.service.ErrorSubjectService;
import com.hl.util.string.StringUtil;

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
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}

	@Override
	public Set<Userinfo> queryUserOfErrorSubject(Subject subject) {
		// TODO Auto-generated method stub
		return errorSubjectMapper.queryUserOfErrorSubject(subject);
	}

	@Override
	public Map<String,Object> getErrorSubjectByUser(String limitStr, String pageStr, String scontent, Userinfo user) {
		if(!StringUtil.isInteger(pageStr)||!StringUtil.isInteger(limitStr)) {
			return new HashMap<String,Object>(0);
		}
		int userid = user.getUserid();
		Map<String,Object> result = new HashMap<>();
		int pageInt = Integer.parseInt(pageStr);
		int limit = Integer.parseInt(limitStr);
		Page<Object> page = PageHelper.startPage(pageInt, limit, true);
		List<ErrorSubject> list = errorSubjectMapper.listErrorSubjectByUserid(userid,scontent);
		{//简单的去重代码
			Set<ErrorSubject> set = new HashSet<>(list);
			list = new ArrayList<>(set);
		}
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}

	@Override
	public boolean userDeleteErrorSubject(Userinfo user, String esid) {
		int userid = user.getUserid();
		if(!StringUtil.isInteger(esid)) {
			return false;
		}
		int esidInt = Integer.parseInt(esid); 
		return errorSubjectMapper.updateErrorSubjectLogicDelete(userid,esidInt);
	}
	
	

}
