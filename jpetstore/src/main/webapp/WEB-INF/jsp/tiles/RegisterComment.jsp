<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br />
<br />
<div class="container">
<div class="row">
  <div class="col-sm-3"></div>
  <div class="col-sm-7">
  	<div class="panel panel-success">
  		<br /><br /><br />
      <div class="panel-heading"><B>Comment</B></div>
      <div class="panel-body">
      	<form:form commandName="registerComment" method="post" enctype="multipart/form-data">
      	
      	<div class="form-group row">
      		<label for="commentId" class="col-sm-2 col-form-label">id</label>
      		<div class="col-sm-6">
      			<form:input type="text" id="commentId" name="commentId" cssClass="form-control" path="commentId" />
      		</div>
      		<label for="commentNum" class="col-sm-2 col-form-label">num</label>
      		<div class="col-sm-6">
      			<form:input type="text" id="commentNum" name="commentNum" cssClass="form-control" path="comment.commentNum" />
      		</div>
      	</div>    	
      	
      	<div class="form-group row">
      	<div class="col-sm-12">
      	<textarea class="form-control" rows="10" name="comment.comment" id="comment.comment" placeholder="내용을 입력하세요."></textarea>
      	<br />   
      	
      	<div>
			<input type="submit" class="btn btn-primary btn-block" name="submit" value="확인" />
			<input type="reset" class="btn btn-primary btn-block" name="reset" value="취소" />
         </div>
      	
      	</div>
    	</div>
    	</form:form>  

      	</div>
      	
      </div>
    </div>
  </div>
</div> 
