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
  <div class=container">
  <div class="row">
    <div class="card card-register mx-auto mt-3"> 
      <div class="card-header"><font size="4"><b>Order #<c:out value="${order.orderId}" /></b></font>
      <br />
      	<font size="3">
      		<b><fmt:formatDate value="${order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" /></b>
        </font>
        </div>
      <div class="card-body" >
  <table class="n13">
    <tr>
      <td colspan="2" align="center"><font color="green" size="4"><b>Payment Details</b></font><br /></td>
    </tr>
    <tr>
      <td>Card Type:</td>
      <td><c:out value="${order.cardType}" /></td>
    </tr>
    <tr>
      <td>Card Number:</td>
      <td><c:out value="${order.creditCard}" /> 
        <font color="red" size="2">* Fake number!</font></td>
    </tr>
    <tr>
      <td>Expiry Date (MM/YYYY):</td>
      <td><c:out value="${order.expiryDate}" /></td>
    </tr>
    <tr>
      <td colspan="2" align="center"><font color="green" size="4"><hr /><b>Billing Address</b></font><br /></td>
    </tr>
    <tr>
      <td>First name:</td>
      <td><c:out value="${order.billToFirstName}" /></td>
    </tr>
    <tr>
      <td>Last name:</td>
      <td><c:out value="${order.billToLastName}" /></td>
    </tr>
    <tr>
      <td>Address 1:</td>
      <td><c:out value="${order.billAddress1}" /></td>
    </tr>
    <tr>
      <td>Address 2:</td>
      <td><c:out value="${order.billAddress2}" /></td>
    </tr>
    <tr>
      <td>City:</td>
      <td><c:out value="${order.billCity}" /></td>
    </tr>
    <tr>
      <td>State:</td>
      <td><c:out value="${order.billState}" /></td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td><c:out value="${order.billZip}" /></td>
    </tr>
    <tr>
      <td>Country:</td>
   </tr>
    <tr>
      <td colspan="2" align="center"><font color="green" size="4"><hr /><b>Shipping Address</b></font><br /></td>
    </tr>
    <tr>
      <td>First name:</td>
      <td><c:out value="${order.shipToFirstName}" /></td>
    </tr>
    <tr>
      <td>Last name:</td>
      <td><c:out value="${order.shipToLastName}" /></td>
    </tr>
    <tr>
      <td>Address 1:</td>
      <td><c:out value="${order.shipAddress1}" /></td>
    </tr>
    <tr>
      <td>Address 2:</td>
      <td><c:out value="${order.shipAddress2}" /></td>
    </tr>
    <tr>
      <td>City:</td>
      <td><c:out value="${order.shipCity}" /></td>
    </tr>
    <tr>
      <td>State:</td>
      <td><c:out value="${order.shipState}" /></td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td><c:out value="${order.shipZip}" /></td>
    </tr>
    <tr>
      <td>Country:</td>
      <td><c:out value="${order.shipCountry}" /></td>
    </tr>
    <tr>
      <td>Courier:</td>
      <td><c:out value="${order.courier}" /></td>
    </tr>
    <tr>
      <td colspan="2"><b><font color="green" size="4">Status:</font> 
        <c:out value="${directOrder.status}" /></b></td>
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
		<c:forEach var="lineItem" items="${order.lineItems}">
            <tr>
              <td align="center">
                <b><a href='<c:url value="/shop/viewItem.do">
                  <c:param name="itemId" value="${lineItem.itemId}"/></c:url>'>
                    <font color="black"><c:out value="${lineItem.itemId}" /></font>
                </a></b></td>
             <td align="center"><c:out value="${cartItem.item.product.description}" /></td>
              <td align="center"><c:out value="${lineItem.quantity}" /></td>
              <td align="center"><fmt:formatNumber
                  value="${lineItem.unitPrice}" pattern="$#,##0.00" /></td>
              <td align="center"><fmt:formatNumber
                  value="${lineItem.totalPrice}" pattern="$#,##0.00" /></td>
            </tr>
          </c:forEach>
          <tr>
            <td colspan="5" align="right"><b>Total: <fmt:formatNumber
                value="${order.totalPrice}" pattern="$#,##0.00" /></b></td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  </div></div></div></div>
</div><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
