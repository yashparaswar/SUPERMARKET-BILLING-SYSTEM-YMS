package com.servlets;

import javax.servlet.http.HttpServlet;
import java.io.IOException;


	import javax.servlet.ServletException;

	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	public class thirdservlet  extends HttpServlet{

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			  req.getRequestDispatcher("customersupport.html").forward(req, resp);
	          return;
	

}
	}
