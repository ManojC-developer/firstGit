package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/checkInsurance")
public class checkInsurance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		      
try(PrintWriter out = response.getWriter())	{
			
		response.setContentType("text/html");
		
		String userid = request.getParameter("mail");
		
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        session.setAttribute("userId", userid);
        
        boolean hasInsurance = false;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "manu123");
		Statement st1=con1.createStatement();
		
		String updateSql1 = "SELECT Insurancename FROM UserRegister WHERE UserId = ?";
        PreparedStatement statement1 = con1.prepareStatement(updateSql1); 
        statement1.setString(1, userid);
        
        ResultSet executeQuery1 = statement1.executeQuery();
        
        if (executeQuery1.next()) {
            String insuranceName = executeQuery1.getString("Insurancename");
            
            if (insuranceName != null && !insuranceName.isEmpty()) {
                hasInsurance = true;
            }
        }
    
        
       
            
			
        if (hasInsurance) {	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "manu123");
		Statement st=con.createStatement();
		
		String updateSql = "SELECT * FROM UserRegister WHERE userid = ?";
        PreparedStatement statement = con.prepareStatement(updateSql); 
        statement.setString(1, userid);
        
        ResultSet executeQuery = statement.executeQuery();
        
        HttpSession session2 = request.getSession();
        session2.setAttribute("userId", userid);
        
        if (executeQuery.next()) {
            
             
            
            out.println("<h2>View data</h2>");
			out.println("<table border='1'text-align:'center'>");
			out.println("<tr><th>USERNAME</th><th>INSURANCEID</th><th>INSURANCENAME</th><th>COVERAGE</th><th>USERMAILID</th><th>USERPASSWORD</th></tr>");
			
		
		
			String nuser = executeQuery.getString("UserName");
			String iid = executeQuery.getString("InsuranceId");
			String iname = executeQuery.getString("Insurancename");
			String cov = executeQuery.getString("Coverage");
			String uid = executeQuery.getString("UserId");
			String upass = executeQuery.getString("Password");
			
			
			out.println("<tr><td>"+nuser+"</td><td>"+iid+"</td><td>"+iname+"</td><td>"+cov+"</td><td>"+uid+"</td><td>"+upass+"</td></tr>");
			
		
		out.println("</table>");
            
            
        } 

         
        } 
        
else {
	javax.servlet.RequestDispatcher Rd=request.getRequestDispatcher("userhome.html");
	Rd.forward(request, response);
            
            
        }
        
        
        } catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} 
}

	}


