<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<p>
<div class="row">
  <div class="col-sm-3"></div>
  <div class="col-sm-9">
<br />
<br />
<br />
<br />
<div class="row">
<div class="col-sm-5">
<img src="${pageContext.request.contextPath}/images/${auctionItem.item.image}" width="424" height="350">
</div>
<div class="col-sm-5">
<hr>
<h2><B><c:out value="${auctionItem.item.name}" /></B></h2>
<hr>
<p><b><i class="fa fa-money" style="font-size:24px;color:#0ba360"></i>
 시작가 : </b><c:out value="${auctionItem.beginPrice }" />KRW</p>
 최고가 : </b><c:out value="${auctionItem.limitPrice }" />KRW</p> 
 마감날 : </b><c:out value="${auctionItem.time}" /></p>
<p><b><i class="fa fa-id-badge" style="font-size:24px;color:#0ba360"></i>
 판매자 : </b><c:out value="${auctionItem.item.username }" /></p>
<p><b><i class="fa fa-paw" style="font-size:24px;color:#0ba360"></i>
 GENDER : </b>
 <c:if test="${auctionItem.item.gender.equals('female') }"><font size="5">♀</font>
 </c:if>
 <c:if test="${!auctionItem.item.gender.equals('female') }">
<font size="5">♂</font>
 </c:if>
</p>
<p><b><i class="fa fa-handshake-o" style="font-size:24px;color:#0ba360"></i>
 배송 방법 : </b>
 <c:if test="${auctionItem.item.shipway eq 1 }">
 직거래만 가능한 상품입니다.
  <select class="form-control" id="shipway" name="shipway">
		        		<option value="1">직거래</option></select>
 </c:if>
 <c:if test="${auctionItem.item.shipway eq 2}">
택배거래만 가능한 상품입니다.
  <select class="form-control" id="shipway" name="shipway">
		        		<option value="2">택배거래</option></select>
 </c:if>
  <c:if test="${auctionItem.item.shipway eq 3 }">
직거래와 택배거래 모두 가능한 상품입니다.
  <select class="form-control" id="shipway" name="shipway">
		        		<option value="1">직거래</option>
		        		<option value="2">택배거래</option></select>
 </c:if>
 <p><b><i class="fa fa-krw" style="font-size:24px;color:#0ba360"></i>
입찰 하기 : </b></p>
<form method="POST" action="<c:url value="/shop/registerBidding.do" />">
<div class="input-group">
	<input type="text" id="expectPrice" name="expectPrice" class="form-control" />
	<input type="hidden" id="itemId" name="itemId" value="${auctionItem.item.itemId}" />
	 <span class="input-group-append">
                <button class="btn btn-primary" type="submit">
                  <i class="fa fa-send"></i>
                </button>
              </span>
              </div>
</form>


<P><c:if test="${auctionItem.item.username.equals(userSession.account.username)}">
   <a href='<c:url value="/shop/postAuctionItem.do">
            <c:param name="itemId" value="${auctionItem.item.itemId}"/></c:url>' class="btn btn-primary" role="button">수정</a></c:if>         
            </P>
<hr>
</div>

<div class="col-sm-10">

<p><i class="fa fa-newspaper-o" style="font-size:24px;color:#0ba360"></i><b> CONTENTS : </b></p>
<hr>
<div class="panel panel-default"><div class="panel-body"><c:out value="${auctionItem.item.content }" /></div></div>

<%@include file="CommentList.jsp" %>
	<c:if test="${!empty userSession.account  }">
	<%@include file="CommentForm.jsp" %>
	</c:if>
</div>
</div>
</div>
</div>
