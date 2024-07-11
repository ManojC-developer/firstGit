package mypackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/paymentcalculationservlet")
public class paymentcalculationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String insuranceId = request.getParameter("insuranceId");
        String insuranceName = "";
        String coverage = "";
        double amount = 0;
        
        
        
        switch (insuranceId) {
            case "1":
            	insuranceName = "Health Plus";
                coverage = "Basic medical expenses coverage";
                amount = 2000;
                break;
            case "2":
            	insuranceName = "LifeGuard";
                coverage = "Life insurance coverage with critical illness benefits";
                amount = 3000;
                break;
            case "3":
            	insuranceName = "SecureCare";
                coverage = "Comprehensive health insurance for individuals and families";
                amount = 4000;
                break;
            case "4":
            	insuranceName = "Accident Shield";
                coverage = "Accident insurance covering medical expenses and disability benefits";
                amount = 1500;
                break;
            case "5":
            	insuranceName = "SeniorCare";
                coverage = "Specialized health insurance tailored for senior citizens";
                amount = 5000;
                break;
            case "6":
            	insuranceName = "DentalGuard";
                coverage = "Dental insurance covering routine check-ups, cleanings, and major dental procedures";
                amount = 2500;
                break;
            
        }
        
        System.out.println(insuranceName);
        System.out.println(coverage);
        System.out.println(amount);
        System.out.println(insuranceId);
        
        
       
        request.setAttribute("insuranceId", insuranceId);
        request.setAttribute("insuranceName", insuranceName);
        request.setAttribute("coverage", coverage);
        request.setAttribute("amount", amount);
        
        
        HttpSession session = request.getSession(true);
        session.setAttribute("service", new UserService(insuranceId,insuranceName,coverage));
        
        javax.servlet.RequestDispatcher Rd=request.getRequestDispatcher("PaymentPage.jsp");
		Rd.forward(request, response);
        
	}

}
