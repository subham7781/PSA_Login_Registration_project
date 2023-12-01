<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<h2>Login</h2>
	<form action="verifyLogin" method="post">
		Username<input type="text" name="email" /><br><br /> 
		password<input type="password" name="password" /><br><br />
		 <input type="submit" value="Login" />
	</form>
	<%
	if(request.getAttribute("msg")!=null) {
		out.println(request.getAttribute("msg"));
	}  
	%>
</body>
</html>