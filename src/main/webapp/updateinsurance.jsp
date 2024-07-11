<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>updateInsurance</title>
<link rel="stylesheet" type="text/css" href="adminstyle.css">
</head>
<body>
<div class="container">
<h1>UPDATE DATA</h1>
    
    <form action="updateleadservlet" method="post">
        Username: <input type="text" name="username"><br>
        Field to Update:
        <select name="fieldToUpdate">
            <option value="InsuranceId">InsuranceId</option>
            <option value="Insurancename">InsuranceName</option>
            <option value="Coverage">Coverage</option>
            <option value="UserId">UserMailId</option>
            <option value="Password">UserPassword</option>
            
            
        </select><br>
        New Value: <input type="text" name="newValue"><br>
        <input type="submit" value="Update">
    </form>
</div>
</body>
</html>