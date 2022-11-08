
package com.servlets;
import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	@WebServlet("/DeleteServlet")
	public class DeleteServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
			String sid=request.getParameter("bill_no");
			int bill_no=Integer.parseInt(sid);
			EmpDao.delete(bill_no);

			}catch(Exception abc){
				
			abc.printStackTrace();	
			}
		
			response.sendRedirect("ViewServlet");
			
		}
	}