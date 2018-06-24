package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BiddingInfo implements Serializable {
	
	private int expectPrice;
	private String itemId;
	private String username;
	private String biddingTime;
	
	public int getExpectPrice() {
		return expectPrice;
	}
	public void setExpectPrice(int expectPrice) {
		this.expectPrice = expectPrice;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBiddingTime() {
		return biddingTime;
	}
	public void setBiddingTime(String biddingTime) {
		this.biddingTime = biddingTime;
	}
	

}
