<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
</script>

<br />
<br />
<table class="table table-bordered">
	<c:choose>
		<c:when test="${fn:length(comment) == 0 }">
		<tr><td>등록된 댓글이 없습니다.</td></tr>
		</c:when>
		<c:otherwise>
			<thead>
				<p><i class="fa fa-comments" style="font-size:24px;color:#0ba360"></i><b> COMMENT</b></p>
			</thead>
			<c:forEach var="Comment" items="${comment}">
				<c:if test="${Comment.commentNum eq 1 }">
					<tr bgcolor="#0ba360">
						<td>
						<font color="ffffff"><i class="fa fa-user" style="font-size:24px"></i> <c:out value="${Comment.commenterName}" /></font>
				</c:if>
				<c:if test="${ Comment.commentNum ne 1  }">
					<tr bgcolor="#eeeeee">
						<td>
						<font color="#0ba360"><i class="fa fa-user" style="font-size:24px"></i> <c:out value="${Comment.commenterName}" /></font>
				</c:if>
				<c:if test="${ Comment.commenterName ne userSession.account.username}">
						<a href='<c:url value="/shop/registerComment.do">
            				<c:param name="commentId" value="${Comment.commentId}"/>
            				<c:param name="itemId" value="${Comment.itemId}"/>
            			</c:url>' class="btn btn-primary" role="button">답글</a>
				
				</c:if>
				<c:if test="${Comment.commenterName eq userSession.account.username }">
						<a href='<c:url value="/shop/deleteComment.do">
            				<c:param name="commentId" value="${Comment.commentId}"/>
            				<c:param name="commentNum" value="${Comment.commentNum}"/>
            				<c:param name="itemId" value="${Comment.itemId}"/>
            			</c:url>' class="btn btn-primary" role="button">삭제</a>
            			<a href='<c:url value="/shop/updateComment.do">
            				<c:param name="commentId" value="${Comment.commentId}"/>
            				<c:param name="commentNum" value="${Comment.commentNum}"/>
            				<c:param name="itemId" value="${Comment.itemId}"/>
            			</c:url>' class="btn btn-primary" role="button">수정</a>
            			
            			</c:if>
            			</td>
				</tr>
			
				<tr>
					<td>
						<c:out value="${Comment.itemComment }" />
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<br />
<br />
<br />