<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="form-group">
            <div class="form-row">
        <div class="col-md-6">
  		<form:label path="account.firstName" >First name</form:label>
		<form:input path="account.firstName" cssClass="form-control" />
      <form:errors path="account.firstName" cssClass="error" />
</div>
<div class="col-md-6">
  		<form:label path="account.lastName">Last name</form:label>
		<form:input path="account.lastName" cssClass="form-control" />
      <form:errors path="account.lastName" cssClass="error" />
</div>
</div>
</div>

 <div class="form-group">
 	<form:label path="account.email">Email address</form:label>
    <form:input path="account.email" cssClass="form-control" />
      <form:errors path="account.email" cssClass="error" />
  </div>
  	<div class="form-group row">
  	<form:label path="account.phone" cssClass="col-sm-3 col-form-label">PHONE</form:label>
  	<div class="col-sm-6">
  	<form:input path="account.phone" cssClass="form-control" /> 
  	<form:errors path="account.phone" cssClass="error" />
  	</div>
  </div>
  <div class="form-group row">
  	<form:label path="account.address1" cssClass="col-sm-3 col-form-label">Address1</form:label>
  	<div class="col-sm-6">
  	<form:input path="account.address1" cssClass="form-control" />
      <form:errors path="account.address1" cssClass="error" />
      </div>
      </div>
 <div class="form-group row">
  	<form:label path="account.address2" cssClass="col-sm-3 col-form-label">Address2</form:label>
  	<div class="col-sm-6">
  	<form:input path="account.address2" cssClass="form-control" />
      <form:errors path="account.address2" cssClass="error" />
      </div>
      </div>
  <div class="form-group row">
  	<form:label path="account.city" cssClass="col-sm-3 col-form-label">CITY</form:label>
  	<div class="col-sm-6">
  	<form:input path="account.city" cssClass="form-control" />
      <form:errors path="account.city" cssClass="error" />
      </div>
      </div>
  <div class="form-group row">
  	<form:label path="account.state" cssClass="col-sm-3 col-form-label">STATE</form:label>
  	<div class="col-sm-6">
  	<form:input path="account.state" cssClass="form-control" />
      <form:errors path="account.state" cssClass="error" />
      </div>
      </div>
    <div class="form-group row">
  	<form:label path="account.zip" cssClass="col-sm-3 col-form-label">ZIP</form:label>
  	<div class="col-sm-6">
  	<form:input path="account.zip" cssClass="form-control" />
      <form:errors path="account.zip" cssClass="error" />
      </div>
      </div>
    <div class="form-group row">
  	<form:label path="account.country" cssClass="col-sm-3 col-form-label">COUNTRY</form:label>
  	<div class="col-sm-6">
  	<form:input path="account.country" cssClass="form-control" />
      <form:errors path="account.country" cssClass="error" />
      </div>
      </div>
<h3>
  <font color="darkgreen">Profile Information</font>
</h3>
	
<table class="n13" >
  <tr>
    <td>Language Preference:</td>
    <td><form:select cssClass="form-control" path="account.languagePreference" items="${languages}" />
      <form:errors path="account.languagePreference" cssClass="error" /></td>
  </tr>
  <tr>
    <td>Favourite Category:</td>
    <td><form:select cssClass="form-control" path="account.favouriteCategoryId" items="${categories}" /> 
      <form:errors path="account.favouriteCategoryId" cssClass="error" /></td>
  </tr>
  <tr>
    <td colspan="2"><form:checkbox path="account.listOption" label="Enable MyList" /> 
      <form:errors path="account.listOption" cssClass="error" /></td>
  </tr>
  <tr>
    <td colspan="2"><form:checkbox path="account.bannerOption" label="Enable MyBanner" /> 
      <form:errors path="account.bannerOption" cssClass="error" /></td>
  </tr>
</table>