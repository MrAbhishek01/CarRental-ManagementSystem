package InfoCarDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DataBaseConnection.DBConnection;
import InfoCarBean.CarBean;

public class CustomerViewCarLocationOrAllWiseDAO {

	ArrayList<CarBean> al = new ArrayList<CarBean>();
	CarBean carBean = null;

	public ArrayList<CarBean> viewAllCarDetails() {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from cardetails where AVAILABLE = 1");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				carBean = new CarBean();

				carBean.setCarNumber(rs.getString(1));
				carBean.setCarBrand(rs.getString(2));
				carBean.setCarModel(rs.getString(3));
				carBean.setCarRent_PER_DAY(rs.getDouble(4));
				carBean.setLocation(rs.getString(5));
				al.add(carBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;

	}

	public ArrayList<CarBean> ViewCarDetailsLocationWise(String location) {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from CarDetails where AVAILABLE=1 and LOCATION = ?");
			ps.setString(1, location);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				carBean = new CarBean();
				carBean.setCarNumber(rs.getString(1));
				carBean.setCarBrand(rs.getString(2));
				carBean.setCarModel(rs.getString(3));
				carBean.setCarRent_PER_DAY(rs.getDouble(4));
				carBean.setLocation(rs.getString(5));
				al.add(carBean);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return al;
	}

}
