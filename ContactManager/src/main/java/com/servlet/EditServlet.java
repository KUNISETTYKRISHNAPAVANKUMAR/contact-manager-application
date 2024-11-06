package com.servlet;

import java.io.IOException;

import com.dao.ContactDaoImp;
import com.model.Contact;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editContact")
public class EditServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContactDaoImp cdi=new ContactDaoImp();
		Contact contact=new Contact();
		contact.setAbout(req.getParameter("about"));
		contact.setEmail(req.getParameter("address"));
		contact.setName(req.getParameter("name"));
		contact.setPhone(req.getParameter("phone"));
		contact.setId(Integer.parseInt(req.getParameter("id")));
		if(cdi.editContact(contact)) {
			resp.sendRedirect("editContact.jsp?success=1&cid="+req.getParameter("id"));
		}
		else {
			resp.sendRedirect("editContact.jsp?error=1&cid="+req.getParameter("id"));
		}
	}
}
