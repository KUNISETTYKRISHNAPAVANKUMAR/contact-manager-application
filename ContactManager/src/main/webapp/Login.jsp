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
<%HttpSession session2=request.getSession(false);
if(session2!=null && session2.getAttribute("email")!=null)
	response.sendRedirect("Profile.jsp");
%>
<%@include file="components/navbar.jsp" %>
<div class="form-con">
<h1 class="heading">Login</h1>
<form class="container" action="login" method="post">
   <input type="text" class="field" name="email" placeholder="Enter Your Mail"/>
   <input type="password" class="field" name="password" placeholder="Enter Your Password">
   <button type="submit" class="submit">Login</button>
   <%
   if("1".equals(request.getParameter("error"))){
   %>
   <p>Invalid Credentials</p>
   <%} %>
</form>
</div>
</body>
</html>