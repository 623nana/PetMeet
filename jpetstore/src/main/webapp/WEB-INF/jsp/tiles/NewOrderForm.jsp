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
        <th>Payment Details</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td width="470">Card Type:</td>
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
  <table class="table">
    <thead class="thead-light">
      <tr>
        <th>Billing Address</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>First name:</td>
        <td><form:input path="order.billToFirstName" /> 
        <form:errors path="order.billToFirstName" /></td>
      </tr>
      <tr>
        <td>Last name:</td>
        <td><form:input path="order.billToLastName" />
        <form:errors path="order.billToLastName" /></td>
      </tr>
      <tr>
        <td>Address 1:</td>
        <td><form:input path="order.billAddress1" />
        <form:errors path="order.billAddress1" /></td>
      </tr>
      <tr>
        <td>Address 2:</td>
        <td><form:input path="order.billAddress2" />
        <form:errors path="order.billAddress2" /></td>
      </tr>
      <tr>
        <td>City</td>
        <td><form:input path="order.billCity" /> 
        <form:errors path="order.billCity" /></td>
      </tr>
      <tr>
        <td>State</td>
        <td><form:input path="order.billState" />
        <form:errors path="order.billState" /></td>
      </tr>
      <tr>
        <td>Zip</td>
        <td><form:input path="order.billZip" /> 
        <form:errors path="order.billZip" /></td>
      </tr>
      <tr>
        <td>Country:</td>
        <td><form:input path="order.billCountry" /> 
        <form:errors path="order.billCountry" /></td>
      </tr>
      <tr>
        <td><form:checkbox path="shippingAddressRequired"
          label="Ship to different address..." /></td>
        <td> </td>
      </tr>
    </tbody>
  </table>
  
  <p>
    <input type="submit" class="btn btn-primary btn-block" name="submit" value="submit">
  </p>
  <br /><br /><br /><br /><br />
  </div>
    </form:form>
    
    </div>
</div>