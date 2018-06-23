<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="<c:url value="/shop/index.do"/>">PET&MET</a>
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
              <a href="<c:url value="/shop/buyTicket.do"/>">판매권 구매</a>
            </li>
            <li>
              <a href="<c:url value="/shop/postItem.do"/>">정찰 상품 등록</a>
            </li>
            <li>
               <a href="<c:url value="/shop/postAuctionItem.do"/>">경매 상품 등록</a>
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
              <a href="<c:url value="/shop/viewHospital.do"/>">가까운 병원 찾기</a>
            </li>
            <li>
              <a href="<c:url value="/shop/surveyForm.do"/>">나에게 맞는 동물 찾기</a>
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
          <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="<c:url value="/shop/messageList.do"/>">
            <i class="fa fa-fw fa-envelope" style="font-size:20px"></i>
            <span class="d-lg-none">Messages
              <span class="badge badge-pill badge-primary">12 New</span>
            </span>
            <span class="indicator text-primary d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
        </li>
        <c:if test="${!empty userSession.account}" >
		<li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown" href="<c:url value="/shop/editAccount.do"/>">
            <i class="fa fa-user-circle" style="font-size:20px"></i>
            <span class="d-lg-none">Account
              <span class="badge badge-pill badge-primary">12 New</span>
            </span>
          </a>
        </li>
        </c:if>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown" href="<c:url value="/shop/viewCart.do"/>" >
            <i class="fa fa-shopping-cart" style="font-size:23px"></i>
            <span class="d-lg-none">CART
              <span class="badge badge-pill badge-warning">6 New</span>
            </span>
            <span class="indicator text-warning d-none d-lg-block">
              <i class="fa fa-fw fa-circle"></i>
            </span>
          </a>
        </li>
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2" method="post" action="<c:url value="/shop/searchItem.do" />">
          	<select class="form-control" id="searchOption" name="searchOption">
        		<option value="species">상품명</option>
        		<option value="userId">판매자</option>
      		</select>&nbsp;
            <div class="input-group">
              <input class="form-control" type="text" id="keyword" name="keyword" placeholder="Search for..." />
              <span class="input-group-append">
                <input type="submit" class="btn btn-primary" name="submit" value="search" />
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