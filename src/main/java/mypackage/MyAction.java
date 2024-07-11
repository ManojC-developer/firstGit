package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jakarta.servlet.RequestDispatcher;


@WebServlet("/MyAction")
public class MyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter out = response.getWriter())	{
			
			response.setContentType("text/html");
			
			
			String user = request.getParameter("mail");
			String pass = request.getParameter("password");
			
			if("admin@gmail.com".equals(user) && "admin123".equals(pass)) {
				out.println("welcome admin ");
				
				
				javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("adminhome.html");
				rd.forward(request, response);
				
			}

				
				
			
			else {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "manu123");
				Statement st=con.createStatement();
				
				ResultSet rs=st.executeQuery("select * from UserRegister");
			
			int flag=0;
			while(rs.next()) {
				String duser = rs.getString("UserId");
				String dpass = rs.getString("Password");
				String dname = rs.getString("UserName");
				
				if(user.equals(duser) && pass.equals(dpass)) {
					out.println("<h1 Style='text-align':center; >welcome  "+ dname+"</h1>");
					flag=1;
					 
					javax.servlet.RequestDispatcher Rd=request.getRequestDispatcher("checkInsurance");
					Rd.include(request, response);
				
			flag=1;
					
				}
			}
			
			if(flag==0) {
				out.println("sorry username password is incorect");
				
				javax.servlet.RequestDispatcher Rd=request.getRequestDispatcher("index.html");
				Rd.forward(request, response);
				
			}
				
				
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {	
			e.printStackTrace();
		}
			
			
	}
	}

