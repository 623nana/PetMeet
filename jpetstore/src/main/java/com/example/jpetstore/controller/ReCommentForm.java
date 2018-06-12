package com.example.jpetstore.controller;

import java.io.Serializable;

import com.example.jpetstore.domain.Comment;

@SuppressWarnings("serial")
public class ReCommentForm implements Serializable {
	
	private Comment comment;
	
	private boolean newComment;
	
	public ReCommentForm(Comment comment) {
		this.comment = comment;
		this.newComment = false;
	}

	public ReCommentForm() {
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
