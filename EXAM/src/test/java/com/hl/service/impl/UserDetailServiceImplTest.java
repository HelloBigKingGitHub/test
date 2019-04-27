package com.hl.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.UserDetail;
import com.hl.entity.Userinfo;
import com.hl.formbean.UserSetBean;
import com.hl.service.UserDetailService;

public class UserDetailServiceImplTest extends BaseTest{

	@Autowired
	private UserDetailService userDetailService;
	@Test
	public void testSetUserDetail() {
	
		UserSetBean userSetBean = new UserSetBean();
		userSetBean.setCity("湘潭");
		userSetBean.setEmail("1330818611@qq.com");
		userSetBean.setMotto("我是菜，但我不是大白菜！！");
		userSetBean.setSex("0");
		userSetBean.setUsername("修改名字");
		Userinfo currentUser = new Userinfo();
		currentUser.setUserid(6);
		currentUser.setUsertruename("测试用户");
		userDetailService.setUserDetail(userSetBean, currentUser);
	}

	@Test
	public void testInsertUserDetail() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUserDetail() {
		fail("Not yet implemented");
	}

	@Test
	public void testExistUserDetail() {
		UserDetail userDetail = new UserDetail();
		Userinfo user = new Userinfo();
		user.setUserid(6);
		user.setUsertruename("测试用户");
		userDetail.setEmail("1330818611@qq.com");
        userDetail.setMotto("我是菜，但我不是大白菜！！");
        userDetail.setSex("0");
        userDetail.setUcity("湘潭");
        userDetail.setUser(user);
		UserDetail existUserDetail = userDetailService.existUserDetail(userDetail);
		System.out.println(existUserDetail);;
	}
	
	public void uploadIcon() {
		
		
	}
	@Test
	public void testGetUserDetailByUserid() {
		String userid = "6";
		UserDetail userDetailByUserid = userDetailService.getUserDetailByUserid(userid);
		System.out.println(userDetailByUserid);
	}

}
