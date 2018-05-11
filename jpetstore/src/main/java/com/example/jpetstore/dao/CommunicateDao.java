package com.example.jpetstore.dao;

import org.springframework.dao.DataAccessException;

public interface CommunicateDao {
	
	void insertComment(ItemComment itemComment) throws DataAccessException;

	//�ڸ�Ʈ�� ����� �޸��� ���� �Ϳ� ���ؼ��� ������ �����ϵ��� �Ѵ�.
	void deleteComment(String itemId, int commentId, int commentNum) throws DataAccessException;

	void updateComment(String itemId, int commentId, int commentNum) throws DataAccessException;
	
	List<ItemComment> getCommentByItemId(String itemId) throws DataAccessException;

	void sendMessage(Message msg) throws DataAccessException;
	
	String readMessage(Message msg) throws DataAccessException;
	
	void deleteMessage(Message msg) throws DataAccessException;
	
	List<Message> getMessageList(String userId)  throws DataAccessException;
	
}
