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
<div class="container">
<div class="row">
  <div class="col-sm-3"></div>
  <div class="col-sm-7">
  	<br /><br />
  	<div class="panel panel-success">
      <div class="panel-heading"><B>답장 보내기</B></div>         <!-- 여기는 답장보낼 때 사용됨 -->
      <div class="panel-body">
      	<form:form commandName="reSendMessage" method="post" enctype="multipart/form-data">
      	<div class="form-group row">
      	</div>
      	<div class="form-group row">
      	<div class="col-sm-12">
      	<textarea class="form-control" rows="10" name="message.message" id="message.message" placeholder="내용을 입력하세요."></textarea>
      	<br />
      	<input type="submit" class="btn btn-primary btn-block" name="submit" value="전송하기" />    
      	</div>
    	</div>
    	</form:form>  

      	</div>
      	
      </div>
    </div>
  </div>
</div> 
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>