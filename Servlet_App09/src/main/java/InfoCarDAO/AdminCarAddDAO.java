package InfoCarDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import AdminBeanClass.AdminBean;
import DataBaseConnection.DBConnection;
import InfoCarBean.CarBean;

public class AdminCarAddDAO {

	int k;

	public int addCar(CarBean carbean, AdminBean ab) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("INSERT INTO CarDetails VALUES (?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, carbean.getCarNumber());
			ps.setString(2, carbean.getCarBrand());
			ps.setString(3, carbean.getCarModel());
			ps.setDouble(4, carbean.getCarRent_PER_DAY());
			ps.setString(5, carbean.getLocation());
			ps.setInt(6, 1);
			ps.setString(7, ab.getAdminUsername());

			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;

	}

}
