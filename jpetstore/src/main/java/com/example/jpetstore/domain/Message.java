package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Message implements Serializable {

	private String message;
	private String userId;
	private String receiverId;
	private String senderId;
  
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
  



}
