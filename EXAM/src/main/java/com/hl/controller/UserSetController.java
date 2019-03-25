package com.hl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hl.entity.Userinfo;
import com.hl.formbean.UserSetBean;
import com.hl.service.UserDetailService;
import com.hl.service.UserService;

import net.sf.json.JSONObject;

/**
 * 关于用户进行自己信息设置的控制器
 * @author hl
 *
 */
@Controller
public class UserSetController {

	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private UserService userService;
	/**
	 * 用户设置自己的详细信息
	 * @return
	 */
	@RequestMapping(value="set_user_detail.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String userDetailSet(@RequestBody UserSetBean userSetBean, HttpSession session) {
		
		JSONObject result = new JSONObject();
		Userinfo currentUser = (Userinfo) session.getAttribute("crruentUser");
		String msg = "";
		boolean setok = userDetailService.setUserDetail(userSetBean,currentUser);
		if(setok) {
			msg = "信息设置成功";
		}else {
			msg = "信息设置失败";
		}
		result.put("msg", msg);
		return result.toString();
	}
	
	/**
	 * 上传自己的头像
	 * @param file
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="upload_user_icon.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String uploadUserIcon(MultipartFile file,HttpServletRequest request,HttpSession session) {
		
		JSONObject result = new JSONObject();
		int code = 0;
		String msg = "";
		Userinfo currentUser = (Userinfo) session.getAttribute("crruentUser");
		boolean isok = userDetailService.uploadUserIcon(file,request,currentUser);
		if(isok) {
			msg = "添加成功";
		}else {
			code = 1;
			msg = "添加失败";
		}
		result.put("code", code);
		result.put("msg", msg);
		
		return result.toString();
	}
	
	@RequestMapping(value="get_current_user_icon.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String getUserIcon(HttpSession session) {
		JSONObject result = new JSONObject();
		Userinfo currentUser = (Userinfo) session.getAttribute("crruentUser");
		String iconUrl = "";
		iconUrl = userDetailService.getUserIcon(currentUser);
		result.put("iconUrl", iconUrl);
		return result.toString();
		
	}
	
	@RequestMapping(value="reset_user_password.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String resetUserPassword(String nowpass, String pass, String repass,HttpSession session) { //{nowpass: "123456", pass: "654321", repass: "654321"}
		JSONObject result = new JSONObject();
		String msg = "";
	    System.out.println(pass+"======================"+repass);
		if(pass.trim().equals(repass.trim())) {
			Userinfo currentUser = (Userinfo) session.getAttribute("crruentUser");
			//System.out.println(currentUser);
			String resetPasswod = userService.resetUserPassword(nowpass,pass,currentUser);
			if(resetPasswod!=null&&!("".equals(resetPasswod))) {
				currentUser.setUserpwd(resetPasswod); //将新的user对象放到session域中
				session.setAttribute("crruentUser", currentUser);
				msg = "密码重置成功";
			}else {
				msg = "密码重置失败";
			}
		}else {
			msg = "请确认两次密码一致";
		}
		result.put("msg", msg);
		return result.toString();
	}
	
}
