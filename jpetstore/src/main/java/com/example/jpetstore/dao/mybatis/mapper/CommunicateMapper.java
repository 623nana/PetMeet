package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Comment;
import com.example.jpetstore.domain.Message;

public interface CommunicateMapper {
	
	
	   void insertComment(Comment Comment) throws DataAccessException;
	   
	   void insertReComment(Comment comment) throws DataAccessException;

	   //�ڸ�Ʈ�� ����� �޸��� ���� �Ϳ� ���ؼ��� ������ �����ϵ��� �Ѵ�.
	   void deleteComment(String itemId, int commentId, int commentNum);

	   void updateComment(String itemId, int commentId, int commentNum) throws DataAccessException;
	   
	   List<Comment> getCommentByItemId(String itemId) throws DataAccessException;

	   
	   
	   // ����
	   List<Message> getMessageList(String userId)  throws DataAccessException;
	   
	   List<Message> getMessageByUserId(String userId);
	
	   void sendMessage(Message msg) throws DataAccessException;
	   
	   Message readMessage(String messageId) throws DataAccessException;
	   
	   void deleteMessage(String messageId) throws DataAccessException;
	   
	   List<Message> getSendMessageByUserId(String userId)  throws DataAccessException;
	   
	   void reSendMessage(String receiverId) throws DataAccessException;
	
}
