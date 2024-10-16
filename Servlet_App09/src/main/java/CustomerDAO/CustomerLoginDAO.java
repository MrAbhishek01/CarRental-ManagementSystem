package CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import CustomerBean.CustomerBean;
import DataBaseConnection.DBConnection;

public class CustomerLoginDAO 
{

	public CustomerBean cb = null;

	public CustomerBean Customerlogin(String uN, String pW) 
	{
		try 
		{
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from CUSTOMER where CUSTOMERUSERNAME = ? and  CUSTOMERPASSWORD= ?");

			ps.setString(1, uN);
			ps.setString(2, pW);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) 
			{		
				cb = new CustomerBean();

				cb.setCustomerUsername(rs.getString(1));
				cb.setCustomerPassword(rs.getString(2));
				cb.setFirstName(rs.getString(3));
				cb.setLastName(rs.getString(4));
				cb.setDateOfBirth(rs.getString(5));
				cb.setGender(rs.getString(6));
				cb.setAddress(rs.getString(7));
				cb.setEmailId(rs.getString(8));
				cb.setPhoneNumber(Long.parseLong(rs.getString(9)));
			}

		} catch (Exception e) 
		{
			e.printStackTrace();
		}

		return cb;

	}

}
