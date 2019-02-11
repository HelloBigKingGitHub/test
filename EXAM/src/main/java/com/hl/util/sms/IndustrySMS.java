package com.hl.util.sms;

import java.net.URLEncoder;
import java.util.Random;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	//请求地址
	private static String operation = "/industrySMS/sendSMS";
    //获取注册秒滴用户的加密id
	private static String accountSid = Config.ACCOUNT_SID;
	//需要发送短信的目的手机号
	//private static String to = "18573244627";
	//短信验证内容
	//private static String smsContent = "【一考通】您的验证码为345678，请于30分钟内正确输入，如非本人操作，请忽略此短信。";
	/**
	 * 验证码通知短信
	 */
	public static void execute(String to,String randomCode)
	{
		
		String smsContent = "【一考通】您的验证码为"+randomCode+"，请于30分钟内正确输入，如非本人操作，请忽略此短信。";
		String tmpSmsContent = null;
		try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
	
	/**
	 * 静态生成随机验证码的函数
	 * @return 六位随机数字的字符串
	 */
	public static String RandomCode() {
		String[] base = {"0","1","2","3","4","5","6","7","8","9"};
		StringBuilder randomCode = new StringBuilder();
		for(int i = 0;i<6;i++) {
			randomCode = randomCode.append(base[new Random().nextInt(10)]);
		}
		System.out.println(randomCode);
		return randomCode.toString();
	}
}
