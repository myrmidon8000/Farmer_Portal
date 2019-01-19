<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Status</title>
</head>
<body>
<h3>Farmer Profile</h3>
<c:if test="${!empty farmer}">
	<table class="tg" border="1">
	<tr>
		<th width="50">Crop ID</th>
		<th width="50">Farmer ID</th>
		<th width="50">Crop Name</th>
		<th width="50">Crop Type</th>
		<th width="50">Fertilizer Type</th>
		<th width="50">Quantity</th>
		<th width="50">Base Amount</th>
		<th width="50">Ph Certificate</th>
		<th width="50">Request Status</th>
	</tr>
		<tr>
			<td>${farmer.farmerId}</td>
			<td>${farmer.farmerName}</td>
			<td>${farmer.phoneNumber}</td>
			<td>${farmer.email}</td>
			<td>${farmer.password}</td>
			<td>${farmer.bankDetails}</td>
			<td>${farmer.address}</td>
			<td>${farmer.landDetails}</td>
			<td>${farmer.documentDetails}</td>										
		</tr>
	</table>
</c:if>
<a href="farmerhome">Home</a>
</body>
</html>