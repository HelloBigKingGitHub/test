package com.hl.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hl.entity.Message;
import com.hl.entity.Userinfo;
import com.hl.mapper.MessageMapper;
import com.hl.service.MessageService;

@Service 
public class MessageServiceImpl implements MessageService{

	@Autowired 
	private MessageMapper messageMapper;
	@Override
	public Message insertMessage(Message message) {
		int isok = messageMapper.insertMessage(message);
		if(isok > 0) {
			return message;
		}
		return null;
	}

	@Override
	public Map<String, Object> getSendMessage(Userinfo sendUser, String pageStr, String limitStr) {
		if(sendUser.getUserid()==null||pageStr==null||limitStr==null) {
			return null;
		}
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limitStr);
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Message> sendMessage = messageMapper.getMessageBySendUser(sendUser);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", sendMessage);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}

	@Override
	public Map<String, Object> getReceiveMessage(Userinfo receiveUser, String pageStr, String limitStr) {
		if(receiveUser.getUserid()==null||pageStr==null||limitStr==null) {
			return null;
		}
		Integer pageNum = Integer.parseInt(pageStr);
		Integer pageSize = Integer.parseInt(limitStr);
		Map<String,Object> result = new HashMap<>();
		Page<Object> page = PageHelper.startPage(pageNum, pageSize, true);
		List<Message> receiveMessage = messageMapper.getMessageByReceiveUser(receiveUser);
		int pages = page.getPages();
		long count = page.getTotal();
		result.put("list", receiveMessage);
		result.put("pages", pages);
		result.put("count", count);
		return result;
	}

	@Override
	public Message getMessageByMessageid(String messageid) {
		if(messageid==null||"".equals(messageid)) {
			return null;
		}
		Integer id = Integer.parseInt(messageid);
		if(updateMessageMstateByMessage(messageid)) {
			return messageMapper.getMessageByMessageid(id);
		}
		return null;
	}

	@Override
	public boolean updateMessageMstateByMessage(String messageid) {
		if(messageid==null||"".equals(messageid)) {
			return false;
		}
		Integer id = Integer.parseInt(messageid);
		return messageMapper.updateMessageMstate(id,1) > 0; //消息的状态具有不可逆转性，所有可以固定更改为 1 
	}

	
	
	@Override
	public boolean exsitNotReadedMessage(Userinfo userinfo) {
		return messageMapper.exsitNotReadedMessage(userinfo) > 0;
	}

	@Override
	public boolean sendMessage(Userinfo userinfo, String mtitle, String msg, String userid) {
		if(userid == null || "".equals(userid)) {
			return false;
		}
		Integer user = Integer.parseInt(userid);
		Userinfo receiveUser = new Userinfo();
		receiveUser.setUserid(user);
		Message message = new Message();
		message.setMsg(msg);
		message.setMtitle(mtitle);
		message.setMtype("通知");
		message.setReceiveUser(receiveUser);
		message.setSendUser(userinfo);
		message.setMtime(new Date(new java.util.Date().getTime()));
		return messageMapper.insertMessage(message) > 0;
			
	}

}
