package com.example.jpetstore.dao;

import org.springframework.dao.DataAccessException;

public interface TicketDao {
		//������� �̿���� �����ϸ� Account�� myTicket�� ���� �����Ѵ�.
		void buyTicket(String userId, int amount) throws DataAccessException;

		//����Ǹű��� ����ϸ� Account�� myTicket�� ���� �����Ѵ�.
		void useTicket(String userId) throws DataAccessException;
}
