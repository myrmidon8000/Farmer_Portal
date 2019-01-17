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
<form:form action="setpassword" 
	modelAttribute="farmer" method="POST">
	
	<form:label path="password">
				<spring:message text=" Enter Password"/>
			</form:label>
	
		 <form:input path="password" />
		 <br/>
	<br/>
		
	<input type="submit" class="button"
					value= "SetPassword"/>
	
	</form:form>

</body>
</html>