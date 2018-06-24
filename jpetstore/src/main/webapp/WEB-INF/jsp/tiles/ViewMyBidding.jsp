<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
</script>

<br />
<br /><div class="container">
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-7">
<div class="panel-body">
<br />
<table class="table table-bordered">
	<c:choose>
		<c:when test="${fn:length(viewMyBidding) == 0 }">
		<tr><td>경매 참여 내역이 없습니다.</td></tr>
		</c:when>
		<c:otherwise>
			<thead>
				<p><i class="fa fa-comments" style="font-size:24px;color:#0ba360"></i><b> BIDDINGINFO</b></p>
			</thead>
			<tr align="center" bgcolor="#0ba360"><td><font color="ffffff">ITEMID</font></td>
				<td><font color="ffffff"><b>입찰가</b></font></td>
				<td><font color="ffffff"><b>경매 상태</b></font></td></tr>
			<c:forEach var="biddingInfo" items="${viewMyBidding}">
				<tr align="center">
					<td>	
						<a href='<c:url value="/shop/viewAuctionItem.do">
            			<c:param name="itemId" value="${biddingInfo.itemId}"/></c:url>' class="btn btn-primary" role="button">${biddingInfo.itemId}</a></p>
					</td>
					<td>
						<c:out value="${biddingInfo.maxExpectPrice}" />
					</td>
					<td>
					<c:if test="${biddingInfo.auctionItem.auctionStatus.equals('OPEN')}">
						경매 진행중
					</c:if>
					<c:if test="${biddingInfo.auctionItem.auctionStatus.equals('CLOSE')}">
						경매 완료
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
</div>
</div>
</div>
</div>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />