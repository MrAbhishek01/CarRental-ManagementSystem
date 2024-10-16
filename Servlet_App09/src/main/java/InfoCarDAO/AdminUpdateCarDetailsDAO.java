package InfoCarDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import DataBaseConnection.DBConnection;
import InfoCarBean.CarBean;

public class AdminUpdateCarDetailsDAO {

	int k;

	public int updateCarDetails(CarBean cb) {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update Cardetails set CAR_PRICEDAY = ?, LOCATION = ? where CAR_NUMBER = ?");
			ps.setDouble(1, cb.getCarRent_PER_DAY());
			ps.setString(2, cb.getLocation());
			ps.setString(3, cb.getCarNumber());

			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;

	}
}
