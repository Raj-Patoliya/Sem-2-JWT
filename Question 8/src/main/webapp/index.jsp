<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file= "Header.jsp" %>
<div class="container">
	<div class="card" style="width: 18rem;">
  <img class="card-img-top" src="https://i.pinimg.com/originals/ea/69/dc/ea69dc6226e72a33f82d3add20b470df.jpg" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">
    Welcome<%=request.getAttribute("username")%> 
</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </div>
</div>
</div>
<%@ include file ="Footer.jsp" %>
</body>
</html>