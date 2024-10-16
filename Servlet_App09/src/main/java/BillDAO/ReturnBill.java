package BillDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import BillBeanClass.BillBean;
import CustomerBean.CustomerBean;
import DataBaseConnection.DBConnection;

public class ReturnBill {

	ArrayList<BillBean> al = new ArrayList<BillBean>();

	public ArrayList<BillBean> returnBill(CustomerBean cb) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("select * from CarRentedBill where rentedStatus = 'RENTED' and customerUserID = ?");

			ps.setString(1, cb.getCustomerUsername());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BillBean bb = new BillBean();

				bb.setOrderbill(rs.getString(1));
				bb.setCustomerUserID(rs.getString(2));
				bb.setCustomerName(rs.getString(3));
				bb.setCustomerMobileNumber(rs.getLong(4));
				bb.setCustomerEmailId(rs.getString(5));
				bb.setCarBrand(rs.getString(6));
				bb.setCarModel(rs.getString(7));
				bb.setCarNumber(rs.getString(8));
				bb.setJourneyStartDate(rs.getString(9));
				bb.setJourneyEndDate(rs.getString(10));
				bb.setTotalDays(rs.getInt(11));
				bb.setRentedStatus(rs.getString(12));
				bb.setTotalBill(rs.getDouble(13));
				al.add(bb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return al;

	}

}
