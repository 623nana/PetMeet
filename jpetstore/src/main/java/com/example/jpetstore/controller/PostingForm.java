package com.example.jpetstore.controller;

import java.io.Serializable;

import com.example.jpetstore.domain.Item;

@SuppressWarnings("serial")
public class PostingForm implements Serializable {

	private Item item;
	
	private boolean newItem;
	
	public PostingForm(Item item) {
		this.item = item;
		this.newItem = false;
	}
	
	public PostingForm() {
		this.item = new Item();
		this.newItem = true;
	}
	
	public Item getItem() {
		return item;
	}
	
	public boolean isNewPosting() {
		return newItem;
	}
	
}
