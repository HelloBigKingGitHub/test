package com.hl.service.impl;

import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.ScoreDetail;
import com.hl.entity.Userinfo;
import com.hl.service.ScoreService;

public class ScoreServiceImplTest extends BaseTest{
	
	@Autowired
	private ScoreService scoreService;

	@Test
	public void testInsertScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testListScoreByUser() {
		Userinfo user = new Userinfo();
		user.setUserid(6);
		String page = "1";
		String limit = "10";
		String pid = "1";
		String pname = "测试";
		String teacherid = "6";
		Map<String, Object> listScoreByUser = scoreService.listScoreByUser(page, limit, user, pid, pname, teacherid);
		List<ScoreDetail> list = (List<ScoreDetail>)listScoreByUser.get("list");
		
		for (ScoreDetail scoreDetail : list) {
			
			System.out.println(scoreDetail);
		}
	}
	
	@Test
	public void testListScoreByUserForChart() {
		Userinfo user = new Userinfo();
		user.setUserid(6);
		Map<String, String> listScoreByUserForChart = scoreService.listScoreByUserForChart(user);
		System.out.println(listScoreByUserForChart.get("pnames"));
		System.out.println(listScoreByUserForChart.get("scores"));
	}

}
