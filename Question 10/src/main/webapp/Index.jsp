<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% ResultSet rs = (ResultSet) request.getAttribute("rs");
	while(rs.next())
	{
		out.print("<h1>" + rs.getInt("id")+"<br>");
		out.print(rs.getString("name")+"<br>");
		out.print(rs.getString("gender")+"<br>");
		out.print(rs.getString("username")+"<br>");
		out.print(rs.getString("password")+"<br></h1>");
	}

%>
<br>
</body>
</html>