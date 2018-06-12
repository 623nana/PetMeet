<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br />
<br />
<br />

  <div class="container">
  <div class="row">
    <div class="card card-register mx-auto mt-3"> 
      <div class="card-header"><b>정찰 판매글 올리기</b></div>
      <div class="card-body" >
	<form:form commandName="postingForm" method="post" enctype="multipart/form-data">
          <div class="form-group">
            <form:label path="item.name">Species</form:label>
            <form:input cssClass="form-control" path="item.name" placeholder="동물의 종을 입력하세요." />
            <B><form:errors path="item.name" cssClass="error" /></B>
          </div>
          <div class="form-group">
            <label for="category">Category</label>
            <select class="form-control" id="item.categoryId" name="item.categoryId">
        		<option value="DOG">DOG</option>
        		<option value="CAT">CAT</option>
        		<option value="FISH">FISH</option>
        		<option value="REPTILES">REPTILES</option>
        		<option value="BIRDS">BIRDS</option>
        		<option value="OTHER">OTHER</option>
      		</select>      		
          </div>
          <div class="form-group">
          	<div class="form-row">
          		<div class="col-md-6">
            		<form:label path="item.price">Price</form:label>
            		<form:input cssClass="form-control" path="item.price" placeholder="가격을 입력하세요." />            		
            		<B><form:errors path="item.price" cssClass="error" /></B>
          		</div>
          		<div class="col-md-6">
          			<label for="shipWay">Ship Way</label>
		           	 <select class="form-control" id="item.shipway" name="item.shipway">
		        		<option value="1">직거래</option>
		        		<option value="2">택배거래</option>
		        		<option value="3">모두 가능</option>
		      		</select>
          		</div>
          	</div>
          </div>
          <div class="form-group">
            <label for="gender">Gender</label><br />
            <label class="radio-inline"><input type="radio" id="item.gender" name="item.gender" value="female"> female</label>&nbsp;
            <label class="radio-inline"><input type="radio" id="item.gender" name="item.gender" value="male"> male</label>
          </div>
		<div class="form group">
			<input type="file" id="file" name="file" />
			<B><form:errors path="item.image" cssClass="error" /></B>
		</div>
	<div class="form-group row">
    		<label for="content" class="col-sm-5 col-form-label">Content</label>
      			 <textarea class="form-control" cols="50" rows="10" name="item.content" id="item.content" placeholder="내용을 입력하세요."></textarea>
  		</div>
		<input type="submit" class="btn btn-primary btn-block" name="submit">
		<input type="button" class="btn btn-primary btn-block" name="comment" value="댓글 달기" onclick="location.href='<c:url value="/shop/registerComment.do" />'" />
		</form:form>
		</div>
		</div>
		</div>
		</div>
		<br />
		<br />
		<br />
		<br />