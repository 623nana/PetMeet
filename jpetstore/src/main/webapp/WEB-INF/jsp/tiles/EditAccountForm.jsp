<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br />
<br />
<br />
<div class="container">
  <div class="row">
    <div class="card card-register mx-auto mt-3"> 
      <div class="card-header">Register an Account</div>
      <div class="card-body" >
		<form:form commandName="accountForm" method="post">
		<form:errors cssClass="error" />
        
        <div class="form-group row">
        	<form:label path="account.username" cssClass="col-sm-3 col-form-label">USER ID</form:label>
    		<div class="col-sm-6">
      			<c:if test="${accountForm.newAccount}">
              <form:input path="account.username" cssClass="form-control" placeholder="아이디를 입력하세요."/>
              <B><form:errors path="account.username" cssClass="error" /></B>
            </c:if> 
            <c:if test="${!accountForm.newAccount}">
              <c:out value="${accountForm.account.username}" />
            </c:if>
    		</div>
  		</div>
  		 <div class="form-group row">
  		 <form:label path="account.password" cssClass="col-sm-3 col-form-label">Password</form:label>
    	<div class="col-sm-6">
    	<form:password path="account.password" cssClass="form-control"/> 
              <B><form:errors path="account.password" cssClass="error" /></B>
    	</div>
  		</div>
  		
  		 <div class="form-group row">
  		 <form:label path="repeatedPassword" cssClass="col-sm-3 col-form-label">Confirm Password</form:label>
    	<div class="col-sm-6">
    	<form:password path="repeatedPassword" cssClass="form-control"/> 
              <B><form:errors path="repeatedPassword" cssClass="error" /></B>
    	</div>
  		</div>
        <%@ include file="IncludeAccountFields.jsp"%>

<input type="submit" class="btn btn-primary btn-block" name="submit" value="Register" />


  <br />
</form:form>
</div></div>
</div>
<p></p>
<div class="row">
<div class="col-sm-5"></div>
<div class="form-row">
<div class="col-md-5">
<a href='<c:url value="/shop/listOrders.do"/>' class="btn btn-primary btn-block">My Orders</a></div>
<div class="col-md-6">
<a href="#" class="btn btn-primary btn-block">경매 참여 내역　</a></div>
 </div> 
 </div>
 <p />
</div>
<br />
<br />
<br />