<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="true" %>

<html>
<head>
	<title>Person Page</title>


</head>
<body>
<h1>
Registration for Bidder.
</h1>
<%-- <c:url var="registerAction" value="/farmer/add" ></c:url> --%>
<form:form action="bidderadd" 
	modelAttribute="bidder">
	<c:if test="${!empty farmer.farmerName}"><br/>
		<form:label path="bidderId">
				<spring:message text="Bidder ID"/>
			</form:label>
		<form:input path="bidderId" readonly="true" 
			size="10"  disabled="true" />
			<form:hidden path="bidderId" />
	 </c:if> 
	<br/>
	<br/>
			<form:label path="bidderName">
				<spring:message text=" Name"/>
			</form:label>
	
		 <form:input path="bidderName" />
		 <br/>
	<br/>
		 <form:label path="phoneNumber" >
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
			<form:label path="email">
				<spring:message text="Email"/>
			</form:label>
	
		 <form:input path="email" />

		<form:label path="password">
				<spring:message text="Password"/>
			</form:label>
		
		 <form:input path="password" type="password" /> 
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
		</form:form>
<br>
</body>
</html>