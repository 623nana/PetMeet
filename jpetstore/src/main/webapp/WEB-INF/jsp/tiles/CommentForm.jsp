<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<br />
<br />
<script>
function comment(){
	var comment = document.getElementById('comment.itemComment');
	if(comment.value == ""){
		alert('내용을 입력하세요!');
		return false;
	}
	commentForm.submit();
}
</script>
<form:form commandName="commentForm" method="post">
<table class="table table-bordered">
	<tr bgcolor="#0ba360">
		<td>
			<font color="ffffff"><i class="fa fa-edit"></i><b> 댓글 등록</b></font>
			
		</td>
	</tr>
	<tr>
		<td>

			<textarea class="form-control" rows="10" name="comment.itemComment" id="comment.itemComment" placeholder="내용을 입력하세요."></textarea>
			 <c:choose>
        <c:when test="${item.classify.equals('FIXED') }">
            		<form:hidden path="comment.itemId" value="${item.itemId }" />
            	</c:when>
            	<c:otherwise>
            		<form:hidden path="comment.itemId" value="${auctionItem.item.itemId }" />
            	</c:otherwise>
            	</c:choose>
			<form:hidden path="comment.newComment" value="first" />
		</td>
	</tr>
	<tr align="right">
		<td>

			
			<button class="btn btn-primary" type="button" onclick="comment()">
                 	등록
                </button>

			<input type="reset" class="btn btn-success" name="reset" value="취소" />

		</td>
	</tr>
</table>
<br />
<br />
<br />
<br />
<br />
</form:form>
