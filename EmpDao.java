
package com.servlets;


import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;  
  
 
public class EmpDao extends HttpServlet {  
	private static final String INSERT_QUERY="insert into g_bill(bill_no,product_id,product_name,quantity,price,total_price,name,phone_no) values(?,?,?,?,?,?,?,?)";    
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
	
	
	  String bill_no=request.getParameter("bill_no");  
      String product_id=request.getParameter("product_id");  
      String product_name=request.getParameter("product_name");  
      String price=request.getParameter("price");  
      String total_price=request.getParameter("total_price");  
      String quantity=request.getParameter("quantity");  
      String name=request.getParameter("name");  
      String phone_no=request.getParameter("phone_no");  
	resp.setContentType("text/html");
	
	PrintWriter out = resp.getWriter();
	out.println("<h1>BILL</h1>");
	 out.println("<a href='main.html'>Add products</a>");
	out.print("<table border='1' width='100%'");  
	out.print("<tr><th>Bill No</th><th>Product ID</th><th>Product Name</th><th>Quantity</th><th>Price</th><th>Total Price</th><th>Name</th><th>Phone No</th><th>Edit</th><th>Delete</th></tr>");  
	out.print("<tr><td>"+bill_no+"</td><td>"+product_id+"</td><td>"+product_name+"</td><td>"+quantity+"</td><td>"+price+"</td><td>"+total_price+"</td><td>"+name+"</td><td>"+phone_no+"</td><td><a href='EditServlet?bill_no="+bill_no+"'>edit</a></td>  <td><a href='DeleteServlet?bill_no="+bill_no+"'>delete</a></td></tr>");  
//	out.println("<h3>Bill No:"+bill_no+"</h3>");
//	out.println("<h3>Product ID:"+product_id+"</h3>");
//	out.println("<h3>Product Name:"+product_name+"</h3>");
//	out.println("<h3>Quantity:"+quantity+"</h3>");
//	out.println("<h3>Price:"+price+"</h3>");
//	out.println("<h3>Total Price:"+total_price+"</h3>");
//	out.println("<h3>Name:"+name+"</h3>");
//	out.println("<h3>Phone No:"+phone_no+"</h3>");
	 out.print("</table>");  
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try(Connection con= DriverManager.getConnection("jdbc:mysql:///final","root","Anuja@123");
			PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
		    ps.setString(1,bill_no);  
	        ps.setString(2,product_id);  
	        ps.setString(3,product_name);  
	        ps.setString(4,quantity);  
	        ps.setString(5,price);  
	        ps.setString(6,total_price);  
	        ps.setString(7,name);  
	        ps.setString(8,phone_no);  
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

		
		
	
	
  public static Connection getConnection(){  
      Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql:///final","root","Anuja@123");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }
   public static int save(Emp e){  
        int status=0;  
      try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into g_bill(bill_no,product_id,product_name,quantity,price,total_price,name,phone_no) values(?,?,?,?,?,?,?,?)");  
            ps.setString(1,e.getbill_no());  
            ps.setString(2,e.getproduct_id());  
            ps.setString(3,e.getproduct_name());  
            ps.setString(4,e.getquantity());  
            ps.setString(5,e.getprice());  
            ps.setString(6,e.gettotal_price());  
            ps.setString(7,e.getname());  
            ps.setString(8,e.getphone_no());  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Emp e){  
       int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update g_bill set bill_no=?,product_id=?,product_name=?,quantity=?,price=?,total_price=?,name=?,phone_no=? where bill_no=?");  
            ps.setString(1,e.getbill_no());  
            ps.setString(2,e.getproduct_id());  
            ps.setString(3,e.getproduct_name());  
            ps.setString(4,e.getquantity());  
            ps.setString(5,e.getprice());  
            ps.setString(6,e.gettotal_price());  
            ps.setString(7,e.getname());  
            ps.setString(8,e.getphone_no());  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int bill_no){  
        int status=0;  
        try{  
           Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from g_bill where bill_no=?");  
            ps.setInt(1,bill_no);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
   }  
  public static Emp getEmployeeById(int bill_no){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from g_bill where bill_no=?");  
            ps.setInt(1,bill_no);  
          ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
           	  ps.setString(1,e.getbill_no());  
                  ps.setString(2,e.getproduct_id());  
                  ps.setString(3,e.getproduct_name());  
                  ps.setString(4,e.getquantity());  
                  ps.setString(5,e.getprice());  
                  ps.setString(6,e.gettotal_price());  
               
                  ps.setString(7,e.getname());  
                 ps.setString(8,e.getphone_no());  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from g_bill");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                ps.setString(1,e.getbill_no());  
                ps.setString(2,e.getproduct_id());  
                ps.setString(3,e.getproduct_name());  
                ps.setString(4,e.getquantity());  
                ps.setString(5,e.getprice());  
                ps.setString(6,e.gettotal_price());  
                ps.setString(7,e.getname());  
                ps.setString(8,e.getphone_no());  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  


