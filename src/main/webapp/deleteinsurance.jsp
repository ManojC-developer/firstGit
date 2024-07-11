<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="adminstyle.css">
</head>
<body>
<div class="container">
<h1>DELETE DATA</h1>
    <form action="deleteleadservlet" method="post">
        USERNAME: <input type="text" name="username"><br>
        <input type="submit" value="Delete">
    </form>
    
</div>
</body>
</html>