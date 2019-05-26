package com.hl.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.service.ClazzDetailService;

public class ClazzDetailServiceImplTest extends BaseTest{
	
	@Autowired
	private ClazzDetailService cs;

	@Test
	public void testGetFilesByClassid() {
		cs.getFilesByClassid("1");
	}

	@Test
	public void testGetTeacherByClassid() {
		cs.getTeacherByClassid("1");
	}

	@Test
	public void testGetStudentsByClassid() {
		cs.getStudentsByClassid("1");
	}

	@Test
	public void testGetAnnouncementsByClassid() {
		cs.getAnnouncementsByClassid("1");
	}

}
