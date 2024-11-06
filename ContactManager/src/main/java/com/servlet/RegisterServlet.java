package com.servlet;

import java.io.IOException;

import com.dao.UserDaoImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		UserDaoImp udi=new UserDaoImp();
	
		if(udi.register(email, name, password)) {
			resp.sendRedirect("Register.jsp?success=1");
		}
		else {
			resp.sendRedirect("Register.jsp?error=1");
		}
	}
}
