<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All registration</title>
</head>
<body>
	<h1>All Registration</h1>
	<table border="1">
		<tr>
			<th>name</th>
			<th>city</th>
			<th>email</th>
			<th>mobil</th>
			<th>password</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
		ResultSet result = (ResultSet) request.getAttribute("res");
		while(result.next()) {
		%>
		<tr>
			<td><%=result.getString(1)%></td>
			<td><%=result.getString(2)%></td>
			<td><%=result.getString(3)%></td>
			<td><%=result.getString(4)%></td>
			<td><%=result.getString(5)%></td>
			<td><a href="delete?emailID=<%=result.getString(3)%>">Delete</a></td>
			<td><a href="update?emailID=<%=result.getString(3)%>&mobil=<%=result.getString(4)%>">update</a></td>
		</tr>


		<%
		}
		%>

	</table>

</body>
</html>