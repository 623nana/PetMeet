package com.example.jpetstore.controller;

import java.io.Serializable;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Message;

@SuppressWarnings("serial")
public class ReadMessage implements Serializable {

	private Message message;
	private boolean newMessage;
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public boolean isNewMessage() {
		return newMessage;
	}

	public void setNewMessage(boolean newMessage) {
		this.newMessage = newMessage;
	}

	

	
	public ReadMessage(Message msg) {
		this.message = msg;
		this.newMessage = false;
	}
	
	public ReadMessage() {
		this.message = new Message();
		this.newMessage = true;
	}

	

	
}
