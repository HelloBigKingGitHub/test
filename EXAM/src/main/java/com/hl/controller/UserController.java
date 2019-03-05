package com.hl.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.Userinfo;
import com.hl.formbean.LoginFormBean;
import com.hl.formbean.RegFormBean;
import com.hl.service.UserService;
import com.hl.util.imgcode.CodeUtil;
import com.hl.util.sms.IndustrySMS;

import net.sf.json.JSONObject;

@Controller
/**
 * 处理用户登录注册的控制器
 * @author hl
 *
 */
public class UserController {
	//图片验证码的字符串
	private StringBuffer codeStr; 
	//手机验证随机码
	private String randomCode;
	@Autowired
	private UserService userServiceImpl;
	
	private static MessageDigest md5 ; 
	//获取MD5 加密算法
	static {
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("ListUser.action")
	public String ListUser(Model model) {
		List<Userinfo> list = new ArrayList<Userinfo>();
		list = userServiceImpl.listUserinfo();
		model.addAttribute("Userinfos", list);
		System.out.println("项目建立成功");
		return "/jsp/user/ListUser.jsp";
		
	}
	@RequestMapping("ListPageUser.action")
	public String listPageUser(Model model,String pageNumStr,String pageSizeStr) {
		int pageNum = (pageNumStr==null)?1:Integer.parseInt(pageNumStr);
		int pageSize = (pageSizeStr==null)?2:Integer.parseInt(pageSizeStr);
		Map map = userServiceImpl.listPageUserinfo(pageNum, pageSize);
		model.addAttribute("Userinfos", map.get("list"));
		//System.out.println((Long)map.get("count")/pageSize);
		//System.out.println(Math.ceil((Long)map.get("count")/pageSize));
		model.addAttribute("count", ((Long)map.get("count")%pageSize>0)?(Long)map.get("count")/pageSize+1:(Long)map.get("count")/pageSize);
		return "/jsp/user/user_list_page.jsp";
	}
	
	/**
	 * 局部跟新分页查询用户信息中的表格信息
	 * @return
	 */
	@RequestMapping("ListPageUserUpdata.action")
	public String listPageUserUpdata(Model model,String pageNumStr,String pageSizeStr) {
		listPageUser(model, pageNumStr, pageSizeStr);
		return "/jsp/user/user_list_page_table.jsp";
	}
	/**
	 *  处理图片验证码的映射
	 * @param model
	 * @param httpServletRequest
	 * @param httpServletResponse
	 */
	@RequestMapping("user_code.action")
	public void code(Model model,HttpServletRequest httpServletRequest,
		       HttpServletResponse httpServletResponse) {
		try {
			//获得一个数组输出流
			ByteArrayOutputStream  out = new ByteArrayOutputStream();
			//通过util中的方法后的图片流
			Map<String,Object> map = CodeUtil.generateCodeAndPic();
			BufferedImage buffImg = (BufferedImage) map.get("codePic");
			//获得图片的验证码字符串
			codeStr = (StringBuffer) map.get("code");
			//将图片资源写入到输出流中
			ImageIO.write(buffImg, "jpeg", out);
			// img为图片的二进制流
			byte[] img = out.toByteArray();
			httpServletResponse.setContentType("image/png");
			OutputStream os = httpServletResponse.getOutputStream();
			os.write(img);
			os.flush();
			os.close();
			System.out.println(codeStr);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 处理手机验证码的映射
	 * @param phoneNumber 手机号码
	 */
	@RequestMapping("user_phoneCode.action")
	public void phoneCode(String phoneNumber) {
		//1.获取随机验证码
		randomCode = IndustrySMS.RandomCode();
		//2.调用自定义util包中的api发送验证码到指定的手机上
		IndustrySMS.execute(phoneNumber, randomCode);
	}
	
	@RequestMapping(value="reg.action",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody String userReg(@RequestBody RegFormBean regForm ) {
		System.out.println(regForm);
		Userinfo userinfo = new Userinfo();
		//对传输进来的手机验证码进行判断，不为空，不为空串，并且与随机码相同就进行下一步的业务
		if(regForm.getPhoneCode()!=null&&(!"".equals(regForm.getPhoneCode()))&&regForm.getPhoneCode().equals(randomCode)){
			//进行表单bean与实体bean间的属性拷贝
			userinfo.setUsertel(regForm.getUsertel());
			//密码需要进行md5加密
			try {
				userinfo.setUserpwd(Base64.encodeBase64String(md5.digest(regForm.getUserpwd().getBytes("utf-8"))));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//调用service层进行注册操作
			boolean isok = userServiceImpl.userRegister(userinfo);
			if(isok) {
				return "1";//表示注册成功
			}
			return "0";//表示注册失败
		}
		
		return "-1";//表示手机验证码不合格
	}

	/**
	 * 用户登录的控制逻辑
	 * @param regForm
	 * @return
	 */
	@RequestMapping(value="login.action",method={RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody String userLogin(@RequestBody LoginFormBean loginForm,HttpSession session ) {
		System.out.println(loginForm);
		Userinfo userinfo = new Userinfo();
		//首先判断输入的图片验证码信息是否正确 返回-1表示验证码错误
		if(!codeStr.toString().equals(loginForm.getImgCode())) {
			return "-1";
		}else {
			//将formbean中的信息拷贝到userinfo
			userinfo.setUsertel(loginForm.getUsertel());
			//加密码进行MD5加密
			try {
				userinfo.setUserpwd(Base64.encodeBase64String(md5.digest(loginForm.getUserpwd().getBytes("utf-8"))));
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			}
		
			//调用service中的方法进行登录操作
			Userinfo usertemp = userServiceImpl.userLogin(userinfo);
			if(usertemp==null) {//先判断用户是否已经存在
				return "1"; //用户不存在返回状态码 1
			}else {
				if(0==usertemp.getUserstate()) {//判断用户是否被禁用
					return "2";//用户被禁用返回状态码2
					
				}else {
					if(userinfo.getUserpwd().equals(usertemp.getUserpwd())) {//判断密码是否正确
						session.setAttribute("crruentUser", usertemp);//登录后往session中存入当前用户对象以便后续的操作
						return "0";//密码正确返回状态码0表示登录成功
					}
					return "3";//状态码3表示密码不正确
				}
				
			}
			
		}
		
		
	}
	
	@RequestMapping("logout.action")
	public String logout(HttpSession session) { //判断下当前用户是否存在
		if(session.getAttribute("crruentUser")!=null) {
			session.removeAttribute("crruentUser");	
		}
		return "/EXAM/log_reg.jsp";
	}
	
	/**
	 * 获取当前用户对象
	 * @return json字符串
	 */
	@RequestMapping(value="get_crruent_user.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String getCrruentUser(HttpSession session) {
		Userinfo crruentUser = (Userinfo) session.getAttribute("crruentUser");
		JSONObject result = new JSONObject();
		result.put("crruentUser", crruentUser);
		return result.toString();
	}
	
	//md5测试加密有效
	public static void main(String[] args) {
		String str = "123456";
		try {
		        //加密后的字符串
		     String newstr = Base64.encodeBase64String(md5.digest(str.getBytes("utf-8")));
		     System.out.println(newstr);
		       
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
