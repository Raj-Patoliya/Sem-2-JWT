package model;

import java.sql.*;

public class ConnectionString {
    private static Connection con = null;
    public static Connection getCon(){
   	 if(con ==null){
   		 try{
   	     	String dbURL = "jdbc:mysql://localhost:3306/demo";
   	     	String dbUsername = "root";
   	     	String dbPassword = "Password@123";
   	     	Class.forName("com.mysql.jdbc.Driver");
   	     	con = (Connection) DriverManager.getConnection(dbURL,dbUsername,dbPassword);       	 
   		 } catch(Exception e) {
   			 System.out.println(e);
   		 }
   	 }
   	 return con;    
    }

}
