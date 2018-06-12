<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="targetUrl"><c:url value="/shop/newOrderSubmitted.do" /></c:set>
<br /><br /><br />
<div class="container">
<div align="center">
  <form:form commandName="orderForm" action="${targetUrl}" method="post">
  <form:errors cssClass="error" /> <br><br>
  <div class="col-sm-10">
  
  <table class="table">
    <thead class="thead-light">
      <tr>
        <th>Shipping Address</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td width="250">First name:</td>
        <td><form:input path="order.shipToFirstName" /> 
        <form:errors path="order.shipToFirstName" /></td>
      </tr>
      <tr>
        <td>Last name:</td>
        <td><form:input path="order.shipToLastName" />
        <form:errors path="order.shipToLastName" /></td>
      </tr>
      <tr>
        <td>Address 1:</td>
        <td><form:input path="order.shipAddress1" />
        <form:errors path="order.shipAddress1" /></td>
      </tr>
      <tr>
        <td>Address 2:</td>
        <td><form:input path="order.shipAddress2" />
        <form:errors path="order.shipAddress2" /></td>
      </tr>
      <tr>
        <td>City</td>
        <td><form:input path="order.shipCity" /> 
        <form:errors path="order.shipCity" /></td>
      </tr>
      <tr>
        <td>State</td>
        <td><form:input path="order.shipState" />
        <form:errors path="order.shipState" /></td>
      </tr>
      <tr>
        <td>Zip</td>
        <td><form:input path="order.shipZip" /> 
        <form:errors path="order.shipZip" /></td>
      </tr>
      <tr>
        <td>Country:</td>
        <td><form:input path="order.shipCountry" /> 
        <form:errors path="order.shipCountry" /></td>
      </tr>

    </tbody>
  </table>
  
  <p>
    <input type="submit" class="btn btn-primary btn-block" name="submit" value="continue">
  </p>
    </form:form>
    </div></div>
</div>