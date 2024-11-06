package com.servlet;

import java.io.IOException;

import com.dao.UserDaoImp;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		UserDaoImp udi=new UserDaoImp();
		User user=udi.login(email, password);
		if(user!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			session.setAttribute("email", email);
			resp.sendRedirect("Profile.jsp");
		}
		else {
			resp.sendRedirect("Login.jsp?error=1");
		}
	}
}
