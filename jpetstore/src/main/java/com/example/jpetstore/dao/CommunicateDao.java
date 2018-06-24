package com.example.jpetstore.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Comment;
import com.example.jpetstore.domain.Message;

public interface CommunicateDao {
	   
	   void insertComment(Comment comment) throws DataAccessException;
	   
	   void insertReComment(Comment comment) throws DataAccessException;

	   //�ڸ�Ʈ�� ����� �޸��� ���� �Ϳ� ���ؼ��� ������ �����ϵ��� �Ѵ�.
	   void deleteComment(@Param("commentId")int commentId, @Param("commentNum")int commentNum) throws DataAccessException;

	   void updateComment(Comment comment) throws DataAccessException;
	   
	   Comment getComment(@Param("commentId")int commentId, @Param("commentNum")int commentNum, @Param("itemId")String itemId) throws DataAccessException;
	   
	   List<Comment> getCommentByItemId(String itemId) throws DataAccessException;

	   void sendMessage(Message msg) throws DataAccessException;
	   
	   Message readMessage(String messageId) throws DataAccessException;
	   
	   void deleteMessage(String messageId) throws DataAccessException;
	   
	   List<Message> getMessageList(String userId)  throws DataAccessException;
	   
	   List<Message> getMessageByUserId(String userId)  throws DataAccessException;
	   
	   List<Message> getSendMessageByUserId(String userId)  throws DataAccessException;
	   
	   void reSendMessage(String receiverId) throws DataAccessException;
	}