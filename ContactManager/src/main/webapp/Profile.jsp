<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="components/form.css" rel="stylesheet">
<%@include file="components/links.jsp" %>
</head>
<body>
   <%
        HttpSession session2=request.getSession(false);
        if(session2!=null&&session2.getAttribute("email")!=null){
        	User user=(User)session2.getAttribute("user");
    %>
    <%@include file="components/protectedNav.jsp" %>
    <div class="profile-details-con">
     <h1>WELCOME <%= user.getName()%></h1>
     <div class="details-card">
          <h1>Your Details</h1>
          <div>
               <h4>ID : </h4><p><%= user.getId()%></p>
               <h4>Mail : </h4><p><%= user.getEmail()%></p>
               <h4>Username : </h4><p><%= user.getName()%></p>
               <h4>Password : </h4><p><%= user.getPassword()%></p>
               
          </div>
     </div>
    </div>
<%
response.setHeader("cache-control", "no-cache,no-store,must-revalidate");

}
else{
	response.sendRedirect("Login.jsp");

}
%>
</body>
</html>