package com.hl.service.impl;


import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.Paper;
import com.hl.entity.Userinfo;
import com.hl.service.PaperCheckService;

public class PaperCheckServiceImplTest extends BaseTest{

	@Autowired
	private PaperCheckService ps;
	@Test
	public void testListCheckPaperByTeacherId() {
		
		Map<String, Object> map = ps.listCheckPaperByTeacherId("1", "10", "4");
		List<Paper> list = (List<Paper>) map.get("list");
		for (Paper paper : list) {
			System.out.println(paper);
		}
	}
	@Test
	public void testDeleteCheckPaper() {
		String pid = "6";
		String checkteacherid = "4";
		ps.deleteCheckPaper(pid, checkteacherid);
		
	}
	
	@Test
	public void testGetCheckResult() {
		String pid = "6";
		ps.getCheckResult(pid);
	}
	
	@Test
	public void testCheckPaper() {
		String pid = "6";
		String checkcontent = "同意 asdsadsadsadsadasdsadas";
		Userinfo user = new Userinfo();
		user.setUserid(4);
		ps.CheckPaper(pid, checkcontent, user);
		
	}
	
	

}
