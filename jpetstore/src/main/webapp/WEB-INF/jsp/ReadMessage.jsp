<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
      <div class="panel-heading"><B>받은 쪽지 자세히 보기</B></div>
      <div class="panel-body">
      	<table>
      		<tr>
      			<th>받는 사람</th>
      			<td><c:out value="${readMessage.receiverId}" /></td>
      		</tr>
      		<tr>
      			<th>보낸 사람</th>
      			<td><c:out value="${readMessage.senderId}" /></td>
      		</tr>
      		<tr>
      			<th>메세지 내용</th>
      			<td><c:out value="${readMessage.message}" /></td>
      		</tr>
      		<tr>
      			<td><br /><br /><input type="button" class="btn btn-primary btn-block" name="submit" value="쪽지 삭제하기" onclick="location.href='<c:url value="/shop/deleteMessage.do"/>'" />
      			</td>
      			<td><br /><br /><input type="button" class="btn btn-primary btn-block" name="submit" value="쪽지 답장하기" onclick="location.href='<c:url value="/shop/reSendMessage.do"><c:param name="receiverId" value="${readMessage.senderId}" /></c:url>'" />
      			</td>
      		</tr>
      		
    	
    	</table>
    	
      	</div>
      	
      </div>
    </div>
  </div>
</div> 
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>
