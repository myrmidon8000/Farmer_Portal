<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="false" %>

<html>
<head>
	<title>Login</title>


</head>
<body>
<h1>
Login for farmer.
</h1>
<form:form action="farmerlogin" 
	modelAttribute="login" method="POST">
	
	<form:label path="email">
				<spring:message text=" Enter Email"/>
			</form:label>
	
		 <form:input path="email" />
		 <br/>
	<br/>
		 <form:label path="password" >
				<spring:message text="Enter Password" />
			</form:label>
		 <form:input path="password" type="password" />
		 
		 	  <br/>
	<br/>
	<input type="submit" class="button"
					value= "Submit"/>
	
	</form:form>
<br>
	</body>
</html>