package com.servlets;



import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
       
        String sid=request.getParameter("bill_no");  
        int bill_no=Integer.parseInt(sid);  
        
        Emp e=EmpDao.getEmployeeById(bill_no);  
      
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td>Bill No</td><td><input type='text' name='bill_no' value='"+e.getbill_no()+"'/></td></tr>");  
        out.print("<tr><td>Product Id</td><td><input type='text' name='product_id value='"+e.getproduct_id()+"'/></td></tr>");  
        out.print("<tr><td>Product Name</td><td><input type='text' name='product_name' value='"+e.getproduct_name()+"'/></td></tr>");  
        out.print("<tr><td>Quantity</td><td><input type='text' name='quantity' value='"+e.getquantity()+"'/></td></tr>");  
        out.print("<tr><td>Price</td><td><input type='text' name='price' value='"+e.getprice()+"'/></td></tr>"); 
        out.print("<tr><td>Total Price</td><td><input type='text' name='total_price' value='"+e.gettotal_price()+"'/></td></tr>"); 
        out.print("<tr><td>Name</td><td><input type='text' name='name' value='"+e.getname()+"'/></td></tr>"); 
        out.print("<tr><td>Phone No</td><td><input type='text' name='phone_no' value='"+e.getphone_no()+"'/></td></tr>"); 
//        out.print("<tr><td>Country:</td><td>");  
//        out.print("<select name='country' style='width:150px'>");  
//        out.print("<option>India</option>");  
//        out.print("<option>USA</option>");  
//        out.print("<option>UK</option>");  
//        out.print("<option>Other</option>");  
//        out.print("</select>");  
//        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
        
    }  
}  