package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HotItem implements Serializable {
	
	private String itemId;
	private int bidder;

	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getBidder() {
		return bidder;
	}
	public void setBidder(int bidder) {
		this.bidder = bidder;
	}
	
	

}
