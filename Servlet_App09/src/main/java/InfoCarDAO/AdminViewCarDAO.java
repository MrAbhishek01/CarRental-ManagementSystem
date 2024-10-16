package InfoCarDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import AdminBeanClass.AdminBean;
import DataBaseConnection.DBConnection;
import InfoCarBean.CarBean;

public class AdminViewCarDAO {

	public ArrayList<CarBean> al = new ArrayList<CarBean>();

	public ArrayList<CarBean> viewCarDetails(AdminBean ab) {

		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from CarDetails where ADMINUSERNAME = ?");
			ps.setString(1, ab.getAdminUsername());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CarBean cb = new CarBean();
				
				

				cb.setCarNumber(rs.getString(1));
				cb.setCarBrand(rs.getString(2));
				cb.setCarModel(rs.getString(3));
				cb.setCarRent_PER_DAY(rs.getDouble(4));
				cb.setLocation(rs.getString(5));
				al.add(cb);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;

	}

}
