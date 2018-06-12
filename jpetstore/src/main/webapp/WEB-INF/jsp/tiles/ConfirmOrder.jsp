<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
<div align="center">
<br /><br /><br />
    <p>
    <b>Please confirm the information below and then press continue...</b>
  </p>
  <p></p><br>
  
  <div class="col-sm-10">
  
  
  <form method="post" action='<c:url value="/shop/confirmOrder.do"/>'>
  <table class="table">
    <thead class="thead-light">
        <tr>
    	<th><font size="4"><b>Order</b></font></th>
        <th>
        <font size="3">
          <b><fmt:formatDate value="${orderForm.order.orderDate}" 
            pattern="yyyy/MM/dd hh:mm:ss" /></b></font>
         </th>
    </tr>
      <tr>
        <th>Billing Address</th>
        <th> </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td width="250">First name:</td>
        <td>${orderForm.order.billToFirstName}</td>
      </tr>
      <tr>
        <td>Last name:</td>
         <td>${orderForm.order.billToLastName}</td>
      </tr>
      <tr>
        <td>Address 1:</td>
        <td>${orderForm.order.billAddress1}</td>
      </tr>
      <tr>
        <td>Address 2:</td>
       <td>${orderForm.order.billAddress2}</td>
      </tr>
      <tr>
        <td>City</td>
        <td>${orderForm.order.billCity}</td>
      </tr>
      <tr>
        <td>State</td>
         <td>${orderForm.order.billState}</td>
      </tr>
      <tr>
        <td>Zip</td>
        <td>${orderForm.order.billZip}</td>
      </tr>
      <tr>
        <td>Country:</td>
        <td>${orderForm.order.billCountry}</td>
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
        <td width="250">First name:</td>
        <td>${orderForm.order.shipToFirstName}</td>
      </tr>
      <tr>
        <td>Last name:</td>
         <td>${orderForm.order.shipToLastName}</td>
      </tr>
      <tr>
        <td>Address 1:</td>
        <td>${orderForm.order.shipAddress1}</td>
      </tr>
      <tr>
        <td>Address 2:</td>
       <td>${orderForm.order.shipAddress2}</td>
      </tr>
      <tr>
        <td>City</td>
        <td>${orderForm.order.shipCity}</td>
      </tr>
      <tr>
        <td>State</td>
        <td>${orderForm.order.shipState}</td>
      </tr>
      <tr>
        <td>Zip</td>
        <td>${orderForm.order.shipZip}</td>
      </tr>
      <tr>
        <td>Country:</td>
        <td>${orderForm.order.shipCountry}</td>
      </tr>
    </tbody>
  </table>
  

  
  
  <p>
   		<input type="submit" class="btn btn-primary btn-block" name="submit" value="continue">
  </p>
  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
 </form> </div>
</div>

</div>