package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("user_name");
		String password = req.getParameter("password");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		RequestDispatcher rd;
		
		if("yms".equals(name) && "123".equals(password))
		{
			rd=req.getRequestDispatcher("/mainpage.html");
			rd.forward(req,resp);
		}else {
			out.println("<font color=red>Invalid Email or Password</font>");
			rd=req.getRequestDispatcher("/index.html");
			rd.include(req, resp);
			
		}
		
	}
	
	
	
	

}
