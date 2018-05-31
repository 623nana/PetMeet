<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br />
<br />
<div class="container">
<div class="row">
  <div class="col-sm-3"></div>
  <div class="col-sm-7">
  	<div class="panel panel-success">
  		<br /><br /><br />
      <div class="panel-heading"><B>쪽지함</B></div>
      <br />
      
      <input type="button" class="btn btn-primary btn-block" name="send" value="쪽지 보내기" onclick="location.href='<c:url value="/shop/sendMessage.do"/>'" />
      <div class="panel-body">
      	<form>
      	<br />
      	<div class="col-md-6">
		      <select class="form-control" id="message" name="message" onChange="javascript:selectEvent(this.value);">
		        <option value="1">받은쪽지함</option>
		        <option value="2">보낸쪽지함</option>
		      </select>
        </div>
      	<br /><br />
      	
      	<input type="button" value="1" onClick="fun_img('MessageList.jsp')"/>
		<input type="button" value="2" onClick="fun_img('MessageList2.jsp')"/>
      	
      	
      	<table>
      		<tr>
      			<td>보낸 사람</td>
      			<td>내용</td>
      		</tr>
      		<c:forEach var="message" items="${message}" varStatus="status" >
      		<tr>
      			<td>
      				${message.senderId}
      				${message.message}
      			</td>
      		</tr>
      		</c:forEach>
      	
      	</table>
      </div>
    </div>

      	</div>
      	</form>
      </div>
    </div>
  </div>
</div> 
