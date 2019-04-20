package com.hl.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hl.entity.Message;
import com.hl.entity.Userinfo;
import com.hl.service.MessageService;
import com.hl.util.ui.TableUtil;

import net.sf.json.JSONObject;

/**
 * 消息中心的控制层
 * @author hl
 *
 */
@Controller
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	

	/**
	 * 查询出当前用户接受的所有信息，进行表格渲染。
	 * @param page
	 * @param limit
	 * @param session
	 * @return
	 */
	@RequestMapping(value="list_all_receive_message.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String listAllReceiveMessage(String page, String limit, HttpSession session) {
		Userinfo receiveUser = (Userinfo) session.getAttribute("crruentUser");
		Map<String, Object> receiveMessage = messageService.getReceiveMessage(receiveUser, page, limit);
		String result = TableUtil.tableRander(Message.class, receiveMessage, "list");
		System.out.println(result);
		return result;
	}
	
	/**
	 * 显示message的详细内容
	 * @param messageid
	 * @return
	 */
	@RequestMapping(value="get_message_by_messageid.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String showMessageDetailByMessageid(String messageid) {
		JSONObject result = new JSONObject();
		Message message = messageService.getMessageByMessageid(messageid);
		result.put("message", message);
		return result.toString();
	}
	
	/**
	 * 判断当前用户是否有未读短信
	 * @return
	 */
	@RequestMapping(value="exist_not_readed_message.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String exsitNotReadedMessage(HttpSession session) {
		boolean exist = true;
		JSONObject result = new JSONObject();
		Userinfo userinfo = (Userinfo) session.getAttribute("crruentUser");
		exist = messageService.exsitNotReadedMessage(userinfo);
		result.put("exist", exist);
		return result.toString();
	}
	
	
	/**
	 * 给指定的用户发送消息
	 * @param userid
	 * @param mtitle
	 * @param msg
	 * @param session
	 * @return
	 */
	@RequestMapping(value="send_message.action",produces= {"text/html;charset=utf-8"})
	public @ResponseBody String sendMessage(String receiveid, String mtitle, String msg, HttpSession session) {
		JSONObject result = new JSONObject();
		Userinfo userinfo = (Userinfo) session.getAttribute("crruentUser");
		boolean isok  = messageService.sendMessage(userinfo, mtitle, msg,receiveid);
		result.put("isok", isok);
		return result.toString();
	}

}
