package com.hl.service.impl;


import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.Paper;
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

}
