package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BiddingInfo implements Serializable {
	
	private AuctionItem auctionItem;
	private int expectPrice;
	private String itemId;
	private String username;
	private String biddingTime;
	private int maxExpectPrice;

	
	public AuctionItem getAuctionItem() {
		return auctionItem;
	}
	public void setAuctionItem(AuctionItem auctionItem) {
		this.auctionItem = auctionItem;
	}
	public int getMaxExpectPrice() {
		return maxExpectPrice;
	}
	public void setMaxExpectPrice(int maxExpectPrice) {
		this.maxExpectPrice = maxExpectPrice;
	}
	
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
