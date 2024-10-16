package BillDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import BillBeanClass.BillBean;
import DataBaseConnection.DBConnection;

public class UpdateBillStatus {

	public int k;

	public int updateBillStatus(BillBean bb) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con
					.prepareStatement("UPDATE CarRentedBill SET RENTEDSTATUS = 'RETURNED' WHERE ORDERBILL = ?");
			ps.setString(1, bb.getOrderbill());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;

	}

}
