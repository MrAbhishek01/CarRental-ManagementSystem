package BillDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BillBeanClass.BillBean;
import CustomerBean.CustomerBean;
import DataBaseConnection.DBConnection;

public class CurrentBilHistory {

	ArrayList<BillBean> bb = new ArrayList<BillBean>();

	public ArrayList<BillBean> retrieveCurrentBill(CustomerBean cb) {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("SELECT * FROM CarRentedBill WHERE RENTEDSTATUS = ? AND CUSTOMERUSERID = ?");

			ps.setString(1, "RENTED");
			ps.setString(2, cb.getCustomerUsername());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BillBean bill = new BillBean();
				bill.setOrderbill(rs.getString(1));
				bill.setCustomerUserID(rs.getString(2));
				bill.setCustomerName(rs.getString(3));
				bill.setCustomerMobileNumber(rs.getLong(4));
				bill.setCustomerEmailId(rs.getString(5));
				bill.setCarBrand(rs.getString(6));
				bill.setCarModel(rs.getString(7));
				bill.setCarNumber(rs.getString(8));
				bill.setJourneyStartDate(rs.getString(9));
				bill.setJourneyEndDate(rs.getString(10));
				bill.setTotalDays(rs.getInt(11));
				bill.setRentedStatus(rs.getString(12));
				bill.setTotalBill(rs.getDouble(13));

				bb.add(bill);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return bb;
	}
}
