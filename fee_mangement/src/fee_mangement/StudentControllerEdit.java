package fee_mangement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentControllerEdit {
	
public  void doGet(HttpServletRequest request,HttpServletResponse response) {
		
	//get Student Controller	
	
	String requestAction=request.getParameter("requestAction");
		  
		if(requestAction.equalsIgnoreCase("edit")) {
			String studRoll=request.getParameter("studRoll");
			
			StudentRepository sr= new StudentRepository();
			Student student=sr.getStudent(studRoll);
			
			RequestDispatcher rd= request.getRequestDispatcher("EditStudent.jsp");
			request.setAttribute("student", student);
			
			try {
				rd.forward(request, response);
				
				}catch(Exception e) {
					System.out.println("Exception Occured:" + e);
				}
		}
		// update controller
		else if(requestAction.equalsIgnoreCase("update")) {
			String studName= request.getParameter("studName");
			int studRoll= Integer.parseInt(request.getParameter("studRoll"));
			String studGender= request.getParameter("studGender");
			String studContact= request.getParameter("studContact");
			String studEmail= request.getParameter("studEmail");
			String studCourse= request.getParameter("studCourse");
			int studTotalFee= Integer.parseInt(request.getParameter("studTotalFee"));
			int studPaidFee= Integer.parseInt(request.getParameter("studPaidFee"));
			//int studDueFee= Integer.parseInt(request.getParameter("studDueFee"));
			
			int studDueFee=studTotalFee-studPaidFee;
			
			StudentRepository sr=new StudentRepository();
			Student student=new Student(studName,studRoll,studGender,studContact,studEmail,studCourse,studTotalFee,studPaidFee,studDueFee);
			sr.updateEmployee(student);
			
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}
