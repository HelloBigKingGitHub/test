package com.hl.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.service.RPostBarService;

public class RPostBarServiceImplTest extends BaseTest{

	@Autowired
	private RPostBarService rps;
	@Test
	public void testShowRPostBarByPbid() {
	
		String pbid = "2";
		rps.showRPostBarByPbid(pbid);
	}

}
