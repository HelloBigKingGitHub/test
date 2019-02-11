package com.hl.service.impl;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.hl.BaseTest;
import com.hl.entity.Userinfo;
import com.hl.service.UserService;

public class UserinfoServiceImplTest extends BaseTest{

	@Autowired
	private UserService userinfoService;
	@Test
	public void testListUserinfo() {
		System.out.println(userinfoService.listUserinfo());
	}
	
	@Test
	public void teststPageUserinfo() {
		System.out.println(userinfoService.listPageUserinfo(1, 2));
		
	}

}
