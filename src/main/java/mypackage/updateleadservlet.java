package mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateleadservlet")
public class updateleadservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try(PrintWriter out = response.getWriter())	{
			
			response.setContentType("text/html");
			
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "manu123");
		Statement st=con.createStatement();
		
		
        String username = request.getParameter("username");
        String fieldToUpdate = request.getParameter("fieldToUpdate");
        String newValue = request.getParameter("newValue");
        
        String updateSql = "UPDATE UserRegister SET " + fieldToUpdate + " = ? WHERE username = ?";
        PreparedStatement statement = con.prepareStatement(updateSql);
        statement.setString(1, newValue);
        statement.setString(2, username);
        
        
        int rowsUpdated = statement.executeUpdate();
        
        
        if (rowsUpdated > 0) {
        	
        	out.println("DATA UPDATED SUCESSFULLY");
        	javax.servlet.RequestDispatcher Rd=request.getRequestDispatcher("adminhome.html");
			Rd.include(request, response);
            
        } else {
            
            out.println("No user found with the provided username.");
        }
		
		
} catch (ClassNotFoundException e) {
	
	e.printStackTrace();
} catch (SQLException e) {
	
	e.printStackTrace();
}
		

	}
	


}
