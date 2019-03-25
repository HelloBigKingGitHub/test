package com.hl.util.file;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.hl.entity.Userinfo;

/**
 * 文件上传工具类
 * @author hl
 *
 */
public class FileUploadUtil {
	
	/**
	 * 删除服务器本地文件
	 * @param fileName 文件名
	 * @param uploadPath 文件父目录的路劲
	 * @return
	 */
	public static boolean removeLocalFile(String fileName,String uploadPath) {
		
		File file = new File(uploadPath+File.separator+fileName);
		if(file.exists()) { //如果问价存在就删除
			return file.delete();
		}
		return false;
	}
	
	/**
	 * 根据参数构建出不会同名的文件名
	 * @param strings
	 * @return
	 */
	public static String buildUUIDFileName(String ...strings) {
		String fileName = "";
		String uuid = UUID.randomUUID().toString();//随机生成码
		for (String string : strings) {
			fileName = fileName+string+"_";
		}
		return fileName + uuid;
	}
	

	/**
	 * 上传文件
	 * @param file  文件对象
	 * @param request 请求对象
	 * @param url /课程id_课程名称/uuid
	 * @return
	 */
	public static Map<String,String> upload(MultipartFile file, HttpServletRequest request,String UUIDFileName) {
		//返回结果集合，返回三个值，文件名，文件可供浏览器访问的url，文件上传的到本地的文件路劲
		Map<String,String> result = new HashMap<>();
		//项目路径
		String basePath = System.getProperty("catalina.home") + File.separator +"webapps";
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
		//获取文件名
		String fileName = name.substring( name.lastIndexOf(File.separator) + 1);
		File upFile = new File(uploadPath+File.separator+UUIDFileName +"_"+ fileName);
		//上传
		try {
			file.transferTo(upFile);
			fileUrlTemp= "upload"+"/"+((Userinfo)request.getSession().getAttribute("crruentUser")).getUsertel()
					+"/"+day+ "/" + UUIDFileName +"_"+fileName; //构建一个可以通过浏览器访问的url视频地址
			result.put("fileUrlTemp", fileUrlTemp); //访问路径后半段 uploadPath+File.separator+UUIDFileName + fileName
			result.put("fileName", UUIDFileName +"_"+ fileName); //不会重复的文件名
			result.put("uploadPath", uploadPath);  //文件上传的本地文件夹
			result.put("msg", "成功");  //上传信息
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("msg", "失败");
		}
	
		return result;
	}

	/**
	 * 根据数据库中icon字段删除本地文件
	 * @param icon
	 */
	public static boolean removeLocalFile(String icon) {
		String basePath = System.getProperty("catalina.home") +File.separator+"webapps";
		String fileUrlTemp = icon.replaceAll("//",File.separator);  // 必须使用 //用来转义
		String uploadPath = basePath+File.separator+fileUrlTemp;
		File file = new File(uploadPath);
		if(file.exists()) { //如果问价存在就删除
			return file.delete();
		}
		return false;
	}

}
