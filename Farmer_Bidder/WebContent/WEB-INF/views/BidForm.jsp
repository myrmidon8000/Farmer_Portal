<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="true" %>

<html>
<head>
	<title>Bid Form</title>


</head>
<body>
<h1>
Place Your Bid
</h1>
<form:form action="successbidding" 
	modelAttribute="placeBid">

		<form:label path="bidderid">
				<spring:message text="Bidder ID"/>
			</form:label>
			<form:input path="bidderid" /> 
	<br/>
	<br/>
	${placeBid.cropId}
	<br/>
	<br/>
		${placeBid.cropType}
	<br/>
	<br/>
		${placeBid.quantity}
	<br/>
	<br/>
		${placeBid.baseAmount}
	<br/>
	<br/>
		${placeBid.phCertificate}
	<br/>
	<br/>
		${placeBid.bidAmount}
	<br/>
	<br/>
	
			<form:label path="newBid">
				<spring:message text=" Place Your Bid"/>
			</form:label>
		 <form:input path="newBid" />
		 <br/>
	<br/>
		 
		 <input type="submit" class="button"
					value= "Place Bid" role="button"/>
		</form:form>
<br>
</body>
</html>