package com.hl.mapper;

import com.hl.entity.VideoFile;  

/**
 * 管理file表的数据库mapper接口
 * @author hl
 *
 */
public interface VideoFileMapper {
	

	/**
	 * 插入一条新的视频文件记录。
	 * @param videoFile
	 * @return 操作数
	 */
	int insertVideoFile(VideoFile videoFile); 

}
