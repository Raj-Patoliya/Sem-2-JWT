package userService;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionString {

	private static Connection con = null;
	public static Connection getConnection()
	{
		if(con ==null)
		{
			try {
				String url = "jdbc:mysql://localhost:3306/demo";
				String username = "root";
				String pass = "Password@123";
	   	     	Class.forName("com.mysql.jdbc.Driver");
	   	     	con = DriverManager.getConnection(url,username,pass);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
}
