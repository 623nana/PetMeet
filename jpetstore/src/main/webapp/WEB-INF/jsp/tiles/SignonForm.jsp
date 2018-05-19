<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br />
<br />
<c:if test="${!empty message}">
  <b><font color="red"><c:url value="${message}" /></font></b>
</c:if>


  <div class="container">
              <form action='<c:url value="/shop/signon.do"/>' method="POST">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
          <div class="form-group">

    		<c:if test="${!empty signonForwardAction}">
      			<input type="hidden" name="forwardAction" value='<c:url value="${signonForwardAction}"/>' />
    		</c:if>
            <label for="exampleInputEmail1">User ID</label>
            <input class="form-control" name="username" id="username" type="text" placeholder="Enter Your ID" />
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" name="password" id="password" type="password" placeholder="Password" />
          </div>
          <input type="submit" class="btn btn-primary btn-block" value="Login" />
          </form>

        <div class="text-center">
          <a class="d-block small mt-3" href='<c:url value="/shop/newAccount.do"/>'>Register an Account</a>
        </div>
      </div>
    </div>
    </div>