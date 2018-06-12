<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<br /><br /><br /><br />
<c:set var="targetUrl"><c:url value="/shop/newDirectOrderSubmitted.do" /></c:set>

<div align="center">
<form:form commandName="directOrderForm" action="${targetUrl}" method="post">
  <form:errors cssClass="error" /> <br><br>
  
  
  
    <div class="container">
  <div class="row">
    <div class="card card-register mx-auto mt-3"> 
      <div class="card-header"><b>Payment Details</b></div>
      <div class="card-body" >
      
  <table class="n13">
    <tr>
      <td>Card Type:</td>
      <td><form:select path="directOrder.cardType" items="${creditCardTypes}" />
        <form:errors path="directOrder.cardType" /></td>
    </tr>
    <tr>
      <td>Card Number:</td>
      <td><form:input cssClass="form-control" path="directOrder.creditCard" /> 
        <font color="red" size="2">* Use a fake number!</font>
        <form:errors path="directOrder.creditCard" /></td>
    </tr>
    <tr>
      <td>Expiry Date (MM/YYYY):</td>
      <td><form:input cssClass="form-control" path="directOrder.expiryDate" /> 
        <form:errors path="directOrder.expiryDate" /></td>
    </tr>
    <tr align="center">
      <td colspan="2" >
        <font color="green" size="4"><b>Billing Address</b></font></td>
    </tr>
    <tr>
      <td>First name:</td>
      <td><form:input cssClass="form-control" path="directOrder.billToFirstName" /> 
        <form:errors path="directOrder.billToFirstName" /></td>
    </tr>
    <tr>
      <td>Last name:</td>
      <td><form:input cssClass="form-control" path="directOrder.billToLastName" />
        <form:errors path="directOrder.billToLastName" /></td>
    </tr>
    <tr>
      <td>Address 1:</td>
      <td><form:input cssClass="form-control" path="directOrder.billAddress1" />
        <form:errors path="directOrder.billAddress1" /></td>
    </tr>
    <tr>
      <td>Address 2:</td>
      <td><form:input cssClass="form-control" path="directOrder.billAddress2" />
        <form:errors path="directOrder.billAddress2" /></td>
    </tr>
    <tr>
      <td>City:</td>
      <td><form:input cssClass="form-control" path="directOrder.billCity" /> 
        <form:errors path="directOrder.billCity" /></td>
    </tr>
    <tr>
      <td>State:</td>
      <td><form:input cssClass="form-control" path="directOrder.billState" />
        <form:errors path="directOrder.billState" /></td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td><form:input cssClass="form-control" path="directOrder.billZip" /> 
        <form:errors path="directOrder.billZip" /></td>
    </tr>
    <tr>
      <td>Country:</td>
      <td><form:input cssClass="form-control" path="directOrder.billCountry" /> 
        <form:errors path="directOrder.billCountry" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <form:checkbox cssClass="form-control" path="shippingAddressRequired"
          label="다른 주소로 주문하기" /></td>
    </tr>
  </table>
  </div>
  </div></div></div>
  <p>
    <input type="image" src="../images/button_submit.gif">
  </p>
</form:form>
</div>
<br />
<br />
<br />