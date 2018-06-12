package com.example.jpetstore.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.example.jpetstore.dao.TicketDao;
import com.example.jpetstore.dao.mybatis.mapper.TicketMapper;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Ticket;

@Repository
public class MybatisTicketDao implements TicketDao {
	@Autowired
	private TicketMapper ticketMapper;
	
	//������� �̿���� �����ϸ� Account�� myTicket�� ���� �����Ѵ�.
	public void buyTicket(Ticket ticket) throws DataAccessException{
		ticketMapper.buyTicket(ticket);		
	}

	//����Ǹű��� ����ϸ� Account�� myTicket�� ���� �����Ѵ�.
	public void useTicket(String userId) throws DataAccessException{
		ticketMapper.useTicket(userId);
	}

	@Override
	public Ticket getTicketByUsername(String username) throws DataAccessException {
		return ticketMapper.getTicketByUsername(username);
	}

	@Override
	public void insertBuyTicket(Ticket ticket) throws DataAccessException {
		ticketMapper.insertBuyTicket(ticket);
	}

	@Override
	public void deleteBuyTicketByUsername(Ticket ticket) throws DataAccessException {
		ticketMapper.deleteBuyTicketByUsername(ticket);
	}

	@Override
	public int getMyTicketByUsername(String username) throws DataAccessException {
		return ticketMapper.getMyTicketByUsername(username);
	}

	

}
