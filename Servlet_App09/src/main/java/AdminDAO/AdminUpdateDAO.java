package AdminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import AdminBeanClass.AdminBean;
import DataBaseConnection.DBConnection;

public class AdminUpdateDAO 
{
	public int k;

	public int updateAdminDetails(AdminBean ab) 
	{
		try 
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE Admin SET ADDRESS = ?, EMAILID = ?, PHONENUMBER = ? WHERE ADMINUSERNAME = ? AND ADMINPASSWORD = ?");

			ps.setString(1, ab.getAddress());
			ps.setString(2, ab.getEmailId());
			ps.setLong(3, ab.getPhoneNumber());
			ps.setString(4, ab.getAdminUsername());
			ps.setString(5, ab.getAdminPassword());

			k = ps.executeUpdate();

		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		return k;

	}

}
