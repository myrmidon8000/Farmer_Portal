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
<h3>Crop List</h3>
<c:if test="${!empty CropList}">
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
	<c:forEach items="${CropList}" var="crop">
		<tr>
			<td>${crop.cropId}</td>
			<td>${crop.farmerId}</td>
			<td>${crop.cropName}</td>
			<td>${crop.cropType}</td>
			<td>${crop.fertilizerType}</td>
			<td>${crop.quantity}</td>
			<td>${crop.baseAmount}</td>
			<td>${crop.phCertificate}</td>
			<td>${crop.requestStatus}</td>										
		</tr>
	</c:forEach>
	</table>
</c:if>

</body>
</html>