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
<title>Insert title here</title>
</head>
<body>
<form:form action="resetpassword" 
	modelAttribute="farmer" method="POST">
	
	<form:label path="email">
				<spring:message text=" Enter Email"/>
			</form:label>
	
		 <form:input path="email" />
		 <br/>
	<br/>
		<form:label path="securityQuestion;">
				<spring:message text="Enter Your Security Phrase"/>
			</form:label>
	
		 <form:input path="securityQuestion;"  />
		 
		 	  <br/>
	<br/>
	<input type="submit" class="button"
					value= "ResetPassword"/>
	
	</form:form>

</body>
</html>