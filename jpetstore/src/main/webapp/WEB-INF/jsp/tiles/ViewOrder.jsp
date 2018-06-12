<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
<div align="center">
<br /><br /><br />
    <p>
      <c:if test="${!empty message}">
    <b><c:out value="${message}" /></b>
  </c:if>
  </p>
  <p></p><br>
<div class="col-sm-7">
    <table class="table">
    <thead class="thead-light">
        <tr>
    	<th><font size="4"><b>Order #<c:out value="${order.orderId}" /></b></font></th>
        <th>
        <font size="3">
          <b>
          <fmt:formatDate value="${order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" /></b></font>
         </th>
    </tr>
      <tr>
        <th>Payment Details</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>
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
        <td width="100">First name:</td>
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
        <td><c:out value="${order.billCountry}" /></td>
      </tr>
    </tbody>
  </table>
  
    <table class="table">
    <thead class="thead-light">
      <tr>
        <th>Shipping Address</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>
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
    </tbody>
  </table>
  <table class="table">
    <thead class="thead-light">
      <tr>
        <th>Status: <c:out value="${order.status}" /></th>
        <th> </th>
      </tr>
    </thead>
    </table>
    
   <table class="table">
    <thead class="thead-light">
      <tr>
        <th><table class="n23" style="width:100%">
          <tr>
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
        </table></th>
      </tr>
    </thead>
    </table>

  <p>
   		
  <a href='<c:url value="/shop/listOrders.do"/>' class="btn btn-primary btn-block">order list</a>
  </p>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </div>
</div>
</div>