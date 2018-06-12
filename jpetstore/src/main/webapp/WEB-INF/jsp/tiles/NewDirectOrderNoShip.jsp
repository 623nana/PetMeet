<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
<div class="row">
  <div class="col-sm-3"></div>
  <div class="col-sm-7">
  	<br /><br />  	<br /><br />
  	<div class="panel panel-success">
      <div class="panel-heading"><B>직거래 주문이 완료되었습니다. </B></div> 
      <div class="panel-body">
     	판매자에게 직접 쪽지를 보내보세요.<br /><br />
     	
     	<a class="btn-btn-default" href='<c:url value="/shop/reSendMessage.do">
     	<c:param name="receiverId" value="${userId}" /></c:url>'>쪽지 보내기</a>
      	</div>
      	
      </div>
    </div>
  </div>
</div> 