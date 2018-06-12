package com.example.jpetstore.controller;

import java.io.Serializable;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Ticket;

@SuppressWarnings("serial")
public class BuyTicketForm implements Serializable {

	private Account account;
	private Ticket ticket;
	
	public Account getAccount() {
		return account;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	
	public BuyTicketForm() {
		this.account = new Account();
		this.ticket = new Ticket();
	}
	
	public BuyTicketForm(Account account, Ticket ticket) {
		this.account = account;
		this.ticket = ticket;
	}
}
