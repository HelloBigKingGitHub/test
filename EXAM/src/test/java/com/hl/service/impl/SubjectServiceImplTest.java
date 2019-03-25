package com.hl.service.impl;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.ChoseSubject;
import com.hl.entity.SubjectDetail;
import com.hl.service.SubjectService;

public class SubjectServiceImplTest extends BaseTest{
	
	@Autowired
	private SubjectService subjectServiceImpl;
	
	@Test
	public void testListChoseSubject() {
		System.out.println(subjectServiceImpl.listChoseSubject());
	}
	
	@Test
	public void testListChoseSubjectLikeScontentPage() {
		System.out.println(subjectServiceImpl.listChoseSubjectLikeScontentPage(1, 3, "的"));
	}

	@Test
	public void testInsertChoseSubject() {
		ChoseSubject choseSubject = new ChoseSubject();
		choseSubject.setSa("a");
		choseSubject.setScontent("测试题干");
		choseSubject.setSb("b");
		choseSubject.setSc("c");
		choseSubject.setSd("d");
		choseSubject.setSstate(1);
		choseSubject.setSkey("b");
		choseSubject.setTestcount(0);
		
		boolean info = subjectServiceImpl.insertChoseSubject(choseSubject);
		System.out.println(choseSubject.getSid());
	    System.out.println(info);
	}
	
	@Test
	public void testInsertChoseSubjectAndGetSid() {
		ChoseSubject choseSubject = new ChoseSubject();
		choseSubject.setSa("a");
		choseSubject.setScontent("测试题干");
		choseSubject.setSb("b");
		choseSubject.setSc("c");
		choseSubject.setSd("d");
		choseSubject.setSstate(1);
		choseSubject.setSkey("b");
		choseSubject.setTestcount(0);
		
		int  info = subjectServiceImpl.insertSubjectAndGetSid(choseSubject);
		System.out.println(choseSubject.getSid());
	    System.out.println(info);
	}
	
	@Test
	public void testGetSubjectDetail() {
		SubjectDetail subjectDetail = subjectServiceImpl.getSubjectDetail("1");
		System.out.println(subjectDetail);
	}

}
