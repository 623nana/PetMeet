<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="row">
  <div class="col-sm-3">.col-sm-4</div>
  <div class="col-sm-8">
<br />
<br />
<br />
<br />
<br />
<br />
<!-- <div align="center">
  <h2><c:out value="${category.name}" /></h2> -->

<div class="row">
<c:choose>
		<c:when test="${fn:length(viewMyPosting) == 0 }">
			<table class="table table-bordered">
			<tr><td>작성한 글이 없습니다.</td></tr>
			</table>
		</c:when>
		<c:otherwise>
<c:forEach var="item" items="${viewMyPosting}">
<div class="col-xs-6 col-md-3">
    <div class="thumbnail">
      <img class="img-thumbnail" src="${pageContext.request.contextPath}/images/${item.image}" width="242" height="200">
      <div class="caption">
        <h3>${item.name}</h3>
               <c:choose>
            	<c:when test="${item.classify.equals('FIXED') }">
            		<font size="2"><b>${item.price} KRW</b></font><br />
            		<c:if test="${item.status.equals('OPEN') }">
            			<font size="2"><b>분양이 진행중입니다.</b></font><br />
            		</c:if>
            		<c:if test="${item.status.equals('CLOSE') }">
            			<font size="2"><b>분양이 종료되었습니다.</b></font><br />
            		</c:if>
            	</c:when>
            	<c:otherwise>
            		<font size="2"><b>경매 상품 입니다.</b></font><br />
            		<c:if test="${item.status.equals('OPEN') }">
            			<font size="2"><b>경매가 진행중입니다.</b></font><br />
            		</c:if>
            		<c:if test="${item.status.equals('CLOSE') }">
            			<font size="2"><b>경매가 종료되었습니다.</b></font><br />
            		</c:if>
            	</c:otherwise>
            </c:choose>
        <font size="2" color="#0ba360">판매자:</font><font size="2">${item.username}</font>
        <br /><br />
        <p><c:choose>
        <c:when test="${item.classify.equals('FIXED') }">
            		<a href='<c:url value="/shop/viewItem.do">
            <c:param name="itemId" value="${item.itemId}"/></c:url>' class="btn btn-primary" role="button">구매하기</a></p>
            	</c:when>
            	<c:otherwise>
            		<a href='<c:url value="/shop/viewAuctionItem.do">
            			<c:param name="itemId" value="${item.itemId}"/></c:url>' class="btn btn-primary" role="button">구매하기</a></p>
            	</c:otherwise>
            	</c:choose></p>
      </div>
  </div>
</div>
      </c:forEach>
      </c:otherwise>
      </c:choose>
<br />
<br />
<br />
<br />
<br />
</div>

<!--
<center>
        <c:if test="${!itemList.firstPage}">
       <a href='<c:url value="/shop/viewCategory2.do">
            <c:param name="page" value="previous"/></c:url>' class="btn btn-primary" role="button" >
              <B>Previous</B></a>
        </c:if> 
        <c:if test="${!itemList.lastPage}">
          <a href='<c:url value="/shop/viewCategory2.do">
            <c:param name="page" value="next"/></c:url>' class="btn btn-primary" role="button">
              <B>Next</B></a>
        </c:if>
        <br />
        <br />
</center>
-->

</div>
</div>
<br />
<br />
<br />
<br />
<br />
<br />
<br />

