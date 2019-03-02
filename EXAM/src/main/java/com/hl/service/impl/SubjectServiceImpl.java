package com.hl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.ChoseSubject;
import com.hl.formbean.ChoseSubjectFormBean;
import com.hl.mapper.SubjectMapper;
import com.hl.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{
	@Autowired
	private SubjectMapper subjectMapper;

	@Override
	public List<ChoseSubject> listChoseSubject() {
		return subjectMapper.listChoseSubject();
	}
	
	
	@Override
	public Map<String,Object> listChoseSubjectPage(Integer pageNum, Integer pageSize) {
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<ChoseSubject> list = listChoseSubject();
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}
	
	@Override
	public Map<String, Object> listChoseSubjectLikeScontentPage(Integer pageNum, Integer pageSize, String scontent) {
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<ChoseSubject> list = subjectMapper.listChoseSubjectLikeScontent(scontent);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}
	
	@Override
	public boolean insertChoseSubject(ChoseSubject choseSubject) {
		
		return subjectMapper.insertSubject(choseSubject)>0;
	}








}
