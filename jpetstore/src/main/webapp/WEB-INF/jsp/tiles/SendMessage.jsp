<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br />
<br />
<br />
<br />
<div class="container">
<div class="row">
  <div class="col-sm-3"></div>
  <div class="col-sm-7">
  	<div class="panel panel-success">
      <div class="panel-heading"><h1><B>쪽지 보내기</B></h1></div>         <!-- 여기는 처음 쪽지 보낼 때 사용됨 -->
      <div class="panel-body">
      	<form:form commandName="sendMessage" method="post" enctype="multipart/form-data">
      	<form:errors cssClass="error" />
      	<div class="form-group row">
      		<label for="receiver" class="col-sm-2 col-form-label">받는 사람:</label>
      		<div class="col-sm-6">
      			<form:input type="text" id="receiverId" name="receiver" cssClass="form-control" path="message.receiverId"  placeholder="받는 사람 id를 입력하세요." />
      			<form:errors path="message.receiverId" cssClass="error" />  
      		</div>
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
