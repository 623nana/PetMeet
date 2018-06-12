<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container" align="center">
  <div class="col-sm-8">
  <br /><br /><br />
    <p>
    <font size="4"><b>My Orders</b></font>
  </p>
   <table class="table">
    <thead class="thead-light">
      <tr align="center">
        <th>Order ID</th>
        <th>Date</th>
        <th>Total Price</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="order" items="${orderList}">
      <tr align="center">
         <td>
          <b><a href='<c:url value="/shop/viewOrder.do">
              <c:param name="orderId" value="${order.orderId}"/></c:url>'>
              <font color="black"><c:out value="${order.orderId}" /></font>
            </a></b></td>
        <td><fmt:formatDate value="${order.orderDate}"
            pattern="yyyy/MM/dd hh:mm:ss" /></td>
        <td><fmt:formatNumber value="${order.totalPrice}"
            pattern="$#,##0.00" /></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>  
    <br /><br /><br />  <br /><br /><br />
</div>
</div>