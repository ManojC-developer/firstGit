<%@page import="mypackage.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Confirmation</title>
<link rel="stylesheet" type="text/css" href="adminstyle.css">
</head>
<body>
<% UserService userService = (UserService) session.getAttribute("service");

%>
  
    <div class="container">
        <h1>Payment Confirmation</h1>
        <p>Payment successful! You have opted for the following insurance:</p>
        <p><strong>Insurance ID:</strong> <%= userService.getInsuranceid() %></p>
        <p><strong>Insurance Name:</strong> <%= userService.getInsurancename() %></p>
        <p><strong>Coverage:</strong> <%= userService.getCoverage()%></p>
        <p><strong>Amount Paid:</strong> <%=request.getParameter("paymentAmount") %></p>
        
    </div>
</body>
</html>