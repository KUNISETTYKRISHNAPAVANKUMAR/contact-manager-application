package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.dao.ContactDaoImp;
import com.model.Contact;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewContact")
public class ViewContactServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ContactDaoImp cdi=new ContactDaoImp();
		HttpSession session=req.getSession(false);
		User user=(User)session.getAttribute("user");
		ArrayList<Contact>list=cdi.getAllContacts(user.getId());
		if(list!=null) {
		session.setAttribute("contacts", list);
		res.sendRedirect("viewContact.jsp");
		}
		else {
			res.sendRedirect("viewContact.jsp?error=1");
		}
		
	}
}
