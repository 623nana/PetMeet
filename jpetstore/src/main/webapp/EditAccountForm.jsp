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
 <%@ include file="WEB-INF/jsp/header.jsp" %>

  <div class="container">
    <div class="card card-register mx-auto mt-3"> 
      <div class="card-header">Register an Account</div>
      <div class="card-body" >
		<form:form commandName="accountForm" method="post">
		<form:errors cssClass="error" />

        <div class="form-group row">
    		<label for="inputEmail3" class="col-sm-2 col-form-label">USER ID</label>
    		<div class="col-sm-6">
      			<input type="text" class="form-control" name="username" id="username" placeholder="USER ID">
    		</div>
  		</div>
  		<div class="form-group row">
    	<label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
    	<div class="col-sm-6">
     	 <input type="password" class="form-control" id="password" name="password" placeholder="Password">
    	</div>
  		</div>
  		<div class="form-group row">
    	<label for="inputPassword3" class="col-sm-2 col-form-label">Confirm Password</label>
    	<div class="col-sm-6">
     	 <input type="password" class="form-control" id="repeatedPassword" placeholder="Confirm Password">
    	</div>
  		</div>
        <div class="form-group row">
    		<label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
    		<div class="col-sm-6">
      			<input type="email" class="form-control" id="inputEmail3" placeholder="Email">
    		</div>
  		</div>
        <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputPassword1">Password</label>
                <input class="form-control" id="exampleInputPassword1" type="password" placeholder="Password">
              </div>
              <div class="col-md-6">
                <label for="exampleConfirmPassword">Confirm password</label>
                <input class="form-control" id="exampleConfirmPassword" type="password" placeholder="Confirm password">
              </div>
            </div>
          </div>
<%@include file="IncludeAccountFields.jsp" %>
          <a class="btn btn-primary btn-block" href="login.html">Register</a>
        </form:form>
        <div class="text-center">
          <a class="d-block small mt-3" href="<c:url value="/shop/signonForm.do"/>">Login Page</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  <br />
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
  <%@ include file="WEB-INF/jsp/footer.jsp" %>
</body>
</html>