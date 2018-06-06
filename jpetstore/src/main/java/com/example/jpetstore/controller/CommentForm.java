package com.example.jpetstore.controller;

import java.io.Serializable;

import com.example.jpetstore.domain.Comment;

@SuppressWarnings("serial")
public class CommentForm implements Serializable {
	
	private Comment comment;
	
	private boolean newComment;
	
	public CommentForm(Comment comment) {
		this.comment = comment;
		this.newComment = false;
	}

	public CommentForm() {
		super();
		this.comment = new Comment();
	}




	public Comment getComment() {
		return comment;
	}
	
	public boolean isNewComment() {
		return newComment;
	}
	

}
