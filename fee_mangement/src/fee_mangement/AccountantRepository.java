package fee_mangement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utility.DBUtil;

// repository getAccountant and update accountant

public class AccountantRepository {
	
	public Accountant getAccountant(String accName) {
		
		Connection con =DBUtil.getMySqlDbConnection();
		String sql="select * from accountant where acc_name=?";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, accName);
			
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				String accEmail=rs.getString("acc_email");
				String password= rs.getString("password");
				int accContact=rs.getInt("acc_contact");
				
				accountant= new Accountant(accName,accEmail,password,accContact);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return accountant;
	}
	
	public void updateAccountant(Accountant accountant) {
		Connection con= DBUtil.getMySqlDbConnection();
		String sql = "update accountant set acc_email=?, acc_contact=?,where acc_name=?";
		try {
			
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, accountant.getAccEmail());
			pst.getInt(2,accountant.getAccContact());
			pst.setString(3, accountant.getAccName());
			
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
