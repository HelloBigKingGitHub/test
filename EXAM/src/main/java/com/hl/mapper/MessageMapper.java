package com.hl.mapper;

import java.util.List;

import com.hl.entity.Message;
import com.hl.entity.Userinfo;

/**
 * 操作message数据表的mapper层接口
 * @author hl
 *
 */
public interface MessageMapper {

	/**
	 * 添加消息记录
	 * @param message
	 * @return
	 */
	int insertMessage(Message message);
	
	/**
	 * 通过发送方得到所有消息值
	 * @param sendUser
	 * @return 
	 */
	List<Message> getMessageBySendUser(Userinfo sendUser);
	
	
	/**
	 * 通过接受方得到所有消息值
	 * @param receiveUser
	 * @return
	 */
	List<Message> getMessageByReceiveUser(Userinfo receiveUser);

	
	/**
	 * 根据id查询出消息
	 * @param id
	 * @return
	 */
	Message getMessageByMessageid(Integer id);

	/**
	 * 更改消息状态值
	 * @param id
	 * @param i
	 * @return
	 */
	int updateMessageMstate(Integer id, int i);

	/**
	 * 根据用户检索出所有未读短信
	 * @param userinfo
	 * @return 短信个数
	 */
	int exsitNotReadedMessage(Userinfo userinfo);
}
