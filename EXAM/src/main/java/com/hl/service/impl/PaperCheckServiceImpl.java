package com.hl.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.PaperCheck;
import com.hl.entity.PaperDetail;
import com.hl.mapper.PaperCheckMapper;
import com.hl.service.PaperCheckService;

/**
 * 
 * @author hl
 *
 */
@Service
public class PaperCheckServiceImpl implements PaperCheckService{

	@Autowired
	private PaperCheckMapper paperCheckMapper;
	@Override
	public boolean insertPaperCheck(PaperCheck paperCheck) {
		
		return paperCheckMapper.insertPaperCheck(paperCheck) > 0;
	}
	
	@Override
	public Map<String, Object> listCheckPaperByTeacherId(String pageStr, String limit, String teacherid) {
		Integer teacher = null;
		if(teacherid!=null&&!("".equals(teacherid))) {
			teacher = Integer.parseInt(teacherid);
		}else {
			teacher = 0;
		}
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limit);
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<PaperDetail> list = paperCheckMapper.listCheckPaperByTeacherId(teacher);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}
	
	

}
