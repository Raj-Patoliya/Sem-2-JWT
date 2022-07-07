package userService;
import model.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao {
	
	static Connection conn = ConnectionString.getConnection();
	
// For a inserting a new User in Database
	public static void saveUser(User user)
	{	
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("insert into user (name,gender,username,password) values('"+user.getName()+"','"+user.getGender()+"','"+user.getUsername()+"','"+user.getPassword()+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
// User Authentication for login
	public static ResultSet loginAuth(Login login)
	{
		ResultSet rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from user where username='"+login.getUsername()+"' and password = '"+login.getPassword()+"'"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	// User Authentication for login
		public static ResultSet getAllUser()
		{
			ResultSet rs = null;
			try {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery("select * from user"); 
			} catch (Exception e) {
				e.printStackTrace();
			}
			return rs;
		}
}
