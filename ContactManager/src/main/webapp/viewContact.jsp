<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Contact"%>
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
<%@include file="components/protectedNav.jsp" %>
      <%
            HttpSession session2=request.getSession(false);
            if(session2!=null && session2.getAttribute("contacts")!=null){
            	Object cObject=session2.getAttribute("contacts");
            	ArrayList<Contact>list=(ArrayList<Contact>)cObject;
            	if(list.size()>0){
      %>
      <div class="contact-con">
      <%
                for(Contact contact:list){
                	
      %>
            <div class="contact-card">
                 <h4><%=contact.getName() %></h4>
                 <h5><%=contact.getPhone() %></h5>
                 <div >
                       <a href="editContact.jsp?cid=<%=contact.getId() %>" class="contact-bts">Edit</a>
                       <a href="deleteContact?cid=<%=contact.getId() %>" class="contact-bts">Delete</a>
                 </div>
            </div>
     
      <%}%>
       </div>
       <%
          }
            	else{
            %>
            <h1>There are No Contacts</h1>
        <%
            }
          }
            else{
            	response.sendRedirect("Login.jsp");
            }
            response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
        %>
</body>
</html>