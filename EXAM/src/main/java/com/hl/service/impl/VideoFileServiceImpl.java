package com.hl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.entity.VideoFile;
import com.hl.mapper.VideoFileMapper;
import com.hl.service.VideoFileService;

@Service
public class VideoFileServiceImpl implements VideoFileService{

	@Autowired
	private VideoFileMapper videoFileMapper;
	@Override
	public boolean insertVideoFile(VideoFile videoFile) {
		// TODO Auto-generated method stub
		return videoFileMapper.insertVideoFile(videoFile)>0;
	}

}
