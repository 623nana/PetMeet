<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br />
<br />
<br />
<br />
<div class="container">
<div class="row">
  <div class="col-sm-3"></div>
  <div class="col-sm-7">
  	<div class="panel panel-success">
      <div class="panel-heading"><h1><B>보낸 쪽지 자세히 보기</B></h1></div>
      <div class="panel-body">
      	<table class="table">
      		<tr>
      			<th>받는 사람</th>
      			<td><c:out value="${readMessagetwo.receiverId}" /></td>
      		</tr>
      		<tr>
      			<th>보낸 사람</th>
      			<td><c:out value="${readMessagetwo.senderId}" /></td>
      		</tr>
      		<tr>
      			<th>메세지 내용</th>
      			<td><c:out value="${readMessagetwo.message}" /></td>
      		</tr>
      		<tr>
      			<td><br /><br /><input type="button" class="btn btn-primary btn-block" name="submit" value="쪽지 삭제하기" onclick="location.href='<c:url value="/shop/deleteMessage.do"/>'" />
      			</td>
      			<td><br /><br /><input type="button" class="btn btn-primary btn-block" name="submit" value="쪽지 다시 보내기" onclick="location.href='<c:url value="/shop/reSendMessagetwo.do"><c:param name="senderId" value="${readMessagetwo.receiverId}" /></c:url>'" />
      			</td>
      		</tr>
      		
    	
    	</table>
    	
      	</div>
      	
      </div>
    </div>
  </div>
</div> 
