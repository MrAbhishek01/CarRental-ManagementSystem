package DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	private static Connection con = null;

	private DBConnection() {}// private Constructor for immutable class

	static 
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(DBInfo.dbURL, DBInfo.dbUserName, DBInfo.dbPassword);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public static Connection getConnection() 
	{
		return con;
	}

}
