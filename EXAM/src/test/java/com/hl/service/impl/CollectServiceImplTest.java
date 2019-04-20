package com.hl.service.impl;


import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.Collect;
import com.hl.entity.Userinfo;
import com.hl.service.CollectService;


public class CollectServiceImplTest extends BaseTest{
	
	@Autowired
	private  CollectService collectService;

	@Test
	public void testUserCollectSubject() {
		Userinfo user = new Userinfo();
		user.setUserid(3);
		String pid = "1";
		boolean userCollectPaper = collectService.userCollectPaper(user, pid);
		System.out.println(userCollectPaper);
	}

	@Test
	public void testUserCollectPaper() {
	}
	
	@Test
	public void testGetUserCollect() {
		Userinfo user = new Userinfo();
		user.setUserid(3);
		String page = "1";
		String limit = "10";
		String contentType = "paper_collect";
		Map<String, Object> userCollect = collectService.getUserCollect(limit, page, contentType, user);
		List<Collect> list = (List<Collect> )userCollect.get("list");
		for (Collect collect : list) {
			System.out.println(collect);
		}
	}
	
	@Test
	public void testUserDeleteCollectByCollectid() {
		String collectid = "3";
		boolean deleteConlletByConllectid = collectService.deleteConlletByConllectid(collectid);
		System.out.println(deleteConlletByConllectid);
		
	}

	
	
	
	
}
