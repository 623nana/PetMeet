package com.example.jpetstore.dao;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Ticket;

public interface TicketDao {
		//������� �̿���� �����ϸ� Account�� myTicket�� ���� �����Ѵ�.
		void buyTicket(Ticket ticket) throws DataAccessException;

		//����Ǹű��� ����ϸ� Account�� myTicket�� ���� �����Ѵ�.
		void useTicket(String userId) throws DataAccessException;

		Ticket getTicketByUsername(String username) throws DataAccessException;
		
		void insertBuyTicket(Ticket ticket) throws DataAccessException;
		
		void deleteBuyTicketByUsername(Ticket ticket) throws DataAccessException;
		
		int getMyTicketByUsername(String username) throws DataAccessException;
		
}
