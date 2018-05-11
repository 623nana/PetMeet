package com.example.jpetstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpetstore.dao.TicketDao;

@Service("TicketServiceImpl")
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketDao ticketDao;

	@Override
	public void buyTicket(String userId, int amount) {
		// TODO Auto-generated method stub
		ticketDao.buyTicket(userId, amount);
	}

	@Override
	public void useTicket(String userId) {
		// TODO Auto-generated method stub
		ticketDao.useTicket(userId);
	}

}
