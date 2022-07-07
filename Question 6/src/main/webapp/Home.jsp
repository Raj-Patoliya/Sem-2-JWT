<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
<%@ include file="Header.jsp" %>
<div class="container">
<%
Cookie ck[] = request.getCookies();
if(ck != null)
{

for(int i = 0;i<ck.length;i++)
{
if(ck[i].getName().equals("error"))
{

out.print("<div class='alert alert-danger' role='alert'>");
out.print("Invalid login credentials");
out.print("</div>");
ck[i].setMaxAge(0);
response.addCookie(ck[i]);
}
}
}
%>
<div class="forn-control">
<form action="Hello" method="post">
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