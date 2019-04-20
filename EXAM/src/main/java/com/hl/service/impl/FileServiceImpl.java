package com.hl.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hl.entity.File;
import com.hl.entity.Userinfo;
import com.hl.mapper.FileMapper;
import com.hl.service.FileService;
import com.hl.util.file.FileUploadUtil;

/**
 * 
 * 文件的服务层
 * @author hl
 *
 */
@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	private FileMapper fileMapper;

	@Override
	public File uploadFile(MultipartFile file, HttpServletRequest request, Userinfo user,String FileType) {
		File f = new File();
		String UUIDFileName = FileUploadUtil.buildUUIDFileName(user.getUsertruename());
		Map<String, String> uploadMessage = FileUploadUtil.upload(file, request, UUIDFileName); //调用工具类上传文件
		//给文件对象设置相关信息
		f.setFilename(uploadMessage.get("fileName"));
		f.setFileurl(uploadMessage.get("fileUrlTemp"));
		f.setType(FileType);
		f.setUploadpath(uploadMessage.get("uploadPath"));
		if(uploadMessage.get("msg").equals("成功")) {//得到文件上传工具类的信息，判断文件上传是否成功，如果成功更新数据库信息。
			fileMapper.insertFile(f);
			//System.out.println(f);
		}else {//若文件上传到本地失败，回滚事物。清除
			f = null;
			//System.out.println("文件上传失败");
		}
		return f;
	}

	@Override
	public List<File> listFileFromCourse(int courseidInt, String fileType) {
		
		return fileMapper.listFileFromCourse(courseidInt,fileType);
	}

}
