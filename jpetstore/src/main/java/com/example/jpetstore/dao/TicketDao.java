package com.example.jpetstore.dao;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Ticket;

public interface TicketDao {
		//경매참여 이용권을 구매하면 Account의 myTicket의 값이 증가한다.
		void buyTicket(Ticket ticket) throws DataAccessException;

		//경매판매글을 등록하면 Account의 myTicket의 값이 감소한다.
		void useTicket(String userId) throws DataAccessException;

		Ticket getTicketByUsername(String username) throws DataAccessException;
		
		void insertBuyTicket(Ticket ticket) throws DataAccessException;
		
		void deleteBuyTicketByUsername(Ticket ticket) throws DataAccessException;
		
		int getMyTicketByUsername(String username) throws DataAccessException;
		
}
