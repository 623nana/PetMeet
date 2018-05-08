<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<!-- <div style="text-align:center;">
    <spring:hasBindErrors name="accountForm" />
    <form:errors path="accountForm" cssClass="error" />
</div>
 -->
 
  <div class="container">
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
    <input type="image" src="../images/button_submit.gif" name="submit"
      value="Save Account Information" />
</form:form>
</div></div>
<p></p>
  <h3><b><a href='<c:url value="/shop/listOrders.do"/>'>My Orders</a></b></h3>
  
</div>
  <!-- Bootstrap core JavaScript-->
  <script src="<c:url value="/vendor/jquery/jquery.min.js"/>"></script>
  <script src="<c:url value="/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>
  <!-- Core plugin JavaScript-->
  <script src="<c:url value="/vendor/jquery-easing/jquery.easing.min.js"/>"></script>
  <%@ include file="footer.jsp" %>
</body>
</html>