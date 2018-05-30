package com.example.jpetstore.dao.mybatis.mapper;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Comment;
import com.example.jpetstore.domain.Message;

public interface CommunicateMapper {
	
	
	   void insertComment(Comment itemComment) throws DataAccessException;

	   //코멘트는 답글이 달리지 않은 것에 한해서만 삭제가 가능하도록 한다.
	   void deleteComment(String itemId, int commentId, int commentNum) throws DataAccessException;

	   void updateComment(String itemId, int commentId, int commentNum) throws DataAccessException;
	   
	   List<Comment> getCommentByItemId(String itemId) throws DataAccessException;

	   
	   
	   // 쪽지
	   List<Message> getMessageList(String userId)  throws DataAccessException;
	   
	   List<Message> getMessageByUserId(String userId);
	
	   void sendMessage(Message msg) throws DataAccessException;
	   
	   String readMessage(Message msg) throws DataAccessException;
	   
	   void deleteMessage(Message msg) throws DataAccessException;
	
}
