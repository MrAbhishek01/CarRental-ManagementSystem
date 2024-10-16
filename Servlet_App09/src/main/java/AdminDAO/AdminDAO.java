package AdminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import AdminBeanClass.AdminBean;
import DataBaseConnection.DBConnection;

public class AdminDAO 
{	
	public int k;

	public int insertDetails(AdminBean ab) 
	{
		try 
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO Admin  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, ab.getAdminUsername());
			ps.setString(2, ab.getAdminPassword());
			ps.setString(3, ab.getFirstName());
			ps.setString(4, ab.getLastName());
			ps.setString(5, ab.getDateOfBirth());
			ps.setString(6, ab.getGender());
			ps.setString(7, ab.getAddress());
			ps.setString(8, ab.getEmailId());
			ps.setLong(9, ab.getPhoneNumber());

			k = ps.executeUpdate();

		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		return k;
	}

}
