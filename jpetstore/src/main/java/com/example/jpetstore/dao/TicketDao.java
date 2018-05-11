package com.example.jpetstore.dao;

import org.springframework.dao.DataAccessException;

public interface TicketDao {
		//경매참여 이용권을 구매하면 Account의 myTicket의 값이 증가한다.
		void buyTicket(String userId, int amount) throws DataAccessException;

		//경매판매글을 등록하면 Account의 myTicket의 값이 감소한다.
		void useTicket(String userId) throws DataAccessException;
}
