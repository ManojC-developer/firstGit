<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Page</title>
<link rel="stylesheet" type="text/css" href="adminstyle.css">
</head>
<body>
	<div class="container">
        <h1>Payment</h1>
        <p>Please enter the amount to proceed with the payment:</p>
        <form action="ProcessPaymentServlet" method="post">
            <label for="paymentAmount">Amount:</label>
            <input type="text" id="paymentAmount" name="paymentAmount"><br>
            <input type="hidden" name="insuranceId" value="${insuranceId}">
            <input type="hidden" name="insuranceName" value="${insuranceName}">
            <input type="hidden" name="coverage" value="${coverage}">
            <input type="hidden" name="amount" value="${amount}">
            <input type="submit" value="Pay">
        </form>
    </div>

</body>
</html>