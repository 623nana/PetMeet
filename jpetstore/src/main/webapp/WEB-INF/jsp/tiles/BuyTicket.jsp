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
      <div class="card-header"><b>판매권 구매</b></div>
      <div class="card-body" >

      


	<form method="POST" action='<c:url value="/shop/ticketOrder.do"/>'>
	 <!-- <form method="POST">-->
         <div class="container">  
  <table class="table table-hover">
    <thead>
      <tr>
        <th>선택</th>
        <th>종류</th>
        <th>가격</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><input type="radio" name="Ticket" value="1"></td>
        <td>1회권</td>
        <td>1000원</td>
      </tr>
      <tr>
        <td><input type="radio" name="Ticket" value="3"></td>
        <td>3회권</td>
        <td>2500원</td>
      </tr>
      <tr>
        <td><input type="radio" name="Ticket" value="5"></td>
        <td>5회권</td>
        <td>4000원</td>
      </tr>
    </tbody>
  </table>
</div>
		<input type="submit" class="btn btn-primary btn-block" name="submit" value="Buy">
		</form>
		</div>
		</div>
		</div>
		</div>
		<br />
		<br />
		<br />
		<br />
		
