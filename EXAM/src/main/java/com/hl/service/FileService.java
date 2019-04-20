package com.hl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.hl.entity.File;
import com.hl.entity.Userinfo;

/**
 * 文件操作的服务层
 * @author hl
 *
 */
public interface FileService {

	/**
	 * 上传文件
	 * @param file
	 * @param request
	 * @param user
	 * @return 文件对象
	 */
	File uploadFile(MultipartFile file, HttpServletRequest request, Userinfo user,String FileType);

	/**
	 * 
	 * <p>Title: listFileFromCourse</p>  
	 * <p>Description: 查询课程中的相关文件信息</p> 
	 * <p>data:2019年4月20日 下午8:41:09 </p> 
	 * @param courseidInt
	 * @param fileType
	 * @return
	 */
	List<File> listFileFromCourse(int courseidInt, String fileType);

}
