package com.example.jpetstore.domain;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("serial")
public class AuctionItem implements Serializable {
	
	private Item item;
	private String itemId;
	private int beginPrice;
	private int limitPrice;
	private int currentPrice;
	private int auctionStatus;
	private int auctionTime;
	private String time;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getBeginPrice() {
		return beginPrice;
	}
	public void setBeginPrice(int beginPrice) {
		this.beginPrice = beginPrice;
	}
	public int getLimitPrice() {
		return limitPrice;
	}
	public void setLimitPrice(int limitPrice) {
		this.limitPrice = limitPrice;
	}
	public int getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}
	public int getAuctionStatus() {
		return auctionStatus;
	}
	public void setAuctionStatus(int auctionStatus) {
		this.auctionStatus = auctionStatus;
	}
	public int getAuctionTime() {
		return auctionTime;
	}
	public void setAuctionTime(int auctionTime) {
		this.auctionTime = auctionTime;
	}


}
