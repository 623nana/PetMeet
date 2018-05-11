package com.example.jpetstore.service;

public interface TicketService {
	
	void buyTicket(String userId, int amount);
	void useTicket(String userId);
}
