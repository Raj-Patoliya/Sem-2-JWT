<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<%@ include file="Header.jsp" %>
<div class="container">
<%
	if(request.getAttribute("error") != null)
	{			
		out.print("<div class='alert alert-danger' role='alert'>");
		out.print("Invalid login credentials");
		out.print("</div>");
		request.removeAttribute("error");
	}
%>
<div class="forn-control">
<form action="/Question_8" method="post">
	<input type="text" name="username" class="form-control" placeholder="Username">
	<br>
	<input type="password" name="password" class="form-control" placeholder="Password">
	<br>
	<input type="submit" name="submit" class="btn btn-success" value="Submit">
</form>
</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>