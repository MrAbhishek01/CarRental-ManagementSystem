package BillDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import BillBeanClass.BillBean;
import CustomerBean.CustomerBean;
import DataBaseConnection.DBConnection;
import InfoCarBean.CarBean;

public class BillDAO {

	int k;

	public int insertbill(CustomerBean cb, CarBean car, BillBean bb) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("INSERT INTO CarRentedBill VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, bb.getOrderbill());
			ps.setString(2, cb.getCustomerUsername());
			ps.setString(3, cb.getFirstName() + " " + cb.getLastName());
			ps.setLong(4, cb.getPhoneNumber());
			ps.setString(5, cb.getEmailId());
			ps.setString(6, car.getCarBrand());
			ps.setString(7, car.getCarModel());
			ps.setString(8, car.getCarNumber());
			ps.setString(9, bb.getJourneyStartDate());
			ps.setString(10, bb.getJourneyEndDate());
			ps.setInt(11, bb.getTotalDays());
			ps.setString(12, "RENTED");
			ps.setDouble(13, bb.getTotalBill());
			ps.setString(14, car.getAdminUserName());

			k = ps.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return k;

	}

}
