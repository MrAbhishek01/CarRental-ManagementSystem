package InfoCarDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DataBaseConnection.DBConnection;
import InfoCarBean.CarBean;

public class AdminDeleteCarDAO {
	public boolean found = false;

	public boolean deleteCar(CarBean cb) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from cardetails where CAR_NUMBER = ?");
			ps.setString(1, cb.getCarNumber());
			ResultSet rs = ps.executeQuery();
			
			found = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return found;

	}

}
