<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Farmer Registration Page</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Varela+Round" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/grayscale.min.css" rel="stylesheet">
</head>

<body>
<h1> Farmer Registration page</h1>
<section id="Registration1">
<c:url value="/add" var="url" />
	<form:form method="post" action=
"${url}"  modalAttribute="farmer" >

    
        <div class="container">
            <c:if test="${!empty farmer.farmerName}"><br/>
		<form:label path="farmerId">
				<spring:message text="Farmer ID"/>
			</form:label>
		<form:input path="farmerId" readonly="true" 
			size="10"  disabled="true" />
			<form:hidden path="farmerId" />
	</c:if>
      <div class="form-group">
        <h3>Personal information:</h3>
      
		 
        <form:label path="farmerName" >Full Name: </form:label>
        <form:input type="text" class="form-control" id="farmerName" placeholder="Enter fullname" path="farmerName" required=" "  />
        	
		 
        <form:label path="phoneNumber">Phone Number </form:label>
        <form:input type="number" class="form-control" id="phoneNumber" placeholder="Enter phonenumber" path="phoneNumber" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"/>
           <form:label path="login.email" >Email ID: </form:label>
        <form:input type="email" class="form-control" id="email" placeholder="Enter the email id"  path="login.email"/>
        	
          
        </div>
        <div class="form-group">
        <h3>Address details:</h3>
         <form:label path="address.localAddress" >Local Address </form:label>
        <form:textarea class="form-control" id="localAddress" placeholder="Your local Address"  path="address.localAddress"/>
         
         <form:label path="address.city" >City </form:label>
        <form:input type="text" class="form-control" id="city" placeholder=" City"  path="address.city"/>
           <form:label path="address.state" >State </form:label>
        <form:input type="text" class="form-control" id="state" placeholder="State"  path="address.state"/>
        </div>
          <div class="form-group">
          <h3>Land Details:</h3>
           <form:label path="landDetails.area">Area </form:label>
        <form:input type="number" class="form-control" id="area" placeholder="land in acer" path="landDetails.area"/>
          <form:label path="landDetails.landAddress" >Land Address </form:label>
        <form:input type="text" class="form-control" id="landAddress" placeholder="Land Address" path="landDetails.landAddress"/>
        	
          <form:label path="landDetails.landPincode">Land Pincode </form:label>
        <form:input type="number" class="form-control" id="landPincode" placeholder="Pincode" path="landDetails.landPincode"/>
          
          </div>
          
          
          <div class="form-group">
          <h3>Bank Details:</h3>
          <form:label path="bankDetails.accountNumber">Account Number </form:label>
        <form:input type="number" class="form-control" id="accountNumber" placeholder="Account  number" path="bankDetails.accountNumber"/>
                   
         <form:label path="bankDetails.ifscCode" >IFSC code </form:label>
        <form:input type="text" class="form-control" id="ifscCode" placeholder="IFSC code" path="bankDetails.ifscCode"/>
        	
        </div>
          <div class="form-group">
          
          <h3>Documents Details:</h3>
          <form:label path="documentDetails.aadharNumber">Aadhar Number </form:label>
        <form:input type="number" class="form-control" id="aadharNumber" placeholder="Aadhar number" path="documentDetails.aadharNumber"/>
           
              <form:label path="documentDetails.panNumber">Pan Number </form:label>
        <form:input type="number" class="form-control" id="panNumber" placeholder="Pan number" path="documentDetails.panNumber"/>
           
                       <form:label path="documentDetails.certificateNumber">certificate Number </form:label>
        <form:input type="number" class="form-control" id="certificateNumber" placeholder="Certificate number" path="documentDetails.certificateNumber"/>
           <form:label path="documentDetails.traderLicenceNumber">Trader licence </form:label>
        <form:input type="number" class="form-control" id="traderLicenceNumber" placeholder="Trader licence number" path="documentDetails.traderLicenceNumber"/>
              
        
        </div>
        <div class="form-group">
            <h3>Password:</h3>
               <form:label path="login.password" >Password </form:label>
        <form:input type="password" class="form-control" id="password" placeholder="passowrd"  path="login.password"/>
        	
            
        	
      
          <label for="password">Confirm password :</label>
          <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
          </div>
      <a href="index.html" class="btn btn-success" role="button">Submit</a>
      <a href="index.html" class="btn btn-danger" role="button">Cancel</a>

    </div>  
    </form:form>
    </div>
</section>
</body>
</html>