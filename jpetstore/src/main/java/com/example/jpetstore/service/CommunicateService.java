package com.example.jpetstore.service;
import java.util.List;

import com.example.jpetstore.domain.ItemComment;
import com.example.jpetstore.domain.Message;


public interface CommunicateService {

	void insertComment(ItemComment itemComment);
	void deleteComment(String itemId, int commentId, int commentNum);
	void updateComment(String itemId, int commentId, int commentNum);
	List<ItemComment> getCommentByItemId(String itemId);
	
	List<Message> getMessageByUserId(String userId);
	String readMessage(Message msg);
	void sendMessage(Message msg);
	void deleteMessage(Message msg);	
}
