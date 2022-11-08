package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CS extends HttpServlet {

	private static final String INSERT_QUERY="INSERT INTO CUSTOMER_TABLE(name,email,phone,message) values(?,?,?,?)";  
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("txtName");
	String email = req.getParameter("txtEmail");
	String phone = req.getParameter("txtPhone");
	String message = req.getParameter("txtMsg");
	
	
	resp.setContentType("text/html");
	
	PrintWriter out = resp.getWriter();
	out.println("<h1>DATA</h1>");
	out.println("<h3>Name:"+name+"</h3>");
	out.println("<h3>Email:"+email+"</h3>");
	out.println("<h3>phone:"+phone+"</h3>");
	out.println("<h3>Message:"+message+"</h3>");
	
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try(Connection con= DriverManager.getConnection("jdbc:mysql:///customer","root","Anuja@123");
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
		ps.setString(1,name );
		ps.setString(2,email );
		ps.setString(3,phone );
		ps.setString(4,message );
		
		int  count =ps.executeUpdate();
        if(count==0) {
        	out.println("record not submitted");
        }else
        {
        	out.println("Record stored into Database");
        }
        
	}catch(SQLException se) {
		out.println(se.getMessage());
		se.printStackTrace();
	}catch(Exception e) {
		out.println(e.getMessage());
		e.printStackTrace();
	}
		
		
	}
	
	
	}


	