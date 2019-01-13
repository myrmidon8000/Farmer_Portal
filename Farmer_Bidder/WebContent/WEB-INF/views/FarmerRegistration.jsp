<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="false" %>

<html>
<head>
	<title>Person Page</title>


</head>
<body>
<h1>
Registration for farmer.
</h1>
<%-- <c:url var="registerAction" value="/farmer/add" ></c:url> --%>
<form:form action="add" 
	modelAttribute="farmer">
	<c:if test="${!empty farmer.farmerName}"><br/>
		<form:label path="farmerId">
				<spring:message text="Farmer ID"/>
			</form:label>
		<form:input path="farmerId" readonly="true" 
			size="10"  disabled="true" />
			<form:hidden path="farmerId" />
	 </c:if> 
	<br/>
	<br/>
			<form:label path="farmerName">
				<spring:message text=" Name"/>
			</form:label>
	
		 <form:input path="farmerName" />
		 <br/>
	<br/>
		 <form:label path="phoneNumber" type="number">
				<spring:message text="Phone Number" />
			</form:label>
		 <form:input path="phoneNumber" />
		 
		 	  <br/>
	<br/>
		 
			<%-- <form:errors path="name" cssClass="errors"></form:errors> --%>
		<!-- </td> --> 
<br/>
<br/>
<br/>
	<br/>
			<form:label path="login.email">
				<spring:message text="Farmer's email"/>
			</form:label>
	
		 <form:input path="login.email" />

		<form:label path="login.password">
				<spring:message text="Password"/>
			</form:label>
		
		 <form:input path="login.password" type="password" /> 
		 <br/>
	<br/>
			
			<form:label path="bankDetails.ifscCode">
				<spring:message text="IFSC Code"/>
			</form:label>
	
		 <form:input path="bankDetails.ifscCode" />
		
		 	  <br/>
	<br/>
			<form:label path="bankDetails.accountNumber" type="number">
				<spring:message text="Account number"/>
			</form:label>
	
		 <form:input path="bankDetails.accountNumber"  />
			 		 	  <br/>
	<br/>
			<form:label path="address.localAddress">
				<spring:message text="Local Adress"/>
			</form:label>
	
		 <form:input path="address.localAddress"  />
		 
			 	  <br/>
	<br/>
			<form:label path="address.city">
				<spring:message text="City"/>
			</form:label>
	
		 <form:input path="address.city"  />
		 	 	  <br/>
	<br/>
			<form:label path="address.state">
				<spring:message text="State"/>
			</form:label>
	
		 <form:input path="address.state"  />
		 
		 	 	 
		 	 	 	  <br/>
	<br/>
			<form:label path="landDetails.landAddress">
				<spring:message text="Land Address"/>
			</form:label>
	
		 <form:input path="landDetails.landAddress"  />
		
		 	 	 	 	  <br/>
	<br/>
		  <br/>
	<br/>
			<form:label path="landDetails.area" type="number">
				<spring:message text="Area" />
			</form:label>
	
		 <form:input path="landDetails.area"  />
		 <br/>
		 <br/>
			<form:label path="landDetails.landPincode" type="number">
				<spring:message text="Pin code"/>
			</form:label>
	
		 <form:input path="landDetails.landPincode"  />
		 
		
		 
				 	 	 	  <br/>
	<br/>
			<form:label path="documentDetails.aadharNumber">
				<spring:message text="Addhar Card number"/>
			</form:label>
	
		 <form:input path="documentDetails.aadharNumber"  />

		 				 	 	 	  <br/>
	<br/>
			<form:label path="documentDetails.panNumber">
				<spring:message text="Pan number"/>
			</form:label>
	
		 <form:input path="documentDetails.panNumber"  />
		 	 				 	 	 	  <br/>
	<br/>
			<form:label path="documentDetails.certificateNumber">
				<spring:message text="Certificate Number"/>
			</form:label>
	
		 <form:input path="documentDetails.certificateNumber"  />
		 	 	 				 	 	 	  <br/>
	<br/>
			<form:label path="documentDetails.traderLicenseNumber">
				<spring:message text="trader licence number"/>
			</form:label>
	
		 <form:input path="documentDetails.traderLicenseNumber"  />
		 <input type="submit" class="button"
					value= "Submit"/>
			<%-- <c:if test="${!empty farmer.farmerName}">
				
					
			</c:if> --%>
		</form:form>
<br>
<%-- <h3>Persons List</h3>
<c:if test="${!empty listPersons}">
	<table class="tg" border="1">
	<tr>
		<th width="80">Person ID</th>
		<th width="120">Person Name</th>
		<th width="120">Person Country</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listPersons}" var="person">
		<tr>
			<td>${person.id}</td>
			<td>${person.name}</td>
			<td>${person.country}</td>
			<td><a href="
			<c:url value='/edit/${person.id}' />" >Edit</a></td>
			<td><a href="
			<c:url value='/remove/${person.id}' />" >Delete</a>
			</td>
		</tr>
	</c:forEach>
	</table> 
</c:if>--%>
</body>
</html>