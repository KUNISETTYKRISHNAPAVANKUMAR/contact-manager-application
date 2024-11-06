package com.servlet;

import java.io.IOException;

import com.dao.ContactDaoImp;
import com.dao.UserDaoImp;
import com.model.Contact;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/createContact")
public class CreateContactServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contact contact=new Contact();
		contact.setEmail(req.getParameter("address"));
		contact.setName(req.getParameter("name"));
		contact.setAbout(req.getParameter("about"));
		contact.setPhone(req.getParameter("phone"));
		HttpSession session=req.getSession(false);
		User user=(User)session.getAttribute("user");
		contact.setUserId(user.getId());
		ContactDaoImp udi=new ContactDaoImp();
		if(udi.create(contact))
		resp.sendRedirect("createContact.jsp?success=1");
		else
			resp.sendRedirect("createContact.jsp?error=1");
	}
}
