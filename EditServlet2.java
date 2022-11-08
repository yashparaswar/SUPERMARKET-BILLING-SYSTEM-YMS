package com.servlets;


import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EditServlet2")  
public class EditServlet2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String bill_no=request.getParameter("bill_no");  
        String product_id=request.getParameter("product_id");  
        String product_name=request.getParameter("product_name");  
        String price=request.getParameter("price");  
        String total_price=request.getParameter("total_price");  
        String quantity=request.getParameter("quantity");  
        String name=request.getParameter("name");  
        String phone_no=request.getParameter("phone_no");  
        Emp e=new Emp();  
        e.setbill_no(bill_no);  
        e.setproduct_id(product_id);  
        e.setproduct_name(product_name);  
        e.setquantity(quantity);  
        e.setprice(price);  
        e.settotal_price(total_price);  
        e.setname(name);  
        e.setphone_no(phone_no);  
        int status=EmpDao.update(e);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();  
    }  
  
}  