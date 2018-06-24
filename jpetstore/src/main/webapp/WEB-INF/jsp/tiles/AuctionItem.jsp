<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script>
	function test(){
		var currentMax = "${auctionItem.currentPrice}";
		var min = "${auctionItem.beginPrice}";
		var max = "${auctionItem.limitPrice}";
		var expect = parseInt(bidInfo.expectPrice.value);
		
		if(expect <= currentMax){
			alert('현재 최고가보다 높은 가격을 입력해야합니다!');
			return false
		}
		
		if(expect > max){
			alert('입찰가는 제한가를 넘을 수 없습니다!');
			return false;
		}
		
		if(expect < min){
			alert('입찰 시작가를 확인해주세요!');
			return false;
		}
		
		
		bidInfo.submit();
	}
</script>
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
 제한가 : </b><c:out value="${auctionItem.limitPrice }" />KRW</p> 
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
 직거래만 가능한 상품입니다.<br />
 </c:if>
 <c:if test="${auctionItem.item.shipway eq 2}">
택배거래만 가능한 상품입니다.<br />		
 </c:if>
  <c:if test="${auctionItem.item.shipway eq 3 }">
직거래와 택배거래 모두 가능한 상품입니다.<br />
 </c:if>
 
  <p><b><i class="fa fa-trophy" style="font-size:24px;color:#0ba360"></i>
현재 최고가: </b><c:out value="${auctionItem.currentPrice }" />KRW</p>
 <c:if test="${!auctionItem.item.username.equals(userSession.account.username) && !empty userSession.account 
 								&& !auctionItem.auctionStatus.equals('CLOSE')}">
 <p><b><i class="fa fa-krw" style="font-size:24px;color:#0ba360"></i>
입찰 하기 : </b></p>

<div class="input-group">
<form:form commandName="bidInfo" method="POST" action="/jpetstore/shop/auction/post">
<input type="hidden" id="itemId" name="itemId" value="${auctionItem.item.itemId}" />
	<input type="hidden" id="username" name="username" value="${userSession.account.username }" />
	<input type="text" id="expectPrice" name="expectPrice" class="form-control" />
	 <span class="input-group-append">
                <button class="btn btn-primary" type="button" onclick="test()">
                  <i class="fa fa-send"></i>
                </button>
              </span>
              </form:form>
              </div>

</c:if>
<script>
// Set the date we're counting down to
var countDownDate = new Date("${auctionItem.time}").getTime();

// Update the count down every 1 second
var x = setInterval(function() {

    // Get todays date and time
    var now = new Date().getTime();
    
    // Find the distance between now an the count down date
    var distance = countDownDate - now;
    
    // Time calculations for days, hours, minutes and seconds
    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
    // Output the result in an element with id="demo"
    document.getElementById("demo").innerHTML = "경매 종료까지 " + days + "일 " + hours + "시간 "
    + minutes + "분 " + seconds + "초 남았습니다.";
    
    // If the count down is over, write some text 
    if (distance < 0) {
        clearInterval(x);
        document.getElementById("demo").innerHTML = "경매가 종료되었습니다!";
    }
}, 1000);
</script>
<p><b><i class="fa fa-clock-o" style="font-size:24px;color:#0ba360"></i>
	<span id="demo"></span></b></p>
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
<br />
<hr />
<c:if test="${auctionItem.item.username.equals(userSession.account.username) }">
<div class="col-sm-10">
<c:choose>
	<c:when test="${fn:length(bidList) == 0 }">
	<table class="table table-bordered">
		<tr><td>입찰 참여자가 존재하지 않습니다!</td></tr>
	</table>
	</c:when>
	<c:otherwise>
	<p><i class="fa fa-bookmark" style="font-size:24px;color:#0ba360"></i><b> <c:out value="${userSession.account.username} " />님의 상품에 대한 입찰 기록입니다 </b></p>
	<table class="table table-hover">
    <thead>
      <tr>
        <th>입찰자</th>
        <th>입찰가격</th>
        <th>입찰시간</th>
      </tr>
    </thead>
    <tbody>
<c:forEach var="bidList" items="${bidList }" varStatus="status">
<tr>
<td><c:out value="${bidList.username }" />
	<c:if test="${status.first }">
	🏆
	</c:if>
</td>
<td><c:out value="${bidList.expectPrice }" /></td>
<td><c:out value="${bidList.biddingTime }" /></td>
</tr>
</c:forEach>
</tbody>
</table>
	</c:otherwise>
	</c:choose>
</div>
</c:if>
<c:if test="${!empty userSession.account }">
<div class="col-sm-10">
	<c:if test="${!auctionItem.item.username.equals(userSession.account.username) }">
<c:choose>
	<c:when test="${fn:length(bidList) == 0 }">
	<table class="table table-bordered">
		<tr><td>입찰 참여자가 존재하지 않습니다!</td></tr>
	</table>
	</c:when>
	<c:otherwise>

	<p><i class="fa fa-bookmark" style="font-size:24px;color:#0ba360"></i><b> <c:out value="${userSession.account.username} " />님의 입찰 기록입니다 </b></p>
	<table class="table table-hover">
    <thead>
      <tr>
        <th>입찰자</th>
        <th>입찰가격</th>
        <th>입찰시간</th>
      </tr>
    </thead>
    <tbody>
<c:forEach var="bidList" items="${bidList }" varStatus="status">
<c:if test="${bidList.username eq userSession.account.username }">
<tr>
<td>
<c:out value="${bidList.username }" />
	<c:if test="${status.first }">
	🏆
	</c:if>
</td>
<td><c:out value="${bidList.expectPrice }" /></td>
<td><c:out value="${bidList.biddingTime }" /></td>
</tr></c:if>
</c:forEach>
</tbody>
</table>
	</c:otherwise>
	</c:choose>
	</c:if>
</div>
</c:if>
<%@include file="CommentList.jsp" %>
	<c:if test="${!empty userSession.account  }">
	<%@include file="CommentForm.jsp" %>
	</c:if>
</div>
</div>
</div>
</div>

