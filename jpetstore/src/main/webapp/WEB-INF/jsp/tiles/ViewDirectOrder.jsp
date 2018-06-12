<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<table id="main-menu">
  <tr>
    <td><a href='<c:url value="/shop/index.do"/>'>
      <b><font color="black" size="2">&lt;&lt; Main Menu</font></b></a>
    </td>
  </tr>  
</table>

<div align="center">
  <c:if test="${!empty message}">
    <b><c:out value="${message}" /></b>
  </c:if>
  
  <p></p>
  <table class="n13">
    <tr>
      <td align="center" colspan="2"><font size="4">
        <b>Order #<c:out value="${directOrderForm.directOrder.orderId}" /></b></font> <br />
        <font size="3"><b>
          <fmt:formatDate value="${directOrderForm.directOrder.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" /></b>
        </font></td>
    </tr>
    <tr>
      <td colspan="2"><font color="green" size="4"><b>Payment Details</b></font></td>
    </tr>
    <tr>
      <td>Card Type:</td>
      <td><c:out value="${directOrderForm.directOrder.cardType}" /></td>
    </tr>
    <tr>
      <td>Card Number:</td>
      <td><c:out value="${directOrderForm.directOrder.creditCard}" /> 
        <font color="red" size="2">* Fake number!</font></td>
    </tr>
    <tr>
      <td>Expiry Date (MM/YYYY):</td>
      <td><c:out value="${directOrderForm.directOrder.expiryDate}" /></td>
    </tr>
    <tr>
      <td colspan="2"><font color="green" size="4"><b>Billing Address</b></font></td>
    </tr>
    <tr>
      <td>First name:</td>
      <td><c:out value="${directOrderForm.directOrder.billToFirstName}" /></td>
    </tr>
    <tr>
      <td>Last name:</td>
      <td><c:out value="${directOrderForm.directOrder.billToLastName}" /></td>
    </tr>
    <tr>
      <td>Address 1:</td>
      <td><c:out value="${directOrderForm.directOrder.billAddress1}" /></td>
    </tr>
    <tr>
      <td>Address 2:</td>
      <td><c:out value="${directOrderForm.directOrder.billAddress2}" /></td>
    </tr>
    <tr>
      <td>City:</td>
      <td><c:out value="${directOrderForm.directOrder.billCity}" /></td>
    </tr>
    <tr>
      <td>State:</td>
      <td><c:out value="${directOrderForm.directOrder.billState}" /></td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td><c:out value="${directOrderForm.directOrder.billZip}" /></td>
    </tr>
    <tr>
      <td>Country:</td>
      <td><c:out value="${directOrderForm.directOrder.billCountry}" /></td>
    </tr>
    <tr>
      <td colspan="2"><font color="green" size="4"><b>Shipping Address</b></font></td>
    </tr>
    <tr>
      <td>First name:</td>
      <td><c:out value="${directOrderForm.directOrder.shipToFirstName}" /></td>
    </tr>
    <tr>
      <td>Last name:</td>
      <td><c:out value="${directOrderForm.directOrder.shipToLastName}" /></td>
    </tr>
    <tr>
      <td>Address 1:</td>
      <td><c:out value="${directOrderForm.directOrder.shipAddress1}" /></td>
    </tr>
    <tr>
      <td>Address 2:</td>
      <td><c:out value="${directOrderForm.directOrder.shipAddress2}" /></td>
    </tr>
    <tr>
      <td>City:</td>
      <td><c:out value="${directOrderForm.directOrder.shipCity}" /></td>
    </tr>
    <tr>
      <td>State:</td>
      <td><c:out value="${directOrderForm.directOrder.shipState}" /></td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td><c:out value="${directOrderForm.directOrder.shipZip}" /></td>
    </tr>
    <tr>
      <td>Country:</td>
      <td><c:out value="${directOrderForm.directOrder.shipCountry}" /></td>
    </tr>
    <tr>
      <td>Courier:</td>
      <td><c:out value="${directOrderForm.directOrder.courier}" /></td>
    </tr>
    <tr>
      <td colspan="2"><b><font color="green" size="4">Status:</font> 
        <c:out value="${directOrderForm.directOrder.status}" /></b></td>
    </tr>
    <tr>
      <td colspan="2">
        <table class="n23" style="width:100%">
          <tr style="background-color:#CCCCCC;">
            <td><b>Item ID</b></td>
            <td><b>Description</b></td>
            <td><b>Quantity</b></td>
            <td><b>Price</b></td>
            <td><b>Total Cost</b></td>
          </tr>
          <!-- 
          <c:forEach var="lineItem" items="${order.lineItems}">
            <tr>
              <td>
                <b><a href='<c:url value="/shop/viewItem.do">
                  <c:param name="itemId" value="${lineItem.itemId}"/></c:url>'>
                    <font color="black"><c:out value="${lineItem.itemId}" /></font>
                </a></b></td>
              <td>
                <c:out value="${lineItem.item.attribute1}" />
                <c:out value="${lineItem.item.attribute2}" /> 
                <c:out value="${lineItem.item.attribute3}" />
                <c:out value="${lineItem.item.attribute4}" /> 
                <c:out value="${lineItem.item.attribute5}" />
                <c:out value="${lineItem.item.product.name}" />                 
              </td>
              <td><c:out value="${lineItem.quantity}" /></td>
              <td align="right"><fmt:formatNumber
                  value="${lineItem.unitPrice}" pattern="$#,##0.00" /></td>
              <td align="right"><fmt:formatNumber
                  value="${lineItem.totalPrice}" pattern="$#,##0.00" /></td>
            </tr>
          </c:forEach>
          <tr>
            <td colspan="5" align="right"><b>Total: <fmt:formatNumber
                value="${order.totalPrice}" pattern="$#,##0.00" /></b></td>
          </tr>
          -->
        </table>
      </td>
    </tr>
  </table>
</div>
