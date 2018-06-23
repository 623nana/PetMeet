<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="targetUrl"><c:url value="/shop/newDirectOrderSubmitted.do" /></c:set>

<br /><br /><br /><br />
<div align="center">
<form:form commandName="directOrderForm" action="${targetUrl}" method="post">
  <form:errors cssClass="error" /><br><br>

    <div class="container">
  <div class="row">
    <div class="card card-register mx-auto mt-3"> 
      <div class="card-header"><b>Shipping Address</b></div>
      <div class="card-body" >
      
  <table class="table">
    <tr>
      <td>First name:</td>
      <td><form:input path="directOrder.shipToFirstName" />
        <form:errors path="directOrder.shipToFirstName" /></td>
    </tr>
    <tr>
      <td>Last name:</td>
      <td><form:input path="directOrder.shipToLastName" />
        <form:errors path="directOrder.shipToLastName" /></td>
    </tr>
    <tr>
      <td>Address 1:</td>
      <td><form:input path="directOrder.shipAddress1" /> 
         <form:errors path="directOrder.shipAddress1" /></td>
    </tr>
    <tr>
      <td>Address 2:</td>
      <td><form:input path="directOrder.shipAddress2" /> 
         <form:errors path="directOrder.shipAddress2" /></td>
    </tr>
    <tr>
      <td>City:</td>
      <td><form:input path="directOrder.shipCity" /> 
        <form:errors path="directOrder.shipCity" /></td>
    </tr>
    <tr>
      <td>State:</td>
      <td><form:input path="directOrder.shipState" /> 
        <form:errors path="directOrder.shipState" /></td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td><form:input path="directOrder.shipZip" /> 
        <form:errors path="directOrder.shipZip" /></td>
    </tr>
    <tr>
      <td>Country:</td>
      <td><form:input path="directOrder.shipCountry" /> 
        <form:errors path="directOrder.shipCountry" /></td>
    </tr>
  </table>
  </div></div></div></div>
  <p>
  <br />
    <input type="image" src="../images/button_submit.gif">
  </p>
</form:form>
</div>