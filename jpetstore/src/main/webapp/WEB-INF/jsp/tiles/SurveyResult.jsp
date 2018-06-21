<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!-- <table id="main-menu">
  <tr>
    <td>
      <a href='<c:url value="/shop/viewProduct.do">
        <c:param name="productId" value="${product.productId}"/></c:url>'>
        <b><font color="black" size="2">
          &lt;&lt; <c:out value="${product.name}" /></font></b></a>
    </td>
  </tr>
</table>-->

<br />
<br />
<br />
<br />
<div class="container">
  <div class="row">
    <div class="card card-register mx-auto mt-3"> 
      <div class="card-header"><b>추천 결과</b></div>
      <div class="card-body" >
<h2><B><c:out value="${result.username}" />님은 </B></h2>
<div class="panel panel-default">
<c:if test="${result.surveyResult.equals('A type')}">
<font size="5">A type 입니다!</font><br />
<font size="3">늘 바쁜 당신에게는 손이 많이 가는 동물은 어울리지 않습니다.<br />
손을 덜 타는 물고기나 햄스터, 애완용 쥐, 곤충류가 잘 어울립니다.</font><br />
<img src="../hamster.jpg" style="width:100%"><br />

<a class="nav-link" href="<c:url value="/shop/viewCategory.do?categoryId=FISH"/>">
	<i class="fa fa-home"></i>
	<span class="nav-link-text"><font size="3"><b>물고기 분양받기</b></font></span>
</a>

</c:if>
</div>

<div class="panel panel-default">
<c:if test="${result.surveyResult.equals('B type')}">
<font size="5">B type 입니다!</font><br />
<font size="3">애완동물을 위해 시간이 조금 낼 수 있는 사람입니다.<br />
하루에 1시간 이상 애완동물과 함께 할 수 있다면 강아지, 고양이, 새를 추천합니다.</font><br />
<img src="../puppy.jpg" style="width:100%">
<img src="../kitty.jpg" style="width:100%"><br />

<a class="nav-link" href="<c:url value="/shop/viewCategory.do?categoryId=DOGS"/>">
	<i class="fa fa-home"></i>
	<span class="nav-link-text"><font size="3"><b>강아지 분양받기</b></font></span>
</a>

<a class="nav-link" href="<c:url value="/shop/viewCategory.do?categoryId=CATS"/>">
	<i class="fa fa-home"></i>
	<span class="nav-link-text"><font size="3"><b>고양이 분양받기</b></font></span>
</a>
</c:if>
</div>

<div class="panel panel-default">
<c:if test="${result.surveyResult.equals('C type')}">
<font size="5">C type 입니다!</font><br />
<font size="3">생활이 안정적이며, 애완동물을 새 가족으로 맞이할 수 있을 만큼 시간이 충분합니다.<br />
A타입, B타입 추천 애완동물은 물론 세밀한 관리와 보호가 필요한 이구아나, 뱀 등 파충류까지 편안하게 애완동물을 선택할 수 있습니다.</font><br />
<img src="../turtle.jpg" style="width:100%"><br />

<a class="nav-link" href="<c:url value="/shop/viewCategory.do?categoryId=REPTILES"/>">
	<i class="fa fa-home"></i>
	<span class="nav-link-text"><font size="3"><b>파충류 분양받기</b></font></span>
</a>

</c:if>
</div>
<hr>

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
