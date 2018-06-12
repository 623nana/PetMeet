<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <div class="panel-heading"><B>보낸 쪽지함</B></div>
      <div class="panel-body">
      	<table>
      		<tr>
      			<th width="50%">받은 사람</th>
      			<th width="50%">내용</th>
      		</tr>
      		<c:forEach var="message" items="${SendMessageList}" >
      		<tr>
      			<td>
      				<c:out value="${message.receiverId}" />
      			</td>
      			<td>
      				<a href='<c:url value="/shop/readMessagetwo.do">
      				<c:param name="messageId" value="${message.messageId}" /></c:url>'><c:out value="${message.message}" /></a>  
      			</td>
      		</tr>
      		</c:forEach>
      	
      	</table>
      	<br /><br />
      
      		  <input type="button" class="btn btn-primary btn-block" name="send" value="받은 쪽지함" onclick="location.href='<c:url value="/shop/receiveMessageList.do"/>'" />	
      </div>
    </div>

      	</div>
      </div>
    </div>
