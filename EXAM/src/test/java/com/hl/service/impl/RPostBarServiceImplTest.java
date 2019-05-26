package com.hl.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.Userinfo;
import com.hl.service.RPostBarService;

public class RPostBarServiceImplTest extends BaseTest{

	@Autowired
	private RPostBarService rps;
	@Test
	public void testShowRPostBarByPbid() {
	
		String pbid = "2";
		rps.showRPostBarByPbid(pbid);
	}
	
	@Test
	public void testReceivePostBar() {
		String pbid = "5";
		String rquescontent = "test回帖";
		Userinfo user = new Userinfo();
		user.setUserid(6);
		rps.receivePostBar(pbid, rquescontent, user);
	}

}
