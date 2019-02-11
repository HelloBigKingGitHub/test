package com.hl.util.sms;


import org.junit.Test;

public class IndustrySMSTest {

	@Test
	public void testExecute() {
		IndustrySMS.execute("18573244627",IndustrySMS.RandomCode());
	}
    //经过测试发送短信有效。
	@Test
	public void testRandomCode() {
		String randomCode = IndustrySMS.RandomCode();
		System.out.println(randomCode);
	}
}
