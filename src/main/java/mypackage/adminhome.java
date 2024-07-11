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


@WebServlet("/adminhome")
public class adminhome extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String action = request.getParameter("action");
		
		try(PrintWriter out = response.getWriter())	{
			
			response.setContentType("text/html");
			
			if(action.equals("view")) {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "manu123");
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from UserRegister");
			
			out.println("<h2>View data</h2>");
			out.println("<table border='1'text-align:'center'>");
			out.println("<tr><th>USERNAME</th><th>INSURANCEID</th><th>INSURANCENAME</th><th>COVERAGE</th><th>USERMAILID</th><th>USERPASSWORD</th></tr>");
			
		
		while(rs.next()) {
			String nuser = rs.getString("UserName");
			String iid = rs.getString("InsuranceId");
			String iname = rs.getString("Insurancename");
			String cov = rs.getString("Coverage");
			String uid = rs.getString("UserId");
			String upass = rs.getString("Password");
			
			
			out.println("<tr><td>"+nuser+"</td><td>"+iid+"</td><td>"+iname+"</td><td>"+cov+"</td><td>"+uid+"</td><td>"+upass+"</td></tr>");
			
		}
		out.println("</table>");
	}
			
			else if(action.equals("update")) {
				
				
				javax.servlet.RequestDispatcher Rd=request.getRequestDispatcher("updateinsurance.jsp");
				Rd.forward(request, response);
				
				
			}
			
			
			else if(action.equals("delete")) {
				
				
				javax.servlet.RequestDispatcher Rd=request.getRequestDispatcher("deleteinsurance.jsp");
				Rd.forward(request, response);
				
				
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