<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,  shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>

</head>
<body>
<%@include file="/WEB-INF/jsp/header.jsp" %>
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
      				<a href='<c:url value="/shop/readMessage.do">
      				<c:param name="message" value="${message.message}" /></c:url>'><c:out value="${message.message}" /></a>      			
      			</td>
      		</tr>
      		</c:forEach>
      	
      	</table>
      	<br /><br />
      	      <input type="button" class="btn btn-primary btn-block" name="send" value="쪽지 보내기" onclick="location.href='<c:url value="/shop/sendMessage.do"/>'" />
      
      		  <input type="button" class="btn btn-primary btn-block" name="send" value="받은 쪽지함" onclick="location.href='<c:url value="/shop/receiveMessageList.do"/>'" />	
      </div>
    </div>

      	</div>
      </div>
    </div>
  </div>
</div> 

<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>
