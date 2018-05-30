<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<br />
<br />
<div class="container">
<div class="row">
  <div class="col-sm-2"></div>
  <div class="col-sm-7">
  	<div class="panel panel-success">
      <div class="panel-heading"><B>쪽지 보내기</B></div>
      <div class="panel-body">
      	<form>
      	<div class="form-group row">
      		<label for="receiver" class="col-sm-2 col-form-label">받는 사람:</label>
      		<div class="col-sm-6">
      		<input type="text" id="receiver" name="receiver" class="form-control" placeholder="받는 사람을 입력하세요." />
      		</div>
      		</div>
      		<div class="form-group row">
      		<div class="col-sm-12">
      <textarea class="form-control" rows="10" id="comment" placeholder="내용을 입력하세요."></textarea>
      <br />
      	<input type="submit" class="btn btn-primary btn-block" name="submit" value="전송하기" />
      </div>
    </div>

      	</div>
      	</form>
      </div>
    </div>
  </div>
</div> 
