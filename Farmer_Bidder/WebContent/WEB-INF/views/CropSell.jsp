<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="false" %>

<html>
<head>
	<title>Sell Your Crops</title>


</head>
<body>
<h1>
Sell Your Crops Here
</h1>
<form:form action="sellcropprocess" 
	modelAttribute="potentialcrop" method="POST">
	<c:if test="${!empty potentialcrop.cropName}"><br/>
		<form:label path="cropId">
				<spring:message text="Crop ID"/>
			</form:label>
		<form:input path="cropId" readonly="true" 
			size="10"  disabled="true" />
			<form:hidden path="cropId" />
			
	<form:label path="requestStatus">
				<spring:message text="Crop Status"/>
			</form:label>
		<form:input path="requestStatus" value="PENDING" 
			size="10"  />
			<form:hidden path="requestStatus" />
	 </c:if> 
	 <br>
	<form:label path="cropType">
				<spring:message text=" Crop Type"/>
			</form:label>
	
		 <form:input path="cropType" />
		 <br/>
	<br/>
		 <form:label path="cropName" >
				<spring:message text="Crop Name" />
			</form:label>
		 <form:input path="cropName" />	 
		 	  <br/>
	<br/>
	 <form:label path="fertilizerType" >
				<spring:message text="Fertilizer Type" />
			</form:label>
		 <form:input path="fertilizerType" />	 
		 	  <br/>
	<br/>
	 <form:label path="quantity" >
				<spring:message text="Quantity" />
			</form:label>
			<form:input path="quantity" type="number"/>	 
			 <br/>
	<br/>
	
			 <form:label path="phCertificate">
			 <spring:message text="Soil phCertificate Number" />
			</form:label>
		 <form:input path="phCertificate" />	 
		 	  <br/>
	<br/>
	
	<input type="submit" class="button"
					value= "Submit"/>
	
	</form:form>
<br>
	</body>
</html>