<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
<title>Login Page</title>
</head>
<body>
<div class="container">
	<p>Welcome to Login Page in28minutes</p>
	<pre> ${errorMessage} </pre>
	<form method="post">
		Name: <input type="text" name="name">
		Password: <input type="password" name="password">
		<input type="submit">
	</form>
</div>
<script type="text/javascript" src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>