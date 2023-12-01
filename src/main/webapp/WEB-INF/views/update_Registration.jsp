<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Registration here..</h1>
	<form action="update" method="post">
		<pre>

email<input type="text" name="email" value="<%=request.getAttribute("email")%>"/>
mobil<input type="text" name="mobil" value="<%=request.getAttribute("mobil")%>"/>

<input type="submit" value="update" />
</pre>
	</form>
	<%
	if (request.getAttribute("msg") != null) {
		out.println(request.getAttribute("msg"));
	}
	%>
</body>
</html>