package InfoCarDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import DataBaseConnection.DBConnection;
import InfoCarBean.CarBean;

public class RentCarAvaility {

	public int k;

	public int rentedCarAvaility(CarBean carBean) {
		try {

			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("UPDATE CarDetails SET AVAILABLE = 0 WHERE CAR_NUMBER = ?");

			ps.setString(1, carBean.getCarNumber());
			k = ps.executeUpdate();

		} catch (Exception e) {
			e.getStackTrace();
		}
		return k;

	}
}
