package com.hl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.PaperCheck;
import com.hl.entity.PaperDetail;
import com.hl.entity.Userinfo;
import com.hl.mapper.PaperCheckMapper;
import com.hl.service.PaperCheckService;
import com.hl.service.PaperService;
import com.hl.util.string.StringUtil;

/**
 * 
 * @author hl
 *
 */
@Service
public class PaperCheckServiceImpl implements PaperCheckService{

	@Autowired
	private PaperCheckMapper paperCheckMapper;
	
	@Autowired
	private PaperService paperService;
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

	@Override
	public boolean deleteCheckPaper(String pid, String checkteacherid) {
		if(!StringUtil.isInteger(checkteacherid) || !StringUtil.isInteger(pid)) {
			return false;
		}
		int pidInt = Integer.parseInt(pid);
		int checkteacheridInt = Integer.parseInt(checkteacherid);
		return paperCheckMapper.deleteCheckPaper(pidInt,checkteacheridInt) > 0;
	}

	
	@Override
	public List<String> getCheckResult(String pid) {
		if(!StringUtil.isInteger(pid)) {
			return new ArrayList<String>(0);
		}
		int pidInt = Integer.parseInt(pid);
		return paperCheckMapper.getCheckRest(pidInt);
	}

	
	@Override
	public boolean CheckPaper(String pid, String checkcontent, Userinfo user) {
		
		if(!StringUtil.isInteger(pid) || user == null || checkcontent == null || "".equals(checkcontent) ) {
			return false;
		}
		String tongyi = checkcontent.substring(0, 2);
		
		int pidInt = Integer.parseInt(pid);
		int userid = user.getUserid();
		if(tongyi.contains("同意")) { //更新数据库中paper表中state
			paperService.updatePaperState(1,pidInt);
		}
		return paperCheckMapper.update(pidInt,userid,checkcontent) > 0;
	}
	
	

}
