package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpetstore.dao.OrderDao;
import com.example.jpetstore.dao.SequenceDao;
import com.example.jpetstore.dao.mybatis.mapper.LineItemMapper;
import com.example.jpetstore.dao.mybatis.mapper.OrderMapper;
import com.example.jpetstore.domain.LineItem;
import com.example.jpetstore.domain.Order;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisOrderDao implements OrderDao {
	
	@Autowired
	protected OrderMapper orderMapper;
	@Autowired
	protected LineItemMapper lineItemMapper;
	@Autowired
	private SequenceDao sequenceDao;

	public List<Order> getOrdersByUsername(String username) 
			throws DataAccessException {
	    return orderMapper.getOrdersByUsername(username);
	}
	
	@Transactional
	public Order getOrder(int orderId) throws DataAccessException {
		Order order = orderMapper.getOrder(orderId);
		if (order != null) {
			order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));
		}
	    return order;
	}
	
	@Transactional(rollbackFor={MyException.class})		
	public void insertOrder(Order order) throws DataAccessException, MyException {  
    	//order.setOrderId(sequenceDao.getNextId("ordernum"));
    	orderMapper.insertOrder(order);
    	orderMapper.insertOrderStatus(order);
    	
    	if (order.getLineItems().size() >= 3) 
    		throw new MyException("Too many items!");
    	
    	for (int i = 0; i < order.getLineItems().size(); i++) {
    		LineItem lineItem = (LineItem) order.getLineItems().get(i);
    		lineItem.setOrderId(order.getOrderId());
    		lineItemMapper.insertLineItem(lineItem);
    	}
	}
}