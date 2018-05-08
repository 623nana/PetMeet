<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>PET&MET :: MEET YOUR PET!</title>
  <!-- Bootstrap core CSS-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/bootstrap/css/bootstrap.min.css">
  <!-- <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
  <!-- Custom fonts for this template-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/font-awesome/css/font-awesome.min.css">
  <!--  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">-->
  <!-- Page level plugin CSS-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/vendor/datatables/dataTables.bootstrap4.css">
  <!-- <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet"> -->
  <!-- Custom styles for this template-->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/sb-admin.css">
  <!--<link href="css/sb-admin.css" rel="stylesheet">-->
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
	.linkcolor{
	color:#0ba360;
	}
</style>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
 <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.html">PET&MET</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="DOGS">
          <a class="nav-link" href="<c:url value="/shop/viewCategory.do?categoryId=DOGS"/>">
            <i class="fa fa-home"></i>
            <span class="nav-link-text">DOGS</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="CATS">
          <a class="nav-link" href="<c:url value="/shop/viewCategory.do?categoryId=CATS"/>">
            <i class="fa fa-home"></i>
            <span class="nav-link-text">CATS</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="FISH">
          <a class="nav-link" href="<c:url value="/shop/viewCategory.do?categoryId=FISH"/>">
            <i class="fa fa-home"></i>
            <span class="nav-link-text">FISH</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="REPTILES">
          <a class="nav-link" href="<c:url value="/shop/viewCategory.do?categoryId=REPTILES"/>">
            <i class="fa fa-home"></i>
            <span class="nav-link-text">REPTILES</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="BIRDS">
          <a class="nav-link" href="<c:url value="/shop/viewCategory.do?categoryId=BIRDS"/>">
            <i class="fa fa-home"></i>
            <span class="nav-link-text">BIRDS</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Components">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseComponents" data-parent="#exampleAccordion">
            <i class="fa fa-user-circle"></i>
            <span class="nav-link-text">상품 등록</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseComponents">
            <li>
              <a href="navbar.html">판매권 구매</a>
            </li>
            <li>
              <a href="cards.html">상품 등록</a>
            </li>
          </ul>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Example Pages">
          <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#collapseExamplePages" data-parent="#exampleAccordion">
            <i class="fa fa-asterisk"></i>
            <span class="nav-link-text">ETC</span>
          </a>
          <ul class="sidenav-second-level collapse" id="collapseExamplePages">
            <li>
              <a href="login.html">가까운 병원 찾기</a>
            </li>
            <li>
              <a href="register.html">나에게 맞는 동물 찾기</a>
            </li>
          </ul>
        </li>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
      
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-fw fa-envelope" style="font-size:20px"></i>
            <span class="d-lg-none">Messages
              <span class="badge badge-pill badge-primary">12 New</span>
            </span>
            <span class="indicator text-primary d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="messagesDropdown">
            <h6 class="dropdown-header">New Messages:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>David Miller</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">Hey there! This new version of SB Admin is pretty awesome! These messages clip off when they reach the end of the box so they don't overflow over to the sides!</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>Jane Smith</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">I was wondering if you could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <strong>John Doe</strong>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">I've sent the final files over to you for review. When you're able to sign off of them let me know and we can discuss distribution.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">View all messages</a>
          </div>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fa fa-shopping-cart" style="font-size:23px"></i>
            <span class="d-lg-none">Alerts
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
          <div class="dropdown-menu" aria-labelledby="alertsDropdown">
            <h6 class="dropdown-header">New Alerts:</h6>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-danger">
                <strong>
                  <i class="fa fa-long-arrow-down fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#">
              <span class="text-success">
                <strong>
                  <i class="fa fa-long-arrow-up fa-fw"></i>Status Update</strong>
              </span>
              <span class="small float-right text-muted">11:21 AM</span>
              <div class="dropdown-message small">This is an automated server response message. All systems are online.</div>
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item small" href="#">View all alerts</a>
          </div>
        </li>
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
          	<select class="form-control" id="sel1">
        		<option>상품명</option>
        		<option>판매자</option>
      		</select>&nbsp;
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Search for...">
              <span class="input-group-append">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <c:if test="${empty userSession.account}" >
            	<a class="linkcolor" href="<c:url value="/shop/signonForm.do"/>">
            		<i class="fa fa-fw fa-sign-in"></i>Login</a>
            		</c:if>
              <c:if test="${!empty userSession.account}" >
              	<a class="linkcolor" href="<c:url value="/shop/signoff.do"/>">
              		<i class="fa fa-fw fa-sign-out"></i>Logout</a>
              </c:if>
            </a>
        </li>
      </ul>
    </div>
  </nav>
</body>
</html>


 