<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table id="main-menu">
  <tr>
    <td><a href='<c:url value="/shop/index.do"/>'>
      <b><font color="black" size="2">&lt;&lt; Main Menu</font></b></a>
    </td>
  </tr>  
</table>
<br /><br /><br />
<div align="center">
  <c:if test="${!empty message}">
    <b><c:out value="${message}" /></b>
  </c:if>
  
  <p></p>
  
  $<c:out value="${cost}"></c:out> has been paid..<br>
  There are currently <c:out value="${myticket}"/> ticket(s).<br>
Start selling~<br>
   
</div>