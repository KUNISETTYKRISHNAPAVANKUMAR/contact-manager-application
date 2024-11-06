<%@page import="com.model.Contact"%>
<%@page import="com.dao.ContactDaoImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="components/links.jsp"%>
<link href="components/form.css" rel="stylesheet">
</head>
<body>
      <%HttpSession session2=request.getSession(false);
      if(session2!=null && session2.getAttribute("email")!=null)
      {
       %>
       <%@include file="components/protectedNav.jsp" %>
       <%
             ContactDaoImp cdi=new ContactDaoImp();
             Contact c= cdi.getContact(Integer.parseInt(request.getParameter("cid")));
             if(c!=null){
       %>
       <div class="form-con">
<h1 class="heading">Edit Contact</h1>
<form class="container" action="editContact" method="post">
   <h4 class="form-heading">ID</h4>
   <input type="number" class="field" name="id" value="<%= Integer.parseInt(request.getParameter("cid")) %>" readonly="readonly"/>
   <h4 class="form-heading">Name</h4>
   <input type="text" class="field" name="name" placeholder="Enter name" value="<%= c.getName() %>"/>
   <h4 class="form-heading">Email</h4>
   <input type="text" class="field" name="address" placeholder="Enter Address" value="<%= c.getEmail()%>"/>
   <h4 class="form-heading">Phone</h4>
   <input type="text" class="field" name="phone" placeholder="Enter Phone no" value="<%= c.getPhone()%>"/>
   <h4 class="form-heading">About</h4>
   <textarea class="field" rows="4" name="about" placeholder="Enter some text" ><%= c.getAbout()%></textarea>
   <button type="submit" class="submit">Edit</button>
   <%}
             else{
            	 response.sendRedirect("viewContact.jsp");
             }
       if("1".equals(request.getParameter("success"))){
   %>
   <p>Contact Edited Successfully</p>
   <%}if("1".equals(request.getParameter("error"))){ %>
   <p>Something happened</p>
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