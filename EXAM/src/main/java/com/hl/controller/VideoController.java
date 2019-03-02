package com.hl.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hl.entity.Userinfo;
import com.hl.entity.VideoFile;
import com.hl.service.VideoFileService;

import net.sf.json.JSONObject;

/**
 * 视频以及视频课程的控制层
 * @author hl
 *
 */
@Controller
public class VideoController {
	
	@Autowired
	private VideoFileService videoFileService;
	
	
	
	@RequestMapping(value="upload_video.action",produces={"text/html;charset=UTF-8;"})
	public @ResponseBody String uploadVideo(MultipartFile file,HttpServletRequest request,String courseid,String coursename){
		//System.out.println("文件上传开始");
		JSONObject result = new JSONObject();
		int code = 0; //返回状态码
		String msg = "";//返回信息
		JSONObject data = new JSONObject(); //返回数据
		if (courseid!=null&&(!"".equals(courseid))) {
			String scheme = request.getScheme(); //得到协议
			String serverName = request.getServerName(); // 服务器ip地址
			int port = request.getServerPort(); //得到服务器端口号
			String contextPath = request.getContextPath(); //得到项目名 
			String baseUrl = scheme + "://" + serverName + ":" + port + contextPath; //--http://localhost:8080/EXAM
			System.out.println(baseUrl);
			String fileName = buildFileName(courseid, coursename); //构建一个不会重复的文件名
			Map<String, String> map = upload(file, request, fileName);//文件上传
			String fileUrl = baseUrl + "/" + map.get("fileUrlTemp");
			if ("成功".equals(map.get("msg"))) {
				code = 0;
				msg = "添加成功";
				map.remove("msg");
				//调用服务层接口
				VideoFile videoFile = new VideoFile();
				videoFile.setCourseid(Integer.parseInt(courseid));
				videoFile.setFilename(map.get("fileName"));
				videoFile.setUploadpath(map.get("uploadPath"));
				videoFile.setUrl(fileUrl);
				if (videoFileService.insertVideoFile(videoFile)) { //表示添加成功
					data.put("fileUrl", fileUrl);
					data.put("fileName", map.get("fileName"));
				} else {
					removeLocalFile(map.get("fileName"),map.get("uploadPath")); //如果数据库添加失败要将添加到本地的文件删除
					code = 1; //表示添加失败
					msg = "添加失败，请确认信息！！";
				}

			} 
		}else {
			code = 2;
			msg = "请先选中您需要添加视频的课程！！";
		}
		result.put("code", code);
		result.put("msg", msg);
		result.put("data", data);
		//System.out.println("文件上传结束");
		return result.toString();
	}


	/**
	 * 根据文件名删除本地文件
	 * @param fileName  文件名
	 * @param uploadPath   文件所处的父文件夹
	 */
	private void removeLocalFile(String fileName,String uploadPath) {
		
		File file = new File(uploadPath+File.separator+fileName);
		if(file.exists()) { //如果问价存在就删除
			file.delete();
		}
		
		
	}

	/**
	 * 通过项目路径和上传的课程编号和课程名称构建一个不会重复的文件名
	 * @param courseid 
	 * @param coursename
	 * @return fileName  课程id_课程名称_uuid
	 */
	private String buildFileName(String courseid, String coursename) {
		
		String fileName = "";
		String uuid = UUID.randomUUID().toString();//随机生成码
		fileName = courseid +"_"+coursename+"_"+uuid;
		return fileName;
	}

	/**
	 * 
	 * @param file
	 * @param request
	 * @param url /课程id_课程名称/uuid
	 * @return
	 */
	private Map<String,String> upload(MultipartFile file, HttpServletRequest request,String UUIDFileName) {
		Map<String,String> result = new HashMap<>();
		//项目路径
		String basePath = request.getServletContext().getRealPath("/");
		
		Date date = new Date();
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String day = fmt.format(date);
		//生成文件需要上传的路径
		String fileUrlTemp = "upload"+File.separator+((Userinfo)request.getSession().getAttribute("crruentUser")).getUsertel()+File.separator+day;
		String uploadPath = basePath+File.separator+fileUrlTemp;
		
		File f = new File(uploadPath);
		if(!f.exists()){
			f.mkdirs();
		}
		
		String name = file.getOriginalFilename();
		//System.out.println("文件全名："+file.getName());
		//System.out.println("文件全名："+name);  //文件全名：068_Redis介绍.mp4
		
		//获取文件名
		String fileName = name.substring( name.lastIndexOf(File.separator) + 1);
		//System.out.println("fileName="+fileName); fileName=068_Redis介绍.mp4
		File upFile = new File(uploadPath+File.separator+UUIDFileName +"_"+ fileName);
		
		
		//上传
		try {
			file.transferTo(upFile);
			fileUrlTemp= "upload"+"/"+((Userinfo)request.getSession().getAttribute("crruentUser")).getUsertel()
					+"/"+day+ "/" + UUIDFileName + fileName; //构建一个可以通过浏览器访问的url视频地址
			result.put("fileUrlTemp", fileUrlTemp); //访问路径后半段 uploadPath+File.separator+UUIDFileName + fileName
			result.put("fileName", UUIDFileName + fileName);
			result.put("uploadPath", uploadPath);  //文件上传的本地文件夹
			result.put("msg", "成功");  //上传信息
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("msg", "失败");
		}
	
		return result;
	}
	
}
