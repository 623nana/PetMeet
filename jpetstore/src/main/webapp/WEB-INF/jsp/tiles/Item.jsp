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
<img src="${pageContext.request.contextPath}/images/${item.image}" width="424" height="350">
</div>
<div class="col-sm-5">
<hr>
<h2><B><c:out value="${item.name}" /></B></h2>
<hr>
<p><b><i class="fa fa-money" style="font-size:24px;color:#0ba360"></i>
 PRICE : </b><c:out value="${item.price }" />KRW</p>
<p><b><i class="fa fa-id-badge" style="font-size:24px;color:#0ba360"></i>
 판매자 : </b><c:out value="${item.username }" /></p>
<p><b><i class="fa fa-paw" style="font-size:24px;color:#0ba360"></i>
 GENDER : </b>
 <c:if test="${item.gender.equals('female') }"><font size="5">♀</font>
 </c:if>
 <c:if test="${!item.gender.equals('female') }">
<font size="5">♂</font>
 </c:if>
</p>
<p><b><i class="fa fa-handshake-o" style="font-size:24px;color:#0ba360"></i>
 배송 방법 : </b>
 <c:if test="${item.shipway eq 1 }">
 직거래만 가능한 상품입니다.
  <select class="form-control" id="shipway" name="shipway">
		        		<option value="1">직거래</option></select>
 </c:if>
 <c:if test="${item.shipway eq 2}">
택배거래만 가능한 상품입니다.
  <select class="form-control" id="shipway" name="shipway">
		        		<option value="2">택배거래</option></select>
 </c:if>
  <c:if test="${item.shipway eq 3 }">
직거래와 택배거래 모두 가능한 상품입니다.
  <select class="form-control" id="shipway" name="shipway">
		        		<option value="1">직거래</option>
		        		<option value="2">택배거래</option></select>
 </c:if>
<P><a href='<c:url value="/shop/viewItem.do">
            <c:param name="itemId" value="${item.itemId}"/></c:url>' class="btn btn-primary" role="button">바로구매</a>
   <a href='<c:url value="/shop/addItemToCart.do">
            <c:param name="workingItemId" value="${item.itemId}"/></c:url>' class="btn btn-primary" role="button"><i class="fa fa-cart-arrow-down"></i>&nbsp;장바구니</a>         
            </P>
<hr>
</div>

<div class="col-sm-10">

<p><i class="fa fa-newspaper-o" style="font-size:24px;color:#0ba360"></i><b> CONTENTS : </b></p>
<hr>
<div class="panel panel-default"><div class="panel-body"><c:out value="${item.content }" /></div></div>
</div>
</div>
</div>
</div>
