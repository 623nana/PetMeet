<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="WEB-INF/jsp/header.jsp" %>


  <div class="container">
  <div class="row">
    <div class="card card-register mx-auto mt-3"> 
      <div class="card-header"><b>정찰 판매글 올리기</b></div>
      <div class="card-body" >
	<form>
          <div class="form-group">
            <label for="title">Title</label>
            <input class="form-control" id="title" type="title" placeholder="글 제목을 입력하세요." />
          </div>
          <div class="form-group">
            <label for="category">Category</label>
            <select class="form-control" id="category">
        		<option>DOG</option>
        		<option>CAT</option>
        		<option>FISH</option>
        		<option>REPTILES</option>
        		<option>BIRDS</option>
        		<option>OTHER</option>
      		</select>
          </div>
          <div class="form-group">
          	<div class="form-row">
          		<div class="col-md-6">
            		<label for="price">Price</label>
            		<input class="form-control" id="price" type="text" placeholder="가격을 입력하세요." />
          		</div>
          		<div class="col-md-6">
          			<label for="shipWay">Ship Way</label>
		           	 <select class="form-control" id="shipWay">
		        		<option value="1">직거래</option>
		        		<option value="2">택배거래</option>
		        		<option value="3">모두 가능</option>
		      		</select>
          		</div>
          	</div>
          </div>
          <div class="form-group">
            <label for="gender">Gender</label><br />
            <label class="radio-inline"><input type="radio" name="Gender" value="female"> female</label>&nbsp;
            <label class="radio-inline"><input type="radio" name="Gender" value="male"> male</label>
          </div>
          
           	<div class="form-group row">
    		<label for="content" class="col-sm-5 col-form-label">Content</label>
      			 <textarea class="form-control" cols="50" rows="10" id="content" placeholder="내용을 입력하세요."></textarea>
  		</div>
  		
		<input type="submit" class="btn btn-primary btn-block" name="submit" value="Register" />

</form>
</div>
</div>
</div></div>
<p />
<p />
<%@ include file="WEB-INF/jsp/footer.jsp" %>
</body>
</html>