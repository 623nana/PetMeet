<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<br /><br /><br /><br />
<table id="main-menu">
  <tr><td>
    <a href='<c:url value="/shop/index.do"/>'>
      <b><font color="black" size="2">&lt;&lt; Main Menu</font></b></a>
  </td></tr>
</table>

<div align="center">
  <p>
    <b>Please confirm the information below and then press continue...</b>
  </p>
  <p></p>
  <div class="container">
  <div class="row">
    <div class="card card-register mx-auto mt-3"> 
      <div class="card-header"><font size="4"><b>Order</b></font>
      <br />       
       <font size="3">
          <b><fmt:formatDate value="${directOrderForm.directOrder.orderDate}" 
            pattern="yyyy/MM/dd hh:mm:ss" /></b></font>
            </div>
      <div class="card-body" >
  <table class="n13">
    <tr>
      <td colspan="2">
        <font color="GREEN" size="4"><hr /><b>Billing Address</b><hr /></font></td>
    </tr>
    <tr>
      <td>First name:</td>
      <td>${directOrderForm.directOrder.billToFirstName}</td>
    </tr>
    <tr>
      <td>Last name:</td>
      <td>${directOrderForm.directOrder.billToLastName}</td>
    </tr>
    <tr>
      <td>Address 1:</td>
      <td>${directOrderForm.directOrder.billAddress1}</td>
    </tr>
    <tr>
      <td>Address 2:</td>
      <td>${directOrderForm.directOrder.billAddress2}</td>
    </tr>
    <tr>
      <td>City:</td>
      <td>${directOrderForm.directOrder.billCity}</td>
    </tr>
    <tr>
      <td>State:</td>
      <td>${directOrderForm.directOrder.billState}</td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td>${directOrderForm.directOrder.billZip}</td>
    </tr>
    <tr>
      <td>Country:</td>
      <td>${directOrderForm.directOrder.billCountry}</td>
    </tr>
    <tr>
      <td colspan="2">
        <hr /><font color="GREEN" size="4"><b>Shipping Address</b></font><hr /></td>
    </tr>
    <tr>
      <td>First name:</td>
      <td>${directOrderForm.directOrder.shipToFirstName}</td>
    </tr>
    <tr>
      <td>Last name:</td>
      <td>${directOrderForm.directOrder.shipToLastName}</td>
    </tr>
    <tr>
      <td>Address 1:</td>
      <td>${directOrderForm.directOrder.shipAddress1}</td>
    </tr>
    <tr>
      <td>Address 2:</td>
      <td>${directOrderForm.directOrder.shipAddress2}</td>
    </tr>
    <tr>
      <td>City:</td>
      <td>${directOrderForm.directOrder.shipCity}</td>
    </tr>
    <tr>
      <td>State:</td>
      <td>${directOrderForm.directOrder.shipState}</td>
    </tr>
    <tr>
      <td>Zip:</td>
      <td>${directOrderForm.directOrder.shipZip}</td>
    </tr>
    <tr>
      <td>Country:</td>
      <td>${directOrderForm.directOrder.shipCountry}</td>
    </tr>
  </table>
  </div></div></div></div>
  <p>
  <br />
    <a href='<c:url value="/shop/confirmDirectOrder.do"/>'>
      <img border="0" src="../images/button_continue.gif" alt="" /></a>
  </p>
</div>
<br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>
