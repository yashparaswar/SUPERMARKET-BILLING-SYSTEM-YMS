package com.servlets;


import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<Emp> list=EmpDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
       
        out.print("<tr><th>Bill No</th><th>Product ID</th><th>Product Name</th><th>Quantity</th><th>Price</th><th>Total Price</th><th>Name</th><th>Phone No</th><th>Edit</th><th>Delete</th></tr>");  
        for(Emp e:list){ 
        out.print("<tr><td>"+e.getbill_no()+"</td><td>"+e.getproduct_id()+"</td><td>"+e.getproduct_name()+"</td><td>"+e.getquantity()+"</td><td>"+e.getprice()+"</td><td>"+e.gettotal_price()+"</td><td>"+e.getname()+"</td><td>"+e.getphone_no()+"</td><td><a href='EditServlet?id="+e.getbill_no()+"'>edit</a></td>  <td><a href='DeleteServlet?id="+e.getbill_no()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  