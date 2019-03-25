package com.hl.service.impl;


import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.BaseTest;
import com.hl.entity.Message;
import com.hl.entity.Userinfo;
import com.hl.service.MessageService;

public class MessageServiceImplTest extends BaseTest{

	@Autowired
	private MessageService messageService;
	@Test
	public void testInsertMessage() {
		try {
			Message message = new Message();
			message.setMsg("测试消息");
			message.setMtitle("测试消息标题");
			message.setMtime(new Date(new java.util.Date().getTime()));
			message.setMtype("消息");
			Userinfo sendUser = new Userinfo();
			sendUser.setUserid(4);
			Userinfo receiveUser = new Userinfo();
			receiveUser.setUserid(6);
			message.setReceiveUser(receiveUser);
			message.setSendUser(sendUser);
			messageService.insertMessage(message);
			System.out.println(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetSendMessage() {
		
		try {
			Userinfo sendUser = new Userinfo();
			sendUser.setUserid(4);
			Map<String, Object> sendMessage = messageService.getSendMessage(sendUser, "1", "10");
			List<Message> msgs = (List<Message>) sendMessage.get("list");
			for (Message message : msgs) {
				//System.out.println(message);
				System.out.println(message.getReceiveUser().getUserid());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testGetReceiveMessage() {
	}
	
	@Test
	public void testGetMessageByMessageid() {
		Message messageByMessageid = messageService.getMessageByMessageid("1");
		System.out.println(messageByMessageid);
	}

}
