<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br />
<br />
<div class="container">
<div class="row">
  <div class="col-sm-3"></div>
  <div class="col-sm-7">
  	<div class="panel panel-success">
  		<br /><br /><br />
      <div class="panel-heading"><h1><B>쪽지함</B></h1></div>
      <br />
      
      <input type="button" class="btn btn-primary btn-block" name="send" value="쪽지 보내기" onclick="location.href='<c:url value="/shop/sendMessage.do"/>'" />
      
      <input type="button" class="btn btn-primary btn-block" name="send" value="받은 쪽지함" onclick="location.href='<c:url value="/shop/receiveMessageList.do"/>'" />
      
      <input type="button" class="btn btn-primary btn-block" name="send" value="보낸 쪽지함" onclick="location.href='<c:url value="/shop/sendMessageList.do"/>'" />
      
      <div class="panel-body">
      	
      </div>
    </div>

      	</div>
      </div>
    </div>
