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
import javax.servlet.http.HttpSession;


@WebServlet("/ProcessPaymentServlet")
public class ProcessPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
try(PrintWriter out = response.getWriter())	{
			
			response.setContentType("text/html");
		
			String enteredAmount = request.getParameter("paymentAmount");
	        double calculatedAmount = Double.parseDouble(request.getParameter("amount"));
//	        String insuranceId = request.getParameter("InsuranceId");
//	        String insuranceName = request.getParameter("Insurancename");
//	        String coverage = request.getParameter("Coverage");
	        
	        HttpSession session = request.getSession();
	        String userId = (String) session.getAttribute("userId");
	        
	        HttpSession session2 = request.getSession(false);
			UserService userService = (UserService) session2.getAttribute("service");
			
			String insuranceid2 = userService.getInsuranceid();
			String insurancename2 = userService.getInsurancename();
			String coverage2 = userService.getCoverage();
				
			
			
	        System.out.println("User ID: " + userId);
	        System.out.println("Insurance ID: " + insuranceid2);
	        System.out.println("Insurance Name: " + insurancename2);
	        System.out.println("Coverage: " + coverage2);
	        System.out.println("Entered Amount: " + enteredAmount);
	        System.out.println("Calculated Amount: " + calculatedAmount);
			
	        if (Double.parseDouble(enteredAmount) == calculatedAmount) {
	        	
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	    		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "manu123");
	    		Statement st=con.createStatement();
	        		
	    		 	
	                 String insertSql = "UPDATE UserRegister SET InsuranceId = ?, Insurancename = ?, Coverage = ? WHERE UserId = ? ";
	                 PreparedStatement statement = con.prepareStatement(insertSql);
	                 statement.setString(1, insuranceid2);
	                 statement.setString(2, insurancename2);
	                statement.setString(3, coverage2);
	                statement.setString(4, userId);
	                
	                int rowsInserted = statement.executeUpdate();
	                

	                	
	                	if(rowsInserted>0) {
	                		out.println("payment sucessfull... thank you");
	 	                   
	 	                   javax.servlet.RequestDispatcher Rd=request.getRequestDispatcher("paymentconfirmationpage.jsp");
	 	       			Rd.forward(request, response);
	                		
	                	}
	                	
	                	 else {
	 	                    out.println("Failed to make payment... try again");
	 	                    
	 	                    javax.servlet.RequestDispatcher Rd=request.getRequestDispatcher("PaymentPage.jsp");
	 		       			Rd.include(request, response);
	 	                }
	                	
	                	
	                   
	                   }
	                
	               
	             
	        else {
	        	out.println("please enter the correct amount..");
	        }
	        
			
			
}
catch (ClassNotFoundException e) {
	
	e.printStackTrace();
} catch (SQLException e) {
	
	e.printStackTrace();
}
	}

}

