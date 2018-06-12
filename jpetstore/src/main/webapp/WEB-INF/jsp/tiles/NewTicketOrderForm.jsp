<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="targetUrl"><c:url value="/shop/confirmTicketOrder.do" /></c:set>
<br /><br /><br />
<div class="container">
<div align="center">
  <form:form commandName="orderForm" action="${targetUrl}" method="post">
  <form:errors cssClass="error" /> <br><br>
  <div class="col-sm-10">
  <table class="table">
    <thead class="thead-light">
      <tr>
        <th>Payment Details</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td width="250">Card Type:</td>
        <td><form:select path="order.cardType" items="${creditCardTypes}" />
        <form:errors path="order.cardType" /></td>
      </tr>
      <tr>
        <td>Card Number:</td>
        <td><form:input path="order.creditCard" /> 
        <font color="red" size="2">* Use a fake number!</font>
        <form:errors path="order.creditCard" /></td>
      </tr>
      <tr>
        <td>Expiry Date(MM/YYYY)</td>
        <td><form:input path="order.expiryDate" /> 
        <form:errors path="order.expiryDate" /></td>
      </tr>
    </tbody>
  </table>
 
  <p>
   		<input type="submit" class="btn btn-primary btn-block" name="submit" value="구매">
  </p>
  </div>
  </form:form>
</div>
</div>
