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


@WebServlet("/RegAct")
public class RegAct extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		
		try(PrintWriter out = response.getWriter()){
		String user=request.getParameter("name");	
		String email=request.getParameter("email");
		String psw=request.getParameter("psw");
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "manu123");
		Statement st=con.createStatement();
		
		
		int executeUpdate = st.executeUpdate("insert into UserRegister (UserName,userid,password) values('"+user+"','"+email+"','"+psw+"') ");
		
		if(executeUpdate==1) {
			out.println("Registration Sucessfull");
			javax.servlet.RequestDispatcher Rd=request.getRequestDispatcher("index.html");
			Rd.include(request, response);
			
		}
		else {
			out.println(" Not Registered  Sucessfull");
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
