//package com.servlets;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class register1 extends HttpServlet {
//	
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	  PrintWriter pw =resp.getWriter();
//	  resp.setContentType("text/html");
//	  String bill_no=req.getParameter("bill1");
//	  String dob=req.getParameter("dob");
//	  String name=req.getParameter("name1");
//	  String phone=req.getParameter("txtnumber");
//	  
//	  pw.println("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css\">\r\n"
//	  		+ "\r\n"
//	  		+ "<!-- jQuery library -->\r\n"
//	  		+ "<script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js\"></script>\r\n"
//	  		+ "\r\n"
//	  		+ "<!-- Popper JS -->\r\n"
//	  		+ "<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n"
//	  		+ "\r\n"
//	  		+ "<!-- Latest compiled JavaScript -->\r\n"
//	  		+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>");
//	  
//	  
//	  pw.println("<div style ='width:600px; margin:auto;' >");
//	  pw.println( "<h2>*Bill*</h2>");
//	  pw.println("<table class='table table-hover'>");
//	  pw.println("<tr>");
//	  pw.println("<td> Bill No</td>");
//	  pw.println("<td> "+bill_no+"</td>");
//	  pw.println("<tr>");
//	  
//	  pw.println("<tr>");
//	  pw.println("<td> Date</td>");
//	  pw.println("<td> "+dob+"</td>");
//	  pw.println("<tr>");
//	  
//	  pw.println("<tr>");
//	  pw.println("<td> Name</td>");
//	  pw.println("<td> "+name+"</td>");
//	  pw.println("<tr>");
//	  
//	  pw.println("<tr>");
//	  pw.println("<td> Phone</td>");
//	  pw.println("<td> "+phone+"</td>");
//	  pw.println("<tr>");
//	  
//	  
//	  pw.println("<tr>");
//	  pw.println("<td> <button class =btn btn-outline-success'>Print</button></td>");
//	  pw.println("<tr>");
//	  
//	  
//	  pw.println("<table>");
//	  pw.println("</div>");
////	  pw.println("Bill No:"+bill_no+"<br>");
////	  pw.println("Date:"+dob+"<br>");
////	  pw.println("Name:"+name+"<br>");
////	  pw.println("Phone No:"+phone+"<br>");
//	  pw.close();
//  	  
//		
//		
//		
//		
//	}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//			doGet(req,resp);
//			
//	
//	
//	
//	
//	}
//	
//	
//	
//
//}
