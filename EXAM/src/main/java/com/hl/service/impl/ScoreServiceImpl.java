package com.hl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.Score;
import com.hl.entity.ScoreDetail;
import com.hl.entity.Userinfo;
import com.hl.mapper.ScoreMapper;
import com.hl.service.ScoreService;
import com.hl.util.string.StringUtil;

@Service
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreMapper scoreMapper;

	@Override
	public boolean insertScore(Score score) {
		
		return scoreMapper.insertScore(score)>0;
	}

	@Override
	public Map<String, Object> listScoreByUser(String pageStr, String limit, Userinfo user, String pid, String ptitle,
			String teacherid) {
		
		int pageNum = Integer.parseInt(pageStr);
		int pageSize = Integer.parseInt(limit);
		Integer pidInt = null;
		Integer teacheridInt = null;
		int userid = user.getUserid();
		if(StringUtil.isInteger(pid)) {
			System.out.println(StringUtil.isInteger(pid));
			pidInt = Integer.parseInt(pid);
		}
		if(StringUtil.isInteger(teacherid)) {
			teacheridInt = Integer.parseInt(teacherid);
		}
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<ScoreDetail> list = scoreMapper.listScoreByUser(userid,pidInt,ptitle,teacheridInt);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", list);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}

	@Override
	public Map<String, String> listScoreByUserForChart(Userinfo user) {
		int userid = user.getUserid();
		Map<String, String> result = new HashMap<>();
		List<ScoreDetail> list = scoreMapper.listScoreByUser(userid,null,null,null);
		List<String> pnames = new ArrayList<>();
		List<Double> scores = new ArrayList<>();
		for (ScoreDetail scoreDetail : list) {
			pnames.add(scoreDetail.getPaper().getPname());
			scores.add(scoreDetail.getScore());
		}
		result.put("pnames", pnames.toString());
		result.put("scores", scores.toString());
		return result;
	}

}
