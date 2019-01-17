<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.lti.model.Farmer" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=session.getAttribute("farmerId") %>
<%=session.getAttribute("farmername") %>

<br><br>
<a href="signout">Signout</a>


<a href="sellcrop">Sell Your Crop here</a>
<a href="cropstatus">Sell Crop Status</a>
<a href="profile">Profile</a>
<a href="bidstatus">View Your Crop Bids</a>
<%-- <a href="<c:url value='/cropstatus/${farmer.farmerId}' />" >View Crop Status</a> --%>
</body>
</html>