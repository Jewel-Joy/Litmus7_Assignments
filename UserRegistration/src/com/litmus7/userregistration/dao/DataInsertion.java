package com.litmus7.userregistration.dao;

import com.litmus7.userregistration.jdbc.JDBC;

import java.sql.*;
public class DataInsertion {
	public String dataInsert(String name,int age,String email,String password) {
	JDBC jdbc=new JDBC();
	Connection conn=jdbc.connect();
	try {

		PreparedStatement stmt=conn.prepareStatement("insert into user (name,age,email,password) values (?,?,?,?)");
		stmt.setString(1,name);
		stmt.setInt(2,age);
		stmt.setString(3,email);
		stmt.setString(4,password);
		int result = stmt.executeUpdate();
		
		if(result==1)
			return "insertion to database is succesfull ";
		else
			return "insertion failed";
		
			
		
		
	} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		return "Error :"+e.getMessage();
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		return "Error :"+e.getMessage();
	} 
	}
}






