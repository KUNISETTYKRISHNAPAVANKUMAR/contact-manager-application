<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="components/form.css" rel="stylesheet">
<%@include file="components/links.jsp" %>
</head>
<body>
<%@include file="components/navbar.jsp" %>
<div class="form-con">
<h1 class="heading">Register</h1>
<form class="container" action="register" method="post">
   <input type="text" class="field" name="name" placeholder="Enter Your Name"/>
   <input type="text" class="field" name="email" placeholder="Enter Your Mail"/>
   <input type="password" class="field" name="password" placeholder="Enter Your Password">
   <%
   if("1".equals(request.getParameter("success"))){
   %>
   <p>Registration Successful</p>
   <%} %>
   <%
   if("1".equals(request.getParameter("error"))){
   %>
   <p>Registration UnSuccessful</p>
   <%} %>
   <button type="submit" class="submit">Register</button>
</form>
</div>
</body>
</html>