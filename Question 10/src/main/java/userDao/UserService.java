package userDao;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class UserService {
	static Connection con = (Connection) ConnectionString.getCon();
	public static void insertUser(User user)
	{
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into user(name,gender,username,password) values('"+user.getName()+"','"+user.getGender()+"','"+user.getUsername()+"','"+user.getPassword()+"') ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 public static ResultSet login(Login login){
	   	 ResultSet rs= null;
	   	 try {	
	   		 Statement st = (Statement) con.createStatement();
	   		 rs = st.executeQuery("select * from user where username = '"+login.getUsername()+"' and password = '"+login.getPassword()+"'"); 
	   	 } catch (Exception e) {
	   		 System.out.println(e);
	   	 }
	   	 return rs;
	    }
}