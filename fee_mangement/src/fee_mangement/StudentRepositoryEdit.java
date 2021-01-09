package fee_mangement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.DBUtil;

public class StudentRepositoryEdit {
	
public Student getStudent(String studRoll) {
		
		Connection con =DBUtil.getMySqlDbConnection();
		String sql="select * from accountant where stud_roll=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, studRoll);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				String studName=rs.getString("stud_name");
				String studGender=rs.getString("stud_gender");
				String studContact=rs.getString("stud_contact");
				String studEmail=rs.getString("stud_email");
				String studCourse=rs.getString("stud_course");
				int studTotalFee=rs.getInt("stud_totalFee");
				int studPaidFee=rs.getInt("stud_paidFee");
				int studDueFee=rs.getInt("stud_dueFee");
				
				student= new Student(studName,studRoll,studGender,studContact,studEmail,studCourse,studTotalFee,studPaidFee,studDueFee);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return student;
	}

	public void updateStudent(Student student) {
		Connection con= DBUtil.getMySqlDbConnection();
		String sql = "update student set stud_name=?, stud_gender=?, stud_contact=?, stud_email=?, stud_course=?, stud_totalfee=?, stud_paidfee=?, stud_duefee=? where stud_roll=?";
		try {
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, student.getStudName());
			pst.setString(2, student.getStudGender());
			pst.setString(3, student.getStudContact());
			pst.setString(4, student.getStudEmail());
			pst.setString(5, student.getStudCourse());
			pst.setString(6, student.getStudTotalFee());
			pst.setString(7, student.getStudPaidFee());
			pst.setString(8, student.getStudDueFee());
			pst.setString(9, student.getStudRoll());
			
			int result=pst.executeUpdate();
			if(result==0) {
				System.out.println("Updation Failed");
			}else {
				System.out.println("updated Successfully");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


}
