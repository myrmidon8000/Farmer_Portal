<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" 
prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" 
prefix="form" %>
<%@ page session="true" %>

<html>
<head>
	<title>Login</title>


</head>
<body>
<h1>
Login for farmer.
</h1>
<form:form action="adminloginprocess" 
	modelAttribute="admin" method="POST">
	
	<form:label path="adminUserName">
				<spring:message text=" Enter Email"/>
			</form:label>
	
		 <form:input path="adminUserName" />
		 <br/>
	<br/>
		 <form:label path="adminPassword" >
				<spring:message text="Enter Password" />
			</form:label>
		 <form:input path="adminPassword" type="password" />
		 
		 	  <br/>
	<br/>
	<input type="submit" class="button"
					value= "Submit"/>
	
	</form:form>
<br>
	</body>
</html>