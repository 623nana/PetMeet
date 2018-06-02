package com.example.jpetstore.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Comment implements Serializable {
   
   private String comment;
   private String commenterName;
   private int commentId;
   private int commentNum;
   
   public String getComment() {
      return comment;
   }
   public void setComment(String comment) {
      this.comment = comment;
   }
   public String getCommenterName() {
      return commenterName;
   }
   public void setCommenterName(String commenterName) {
      this.commenterName = commenterName;
   }
   public int getCommentId() {
      return commentId;
   }
   public void setCommentId(int commentId) {
      this.commentId = commentId;
   }
   public int getCommentNum() {
      return commentNum;
   }
   public void setCommentNum(int commentNum) {
      this.commentNum = commentNum;
   }

}