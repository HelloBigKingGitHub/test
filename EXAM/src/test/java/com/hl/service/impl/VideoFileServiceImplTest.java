package com.hl.service.impl;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.VideoFile;
import com.hl.service.VideoFileService;

public class VideoFileServiceImplTest extends BaseTest{

	@Autowired
	private VideoFileService vs;
	
	@Test
	public void testInsertVideoFile() {
		VideoFile vf = new VideoFile();
		vf.setCourseid(1);
		vf.setFilename("测试用例文件名1");
		vf.setUrl("测试用例文件路径1");
		vs.insertVideoFile(vf);
	}

}
