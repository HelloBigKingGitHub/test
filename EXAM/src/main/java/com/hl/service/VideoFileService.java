package com.hl.service;

import com.hl.entity.VideoFile;

/**
 * 负责为视频文件进行服务的服务层接口
 * @author hl
 *
 */
public interface VideoFileService {
	
	/**
	 * 新增加一条视频
	 * @param videoFile
	 */
	boolean insertVideoFile(VideoFile videoFile);

}
