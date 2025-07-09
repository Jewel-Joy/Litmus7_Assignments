package com.litmus7.retail.util;
import java.util.Properties;
import java.io.*;
import java.sql.*;
public class DBUtil {
	private Properties props;
	private String url="";
	private String user="";
	private String password="";
	Connection connection;
	Statement st;
	
	public Connection connect() throws FileNotFoundException, IOException,SQLException {
		props=new Properties();
		props.load(new FileInputStream("RetailProduct.properties"));
		url=props.getProperty("dburl");
		user=props.getProperty("user");
		password=props.getProperty("password");
		connection=DriverManager.getConnection(url,user,password);
		return connection; 
		
	} 

}


