package com.hl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hl.entity.File;

/**
 * 有关file数据库表的mapper接口层
 * @author hl
 * 
 *
 */
public interface FileMapper {

	/**
	 * 添加一条文件记录
	 * @param f
	 * @return 操作数
	 */
	int insertFile(File f);
	

	/**
	 * 
	 * <p>Title: listFileFromCourse</p>  
	 * <p>Description: 查询出有关某个课程的相关文件</p> 
	 * <p>data:2019年4月20日 下午8:43:06 </p> 
	 * @param courseidInt
	 * @param fileType
	 * @return
	 */
	List<File> listFileFromCourse(@Param("courseid")int courseidInt, @Param("fileType")String fileType);

}
