<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<br /><br />
<div class="container">
<div class="row">
  <div class="col-sm-3"></div>
  <div class="col-sm-7">
  	<br /><br />
  	<div class="panel panel-success">
      <div class="panel-heading"><h1><B>쪽지 보내기</B></h1></div>         <!-- 여기는 답장보낼 때 사용됨 -->
      <div class="panel-body">
      	<form:form commandName="reSendMessagetwo" method="post" enctype="multipart/form-data">
      	<form:errors cssClass="error" />
      	<div class="form-group row">
      	</div>
      	<div class="form-group row">
      	<div class="col-sm-12">
      	<textarea class="form-control" rows="10" name="message.message" id="message.message" placeholder="내용을 입력하세요."></textarea>
      	<form:errors path="message.message" cssClass="error" />
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