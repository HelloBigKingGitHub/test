package com.hl;

import java.io.File;

import org.junit.Test;

public class TestURl {

	@Test
	public void urlTest() {
		String url = "upload/18573244627/2019-03-23/黄亮_aa137e90-09b2-48c7-ab16-bf5a0b284cce_colock_icon.png";
		String temp = url.replaceAll("//", File.separator);		
		System.out.println(temp);
	}
}
