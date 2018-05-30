package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Comment;
import com.example.jpetstore.domain.Message;

public interface CommunicateMapper {
	
	
	   void insertComment(Comment itemComment) throws DataAccessException;

	   //�ڸ�Ʈ�� ����� �޸��� ���� �Ϳ� ���ؼ��� ������ �����ϵ��� �Ѵ�.
	   void deleteComment(String itemId, int commentId, int commentNum) throws DataAccessException;

	   void updateComment(String itemId, int commentId, int commentNum) throws DataAccessException;
	   
	   List<Comment> getCommentByItemId(String itemId) throws DataAccessException;

	   
	   
	   // ����
	   List<Message> getMessageList(String userId)  throws DataAccessException;
	   
	   List<Message> getMessageByUserId(String userId);
	
	   void sendMessage(Message msg) throws DataAccessException;
	   
	   String readMessage(Message msg) throws DataAccessException;
	   
	   void deleteMessage(Message msg) throws DataAccessException;
	
}
