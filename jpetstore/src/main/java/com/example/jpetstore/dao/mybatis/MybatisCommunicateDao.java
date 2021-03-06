package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpetstore.dao.CommunicateDao;
import com.example.jpetstore.dao.OrderDao;
import com.example.jpetstore.dao.SequenceDao;
import com.example.jpetstore.dao.mybatis.mapper.CommunicateMapper;
import com.example.jpetstore.dao.mybatis.mapper.LineItemMapper;
import com.example.jpetstore.dao.mybatis.mapper.OrderMapper;
import com.example.jpetstore.domain.Comment;
import com.example.jpetstore.domain.LineItem;
import com.example.jpetstore.domain.Message;
import com.example.jpetstore.domain.Order;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisCommunicateDao implements CommunicateDao {
	
	@Autowired
	protected CommunicateMapper communicateMapper;


	public void insertComment(Comment comment) throws DataAccessException {
		communicateMapper.insertComment(comment);
		
	}
	
	public void insertReComment(Comment comment) throws DataAccessException{
		communicateMapper.insertReComment(comment);
	}

	@Override
	public void deleteComment(@Param("commentId")int commentId, @Param("commentNum")int commentNum) throws DataAccessException {
		communicateMapper.deleteComment(commentId, commentNum);
		
	}

	@Override
	public void updateComment(Comment comment) throws DataAccessException {
		communicateMapper.updateComment(comment);
		
	}
	
	public Comment getComment(@Param("commentId")int commentId, @Param("commentNum")int commentNum, @Param("itemId")String itemId) throws DataAccessException{
		return communicateMapper.getComment(commentId, commentNum, itemId);
	}

	@Override
	public List<Comment> getCommentByItemId(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return communicateMapper.getCommentByItemId(itemId);
	}

	@Override
	@Transactional
	public void sendMessage(Message msg) throws DataAccessException {
		// TODO Auto-generated method stub
//    	msg.setOrderId(sequenceDao.getNextId("ordernum"));
    	communicateMapper.sendMessage(msg);
	}

	@Override
	public void deleteMessage(String messageId) throws DataAccessException {
		// TODO Auto-generated method stub
		communicateMapper.deleteMessage(messageId);
	}

	@Override
	public List<Message> getMessageList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return communicateMapper.getMessageList(userId);
	}

	@Override
	public List<Message> getMessageByUserId(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return communicateMapper.getMessageByUserId(userId);
	}

	@Override
	public List<Message> getSendMessageByUserId(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return communicateMapper.getSendMessageByUserId(userId);
	}

	@Override
	public Message readMessage(String messageId) throws DataAccessException {
		// TODO Auto-generated method stub
		return communicateMapper.readMessage(messageId);
	}

	@Override
	public void reSendMessage(String receiverId) throws DataAccessException {
		// TODO Auto-generated method stub
		communicateMapper.reSendMessage(receiverId);
	}
}