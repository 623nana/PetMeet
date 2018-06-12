package com.example.jpetstore.controller;

import java.io.Serializable;

import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.Item;

@SuppressWarnings("serial")
public class PostingAuction implements Serializable {

	private AuctionItem auctionItem;
	
	
	private boolean newItem;
	
	public PostingAuction(AuctionItem auctionItem) {
		this.auctionItem = auctionItem;
		this.newItem = false;
	}
	
	public PostingAuction() {
		this.auctionItem = new AuctionItem();
		this.newItem = true;
	}
	
	public AuctionItem getAuctionItem() {
		return auctionItem;
	}
	
	public boolean isNewPosting() {
		return newItem;
	}
	
}