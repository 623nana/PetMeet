<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<br />
<br />
<%@include file="/WEB-INF/jsp/header.jsp" %>

  <div class="container">
  <div class="row">
    <div class="card card-register mx-auto mt-3"> 
      <div class="card-header"><b>나에게 맞는 동물 찾기</b></div>
      <div class="card-body" >
	<form method="POST" action="<c:url value="/shop/surveyResult.do"/>">
        <div class="panel panel-default">
            <div class="panel-body">Q1. 나는 주말에, <br />
                <div class="radio">
                  <label><input type="radio" name="q1" value="a"> a. 직장에서 일한다.</label><br />
                  <label><input type="radio" name="q1" value="b"> b. 집에서 일한다.</label><br />
                  <label><input type="radio" name="q1" value="c"> c. 집에서 집안일을 한다.</label><br />
                </div>
             </div>
         </div>
         
         <div class="panel panel-default">
            <div class="panel-body">Q2. 우리 가족은 여행을, <br />
                <div class="radio">
                  <label><input type="radio" name="q2" value="a"> a. 가끔 먼 여행을 가서 몇 주 동안 시간을 보내고 온다.</label><br />
                  <label><input type="radio" name="q2" value="b"> b. 일 년에 3~4번, 시간이 날 때마다 때때로 나간다.</label><br />
                  <label><input type="radio" name="q2" value="c"> c. 일 년에 한두 번 간다.</label><br />
                </div>
             </div>
         </div>
         
         <div class="panel panel-default">
            <div class="panel-body">Q3. 내 하루 스케줄은, <br />
                <div class="radio">
                  <label><input type="radio" name="q3" value="a"> a. 엄청 바빠서 언제 주말에 쉬었는지 기억이 나지 않는다.</label><br />
                  <label><input type="radio" name="q3" value="b"> b. 바쁘지만 가끔 한가한 시간이 있다.</label><br />
                  <label><input type="radio" name="q3" value="c"> c. 대개 안정적이며, 주말은 예외다.</label><br />
                </div>
             </div>
         </div>
         
         <div class="panel panel-default">
            <div class="panel-body">Q4. 나는 이사를 할 계획이다, <br />
                <div class="radio">
                  <label><input type="radio" name="q4" value="a"> a. 6개월 안에.</label><br />
                  <label><input type="radio" name="q4" value="b"> b. 몇 년 뒤에 언젠가는.</label><br />
                  <label><input type="radio" name="q4" value="c"> c. 이사 계획이 없다.</label><br />
                </div>
             </div>
         </div>
         
         <div class="panel panel-default"> 
            <div class="panel-body">Q5. 나는 자녀를 더 낳을 계획이 있다, <br />
                <div class="radio">
                  <label><input type="radio" name="q5" value="a"> a. 조만간, 나는 현재 임신 중이거나 임신을 위해 노력 중이거나 입양을 계획 중이다.</label><br />
                  <label><input type="radio" name="q5" value="b"> b. 언젠가는, 하지만 노력하거나 계획하지는 않는다.</label><br />
                  <label><input type="radio" name="q5" value="c"> c. 우리 가족은 지금 이대로 완벽하다.</label><br />
                </div>
             </div>
         </div>
         
         <div class="panel panel-default">
            <div class="panel-body">Q6. 우리 가족 중에 애완동물 알레르기가 있는 사람이, <br />
                <div class="radio">
                  <label><input type="radio" name="q6" value="a"> a. 있다.</label><br />
                  <label><input type="radio" name="q6" value="b"> b. 나도 모르겠다.</label><br />
                  <label><input type="radio" name="q6" value="c"> c. 없다.</label><br />
                </div>
             </div>
         </div>
         
         <div class="panel panel-default">
            <div class="panel-body">Q7. 지금 사는 집에 애완동물이 들어오는 걸, <br />
                <div class="radio">
                  <label><input type="radio" name="q7" value="a"> a. 허락하지 않겠다.</label><br />
                  <label><input type="radio" name="q7" value="b"> b. 허락할지 나도 모르겠다.</label><br />
                  <label><input type="radio" name="q7" value="c"> c. 허락하겠다.</label><br />
                </div>
             </div>
         </div>
         
         <h4>※ a, b, c 중 가장 많이 선택된 항목이 자신의 타입.</h4>
         <br/>
         <div class="row">
          <div class="col-sm-4"><input type="reset" class="btn btn-primary btn-block" value="다시 선택하기" /></div>
          <div class="col-sm-4"><input type="submit" class="btn btn-primary btn-block" value="진단하기" /></div>
          <br /><br />
         </div>
    </form>
    	</div>
		</div>
		</div>
		</div>
		<br />
		<br />
		<br />
		<br />
		
	<%@include file="/WEB-INF/jsp/footer.jsp" %>
