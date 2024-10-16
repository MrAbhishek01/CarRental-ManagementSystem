package CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import CustomerBean.CustomerBean;
import DataBaseConnection.DBConnection;

public class CustomerDAO {
	public int insertDetails(CustomerBean cb) {
		int k = 0;

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into Customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, cb.getCustomerUsername());
			ps.setString(2, cb.getCustomerPassword());
			ps.setString(3, cb.getFirstName());
			ps.setString(4, cb.getLastName());
			ps.setString(5, cb.getDateOfBirth());
			ps.setString(6, cb.getGender());
			ps.setString(7, cb.getAddress());
			ps.setString(8, cb.getEmailId());
			ps.setLong(9, cb.getPhoneNumber());

			k = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;
	}
}
