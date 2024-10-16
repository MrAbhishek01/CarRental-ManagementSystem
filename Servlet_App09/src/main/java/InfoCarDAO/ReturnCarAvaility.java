package InfoCarDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import DataBaseConnection.DBConnection;

public class ReturnCarAvaility {
	public int k;

	public int returnCarAvaility(String carNumber) {
		try {

			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE CarDetails SET AVAILABLE = 1 WHERE CAR_NUMBER = ?");

			ps.setString(1, carNumber);
			k = ps.executeUpdate();

		} catch (Exception e) {
			e.getStackTrace();
		}
		return k;

	}
}