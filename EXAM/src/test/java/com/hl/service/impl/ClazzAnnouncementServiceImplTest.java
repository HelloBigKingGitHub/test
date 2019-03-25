package com.hl.service.impl;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
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

}
