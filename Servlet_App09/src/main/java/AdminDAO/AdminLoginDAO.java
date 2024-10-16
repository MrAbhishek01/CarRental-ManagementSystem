package AdminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import AdminBeanClass.AdminBean;
import DataBaseConnection.DBConnection;

public class AdminLoginDAO 
{

	public AdminBean ab = null;

	public AdminBean adminLogin(String uN, String pW) 
	{
		try 
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from admin  WHERE ADMINUSERNAME = ? AND ADMINPASSWORD = ?");
			
			ps.setString(1, uN);
			ps.setString(2, pW);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) 
			{
				ab = new AdminBean();

				ab.setAdminUsername(rs.getString(1));
				ab.setAdminPassword(rs.getString(2));
				ab.setFirstName(rs.getString(3));
				ab.setLastName(rs.getString(4));
				ab.setDateOfBirth(rs.getString(5));
				ab.setGender(rs.getString(6));
				ab.setAddress(rs.getString(7));
				ab.setEmailId(rs.getString(8));
				ab.setPhoneNumber(rs.getLong(9));
			}

		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		return ab;
	}
}
