package com.hl.service.impl;


import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.ClazzAnnouncement;
import com.hl.entity.Userinfo;
import com.hl.service.ClazzAnnouncementService;

/**
 * 测试类
 * @author hl
 *
 */
public class ClazzAnnouncementServiceImplTest extends BaseTest{

	@Autowired
	private ClazzAnnouncementService cas;
	
	@Test
	public void testAddClassAnnouncement() {
		cas.addClassAnnouncement("1", "测试公告标题", "测试公告内容");
	}

	@Test
	public void testGetAnnountcement() {
		Userinfo user = new Userinfo();
		user.setUserid(8);
		String pageNumStr = "1";
		String pageSizeStr = "10";
		Map<String ,Object>result = cas.getAnnountcement(pageNumStr, pageSizeStr, user);
		List<ClazzAnnouncement>list = (List<ClazzAnnouncement>) result.get("list");
		for (ClazzAnnouncement clazz : list) {
			System.out.println(clazz);
		}
	}

}
