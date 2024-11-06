<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/links.jsp"%>
<link href="components/form.css" rel="stylesheet"/>
</head>
<body>
<%HttpSession session2=request.getSession(false);
if(session2!=null && session2.getAttribute("email")!=null)
{
%>
<%@include file="components/protectedNav.jsp" %>
<div class="form-con">
<h1 class="heading">Create Contact</h1>
<form class="container" action="createContact" method="post">
   <input type="text" class="field" name="name" placeholder="Enter name"/>
   <input type="text" class="field" name="address" placeholder="Enter Address"/>
   <input type="text" class="field" name="phone" placeholder="Enter Phone no">
   <textarea class="field" rows="4" name="about" placeholder="Enter some text"></textarea>
   <button type="submit" class="submit">Create</button>
   <%
       if("1".equals(request.getParameter("success"))){
   %>
   <p>Contact Created Successfully</p>
   <%}if("1".equals(request.getParameter("error"))){ %>
   <p>Contact Created Successfully</p>
   <%} %>   
</form>
</div>
   <%
   }
else{
	response.sendRedirect("Login.jsp");
}
response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
    %>
</body>
</html>