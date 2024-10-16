package CustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import CustomerBean.CustomerBean;
import DataBaseConnection.DBConnection;

public class CustomerUpdateDAO {

	public int k;

	public int updateCustomerDetails(CustomerBean cb) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"UPDATE Customer SET ADDRESS = ?, EMAILID = ?, PHONENUMBER = ? WHERE CUSTOMERUSERNAME = ? AND CUSTOMERPASSWORD = ?");

			ps.setString(1, cb.getAddress());
			ps.setString(2, cb.getEmailId());
			ps.setLong(3, cb.getPhoneNumber());
			ps.setString(4, cb.getCustomerUsername());
			ps.setString(5, cb.getCustomerPassword());

			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;

	}

}
