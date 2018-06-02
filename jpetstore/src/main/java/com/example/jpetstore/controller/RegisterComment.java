package com.example.jpetstore.controller;

import com.example.jpetstore.domain.Comment;

public class RegisterComment {
	
	private Comment comment;
	private boolean newComment;
	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public boolean isNewComment() {
		return newComment;
	}

	public void setNewComment(boolean newComment) {
		this.newComment = newComment;
	}

	public RegisterComment(Comment comment) {
		this.comment = comment;
		this.newComment = false;
	}
	
	public RegisterComment() {
		this.comment = new Comment();
		this.newComment = true;
	}

}
