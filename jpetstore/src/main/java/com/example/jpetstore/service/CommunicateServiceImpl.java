package com.example.jpetstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpetstore.dao.CommunicateDao;

@Service("CommunicateServiceImpl")
public class CommunicateServiceImpl implements CommunicateService {
	
	@Autowired
	private CommunicateDao communicateDao;

	@Override
	public void insertComment(ItemComment itemComment) {
		// TODO Auto-generated method stub
		communicateDao.insertComment(itemComment);
	}

	@Override
	public void deleteComment(String itemId, int commentId, int commentNum) {
		// TODO Auto-generated method stub
		communicateDao.deleteComment(itemId, commentId, commentNum);
	}

	@Override
	public void updateComment(String itemId, int commentId, int commentNum) {
		// TODO Auto-generated method stub
		communicateDao.updateComment(itemId, commentId, commentNum);
	}

	@Override
	public List<ItemComment> getCommentByItemId(String itemId) {
		// TODO Auto-generated method stub
		return communicateDao.getCommentByItemId(itemId);
	}

	@Override
	public List<Message> getMessageByUserId(String userId) {
		// TODO Auto-generated method stub
		return communicateDao.getMessageList(userId);
	}

	@Override
	public String readMessage(Message msg) {
		// TODO Auto-generated method stub
		return communicateDao.readMessage(msg);
	}

	@Override
	public void sendMessage(Message msg) {
		// TODO Auto-generated method stub
		communicateDao.sendMessage(msg);
	}

	@Override
	public void deleteMessage(Message msg) {
		// TODO Auto-generated method stub
		communicateDao.deleteMessage(msg);
	}

}
