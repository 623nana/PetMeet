package com.example.jpetstore.dao.mybatis;

import java.util.List;

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


	@Override
	public void insertComment(Comment itemComment) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(String itemId, int commentId, int commentNum) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateComment(String itemId, int commentId, int commentNum) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> getCommentByItemId(String itemId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void sendMessage(Message msg) throws DataAccessException {
		// TODO Auto-generated method stub
//    	msg.setOrderId(sequenceDao.getNextId("ordernum"));
    	communicateMapper.sendMessage(msg);
	}

	@Override
	public String readMessage(Message msg) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMessage(Message msg) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Message> getMessageList(String userId) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
}