
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;


public class ProjectReg implements Servlet 
{
       Connection con;
       Statement stmt;
       PreparedStatement prstmt;
       String s="";
       PrintWriter out=null;
       String n1="";
       String n2="";
       String n3="";
       String n4="";
       String n5="";
       String n6="";
       String n7="";


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "sriram");
			
			stmt=con.createStatement();
			System.out.println("done");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			out.println(e.getMessage());
		}
	}
	
	@Override
	
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		 out=resp.getWriter();
		
		 n1=req.getParameter("name");
		 n2=req.getParameter("age");
		 n3=req.getParameter("gender");
		 n4=req.getParameter("dob");
		 n5=req.getParameter("phno");
		 n6=req.getParameter("hobby");
		 n7=req.getParameter("address");
		
		 try {
			 s="create table em(Name varchar2(15),Age varchar2(2),DOB varchar2(12),gender varchar2(8),phonenumber varchar2(14),Hobbies varchar2(99),address varchar2(200))";
				stmt.executeQuery(s);
				
			prstmt=con.prepareStatement("insert into emp values(?,?,?,?,?,?,?)");
			
			  prstmt.setString(1,n1);
			  prstmt.setString(2,n2);
			  prstmt.setString(3,n3);
			  prstmt.setString(4,n4);
			  prstmt.setString(5,n5);
			  prstmt.setString(6,n6);
			  prstmt.setString(7,n7);
			  
			int j=prstmt.executeUpdate();
			out.println(j+" rows updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
