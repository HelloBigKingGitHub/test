package com.hl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.ChoseSubject;
import com.hl.entity.SubjectDetail;
import com.hl.mapper.ErrorSubjectMapper;
import com.hl.mapper.SubjectMapper;
import com.hl.service.SubjectService;
import com.hl.util.string.StringUtil;

@Service
public class SubjectServiceImpl implements SubjectService{
	@Autowired
	private SubjectMapper subjectMapper;
	
	@Autowired
	private ErrorSubjectMapper errorSubjectMapper;

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

	

	@Override
	public boolean updataChoseSubject(ChoseSubject choseSubject) {
		return subjectMapper.updataSubject(choseSubject)>0;
	}


	@Override
	public SubjectDetail getSubjectDetail(String sid) {
		if(sid!=null && !("".equals(sid))) {
			Integer id = Integer.parseInt(sid);
			System.out.println(id);
			SubjectDetail sd =  subjectMapper.getSubjectDetail(id);
			//SubjectDetail sd = new SubjectDetail();
			int errorcount = errorSubjectMapper.getErrorCountBySid(id);
			sd.setErrorcount(errorcount);
		
			return sd;
		}
		
		return null;
		
	}

	

	@Override
	public int insertSubjectAndGetSid(ChoseSubject choseSubject) {
		
		return  subjectMapper.insertSubjectAndGetSid(choseSubject);
	}


	@Override
	public List<ChoseSubject> listChoseSubjectByIds(List<String> subjectidList) {
		
		List<ChoseSubject> list = new ArrayList<>();
		ChoseSubject choseSubject = new ChoseSubject();
		for (String string : subjectidList) {//controller层进行了数据合理化判断，所以直接遍历
			Integer sid = Integer.parseInt(string);
			choseSubject = subjectMapper.getChoseSubjectById(sid);
			list.add(choseSubject);
		}
		return list;
	}


	@Override
	public ChoseSubject getChoseSubjectBySid(String sid) {
		if(!StringUtil.isInteger(sid)) {
			return new ChoseSubject();
		}
		int sidInt = Integer.parseInt(sid);
		return subjectMapper.getChoseSubjectById(sidInt);
	}








}
