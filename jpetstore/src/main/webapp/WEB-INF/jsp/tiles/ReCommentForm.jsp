<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <div class="container">
<div class="row">
  <div class="col-sm-3"></div>
  <div class="col-sm-9">
   
    
<br />
<br />

<form:form commandName="reCommentForm" method="post" >
<table class="table table-bordered">
	<tr bgcolor="#0ba360">
		<td>
			<font color="ffffff"><i class="fa fa-share" ></i><b> 답글 등록</b></font>		
		</td>
	</tr>
	<tr>
		<td>

			<form:hidden path="comment.commentId" value="${commentId }" />
			<textarea class="form-control" rows="10" name="comment.itemComment" id="comment.itemComment" placeholder="답글을 입력하세요."></textarea>
			<form:hidden path="comment.itemId" value="${item.itemId }" />
			<form:hidden path="comment.newComment" value="false" />
		</td>
	</tr>
	<tr align="right">
		<td>

			<input type="submit" class="btn btn-success" name="submit" value="등록">

			<input type="reset" class="btn btn-success" name="reset" value="취소" />

		</td>
	</tr>
</table>
</form:form>
</div>
</div>
</div>
