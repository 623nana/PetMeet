package com.example.jpetstore.domain;

import java.io.Serializable;


@SuppressWarnings("serial")
public class Ticket implements Serializable {

  /* Private Fields */

  private String username;
  private int buyTicketNum;
  private int buyTicketCost;
  
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getBuyTicketNum() {
	return buyTicketNum;
}
public void setBuyTicketNum(int buyTicketNum) {
	this.buyTicketNum = buyTicketNum;
}
public int getBuyTicketCost() {
	return buyTicketCost;
}
public void setBuyTicketCost(int buyTicketCost) {
	this.buyTicketCost = buyTicketCost;
}


}
