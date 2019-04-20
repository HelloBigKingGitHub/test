package com.hl.service.impl;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.service.ClassApplyService;

public class ClassApplyServiceImplTest extends BaseTest{

	@Autowired
	private ClassApplyService classApplyService;
	@Test
	public void testInsertClassApply() {
		
		classApplyService.insertClassApply(3, 7);
	}

}
