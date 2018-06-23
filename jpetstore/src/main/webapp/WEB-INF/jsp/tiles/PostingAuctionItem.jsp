<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<br />
<br />
<br />

  <div class="container">
  <div class="row">
    <div class="card card-register mx-auto mt-3"> 
      <div class="card-header"><b>경매 판매글 올리기</b></div>
      <div class="card-body" >
	<form:form commandName="postingAuction" method="post" enctype="multipart/form-data">
	      	<form:errors cssClass="error" />
          <div class="form-group">
            <form:label path="auctionItem.item.name">Species</form:label>
            <c:choose>
            	<c:when test="${!empty postingAuction.auctionItem.item.itemId }">
            		<form:input cssClass="form-control" path="auctionItem.item.name" placeholder="동물의 종을 입력하세요." readonly="true" />
            		<form:errors path="auctionItem.item.name" cssClass="error" />
            	</c:when>
            	<c:otherwise>
            		<form:input cssClass="form-control" path="auctionItem.item.name" placeholder="동물의 종을 입력하세요." />
            		<form:errors path="auctionItem.item.name" cssClass="error" />
            	</c:otherwise>
            </c:choose>
          </div>
          <div class="form-group">
            <label for="category">Category</label>
            <c:choose>
            	<c:when test="${!empty postingAuction.auctionItem.item.itemId }">
            		 <select class="form-control" id="auctionItem.item.categoryId" name="auctionItem.item.categoryId" disabled="true">
            	</c:when>
            	<c:otherwise>
            		 <select class="form-control" id="auctionItem.item.categoryId" name="auctionItem.item.categoryId">
            	</c:otherwise>
            </c:choose>
        		<option value="DOGS">DOG</option>
        		<option value="CATS">CAT</option>
        		<option value="FISH">FISH</option>
        		<option value="REPTILES">REPTILES</option>
        		<option value="BIRDS">BIRDS</option>
        		<option value="OTHER">OTHER</option>
      		</select>
          </div>
          <div class="form-group">
          	<div class="form-row">
          		<div class="col-md-6">
            		<form:label path="auctionItem.beginPrice">경매시작가</form:label>
            		            <c:choose>
            	<c:when test="${!empty postingAuction.auctionItem.item.itemId }">
            		<form:input cssClass="form-control" path="auctionItem.beginPrice" placeholder="경매 시작 가격을 입력하세요." readonly="true"/>
            		<form:errors path="auctionItem.beginPrice" cssClass="error" />
            	</c:when>
            	<c:otherwise>
            		<form:input cssClass="form-control" path="auctionItem.beginPrice" placeholder="경매 시작 가격을 입력하세요." />
            		<form:errors path="auctionItem.beginPrice" cssClass="error" />
            	</c:otherwise>
            </c:choose>
          		</div>
          		<div class="col-md-6">
          			<form:label path="auctionItem.limitPrice">경매최고가</form:label>
            		            <c:choose>
            	<c:when test="${!empty postingAuction.auctionItem.item.itemId }">
            		<form:input cssClass="form-control" path="auctionItem.limitPrice" placeholder="경매 최고 가격을 입력하세요." readonly="true"/>
            		<form:errors path="auctionItem.limitPrice" cssClass="error" />
            	</c:when>
            	<c:otherwise>
            		<form:input cssClass="form-control" path="auctionItem.limitPrice" placeholder="경매 최고 가격을 입력하세요." />
            		<form:errors path="auctionItem.limitPrice" cssClass="error" />
            	</c:otherwise>
            </c:choose>
          		</div>
          		</div>
          		</div>
          		<div class="form-group">
          	<div class="form-row">
          		<div class="col-md-6">
          			<label for="shipWay">Ship Way</label>
		           	 <select class="form-control" id="auctionItem.item.shipway" name="auctionItem.item.shipway">
		        		<option value="1">직거래</option>
		        		<option value="2">택배거래</option>
		        		<option value="3">모두 가능</option>
		      		</select>
          		</div>
          		<div class="col-md-6">
          		<label>경매 종료 시간</label>
          		 <c:choose>
            	<c:when test="${!empty postingAuction.auctionItem.item.itemId }">
				<form:input path="auctionItem.time" cssClass="form-control" placeholder=" yyyy-MM-dd HH:mm 형식으로 미래의 시각을 입력하세요." readonly="true"/>
        		<form:errors path="auctionItem.time" cssClass="error" />
            	</c:when>
            	<c:otherwise>
            		<form:input path="auctionItem.time" cssClass="form-control" placeholder=" yyyy-MM-dd HH:mm 형식으로 미래의 시각을 입력하세요."/>
					<form:errors path="auctionItem.time" cssClass="error" />      	
            	</c:otherwise>
            </c:choose>

          		</div>
          	</div>
          </div>
          <div class="form-group">
            <label for="gender">Gender</label><br />
            <label class="radio-inline"><input type="radio" id="auctionItem.item.gender" name="auctionItem.item.gender" value="female"> female</label>&nbsp;
            <label class="radio-inline"><input type="radio" id="auctionItem.item.gender" name="auctionItem.item.gender" value="male"> male</label>
          </div>
		<div class="form group">
			<input type="file" id="file" name="file" />
		</div>
	<div class="form-group row">
    		<label for="content" class="col-sm-5 col-form-label">Content</label>
      			 <textarea class="form-control" cols="50" rows="10" name="auctionItem.item.content" id="item.content" placeholder="내용을 입력하세요."><c:out value="${postingAuction.auctionItem.item.content }" /></textarea>
  				<form:errors path="auctionItem.item.content" cssClass="error" />
  		</div>
		<input type="submit" class="btn btn-primary btn-block" name="submit" value="등록">
		</form:form>
		</div>
		</div>
		</div>
		</div>
		<br />
		<br />
		<br />
		<br />