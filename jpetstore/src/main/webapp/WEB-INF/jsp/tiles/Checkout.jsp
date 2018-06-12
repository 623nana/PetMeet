<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
<div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-10">
<br /><br /><br />
	<h2>Checkout Summary</h2>
	<form action='<c:url value="/shop/updateCartQuantities.do"/>' method="post">
        <table id="cart" class="table table-hover">
          <thead>
          <tr>
            <th><b>Item ID</b></th>
            <th><b>Product ID</b></th>
            <th><b>Description</b></th>
            <th><b>In Stock?</b></th>
            <th><b>Quantity</b></th>
            <th><b>List Price</b></th>
            <th><b>Total Cost</b></th>
            <th>&nbsp;</th>
          </tr>
          </thead>

          <c:if test="${cart.numberOfItems == 0}">
            <tr>
              <td colspan="8"><b>Your cart is empty.</b></td>
            </tr>
          </c:if>

          <c:forEach var="cartItem" items="${cart.cartItemList.pageList}">
            <tr>
              <td><b>
                <a href='<c:url value="/shop/viewItem.do">
                  <c:param name="itemId" value="${cartItem.item.itemId}"/></c:url>'>
                  <c:out value="${cartItem.item.itemId}" />
                </a></b></td>
              <td><c:out value="${cartItem.item.productId}" /></td>
               
              <td>
                <c:out value="${cartItem.item.product.description}" /></td>
                
              <td style="text-align:center"><c:out value="${cartItem.inStock}" /></td>
              <td style="text-align:center">
                <input type="text" size="3"
                  name='<c:out value="${cartItem.item.itemId}"/>'
                  value='<c:out value="${cartItem.quantity}"/>' /></td>
              <td style="text-align:right"><fmt:formatNumber
                  value="${cartItem.item.price}" pattern="$#,##0.00" /></td>
              <td style="text-align:right"><fmt:formatNumber
                  value="${cartItem.totalPrice}" pattern="$#,##0.00" /></td>
             
            </tr>
          </c:forEach>
          <tr>
            <td colspan="8" align="right">
              <b>Sub Total: <fmt:formatNumber value="${cart.subTotal}" pattern="$#,##0.00" /></b><br><br> 
             
            </td>
            <td>&nbsp;</td>
          </tr>
        </table>
        <div style="text-align:center">
          <c:if test="${!cart.cartItemList.firstPage}">
            <a href='<c:url value="viewCart.do?page=previousCart"/>'>
              <font color="green"><B>&lt;&lt; Prev</B></font></a>
          </c:if>
          <c:if test="${!cart.cartItemList.lastPage}">
            <a href='<c:url value="viewCart.do?page=nextCart"/>'>
              <font color="green"><B>Next &gt;&gt;</B></font></a>
          </c:if>
        </div>
      </form>
      <div style="text-align:center">
      <a href='<c:url value="/shop/newOrder.do"/>'>
        <img border="0" src="../images/button_continue.gif" alt="" /></a>
     </div>
      <!-- 
    <td style="text-align:right;width:20%;">
      <c:if test="${!empty userSession.account.username}">
        <c:if test="${userSession.account.listOption}">
          <%@ include file="IncludeMyList.jsp"%>
        </c:if>
      </c:if>
    </td>  -->
</div>
</div>
</div>

