package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Comment;
import com.example.jpetstore.domain.Message;

public interface CommunicateMapper {
	
	
	   void insertComment(Comment Comment) throws DataAccessException;
	   
	   void insertReComment(Comment comment) throws DataAccessException;

	   //코멘트는 답글이 달리지 않은 것에 한해서만 삭제가 가능하도록 한다.
	   void deleteComment(String itemId, int commentId, int commentNum);

	   void updateComment(String itemId, int commentId, int commentNum) throws DataAccessException;
	   
	   List<Comment> getCommentByItemId(String itemId) throws DataAccessException;

	   
	   
	   // 쪽지
	   List<Message> getMessageList(String userId)  throws DataAccessException;
	   
	   List<Message> getMessageByUserId(String userId);
	
	   void sendMessage(Message msg) throws DataAccessException;
	   
	   Message readMessage(String messageId) throws DataAccessException;
	   
	   void deleteMessage(String messageId) throws DataAccessException;
	   
	   List<Message> getSendMessageByUserId(String userId)  throws DataAccessException;
	   
	   void reSendMessage(String receiverId) throws DataAccessException;
	
}
