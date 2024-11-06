package com.servlet;

import java.io.IOException;

import com.dao.ContactDaoImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteContact")
public class DeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("cid"));
		ContactDaoImp cdi=new ContactDaoImp();
		if(cdi.deleteContact(id)) {
			resp.sendRedirect("viewContact");
		}
		else {
			resp.sendRedirect("viewContact.jsp?deleteError=1");
		}
	}
}
