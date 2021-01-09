package fee_mangement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.EmployeeRepository;
import com.zensar.beans.Employee;

// edit controller

public class EditController {
	
	public  void doGet(HttpServletRequest request,HttpServletResponse response) {
		
		String requestAction=request.getParameter("requestAction");
		
		if(requestAction.equalsIgnoreCase("edit")) {
			String accName=request.getParameter("accName");
			
			AccountantRepository ar= new AccountantRepository();
			Accountant accountant=ar.getAccountant(accName);
			
			RequestDispatcher rd= request.getRequestDispatcher("EditAccountant.jsp");
			request.setAttribute("accountant", accountant);
			
			try {
				rd.forward(request, response);
				
				}catch(Exception e) {
					System.out.println("Exception Occured:" + e);
				}
		}
	}
	
	else if(requestAction.equalsIgnoreCase("update")) {
		int accEmail = Integer.parseInt(request.getParameter("accEmail"));
		String accName = request.getParameter("accName");
		String accPassword = request.getParameter("accPassword");
		String accContact = request.getParameter("accContact");
		
		AccountantRepository ar=new AccountantRepository();
		Accountant accountant=new Accountant(accName, accEmail, accPassword, accContacty);
		ar.updateEmployee(accountant);
		
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
