package com.litmus7.userregistration.jdbc;

import java.util.Properties;
import java.io.*;
import java.sql.*;
public class JDBC {
	private Properties props;
	private String url="";
	private String user="";
	private String password="";
	Connection conn;
	Statement st;
	
	public Connection connect() {
		props=new Properties();
		try {
			
			props.load(new FileInputStream("user.properties"));
			url=props.getProperty("dburl");
			user=props.getProperty("user");
			password=props.getProperty("password");
			conn=DriverManager.getConnection(url,user,password);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn; 
		
	} 

}
