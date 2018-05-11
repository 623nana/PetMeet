package com.example.jpetstore.dao;

import org.springframework.dao.DataAccessException;

public interface CommunicateDao {
	
	void insertComment(ItemComment itemComment) throws DataAccessException;

	//코멘트는 답글이 달리지 않은 것에 한해서만 삭제가 가능하도록 한다.
	void deleteComment(String itemId, int commentId, int commentNum) throws DataAccessException;

	void updateComment(String itemId, int commentId, int commentNum) throws DataAccessException;
	
	List<ItemComment> getCommentByItemId(String itemId) throws DataAccessException;

	void sendMessage(Message msg) throws DataAccessException;
	
	String readMessage(Message msg) throws DataAccessException;
	
	void deleteMessage(Message msg) throws DataAccessException;
	
	List<Message> getMessageList(String userId)  throws DataAccessException;
	
}
