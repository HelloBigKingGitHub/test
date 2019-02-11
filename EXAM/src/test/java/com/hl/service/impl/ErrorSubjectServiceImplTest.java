package com.hl.service.impl;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.ErrorSubject;
import com.hl.entity.Subject;
import com.hl.service.ErrorSubjectService;

public class ErrorSubjectServiceImplTest extends BaseTest {

	@Autowired
	private ErrorSubjectService errorSubjectServiceImpl;
	@Test
	public void test() {
		Map<String, Object> result = null;
		try {
			result = errorSubjectServiceImpl.listErrorSubjectPage(2, 5);
			System.out.println("总页数="+result.get("pages"));
			System.out.println("list集合"+result.get("list"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<ErrorSubject> list = (List<ErrorSubject>) result.get("list");
		for (ErrorSubject errorSubject : list) {
			
			System.out.println(errorSubject);
		}
		/*
		try {
			System.out.println(errorSubjectServiceImpl.listErrorSubject());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	@Test
	public void ErrorSubjectIsExistTest() {
		ErrorSubject es = new ErrorSubject();
		Subject s = new Subject();
		s.setSid(1);
		es.setSubject(s);
		es.setEkey("A");
		try {
			System.out.println(errorSubjectServiceImpl.ErrorSubjectIsExist(es));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryUserOfErrorSubject() {
		Subject subject = new Subject();
		subject.setSid(1);
		System.out.println(errorSubjectServiceImpl.queryUserOfErrorSubject(subject));
	}
}
