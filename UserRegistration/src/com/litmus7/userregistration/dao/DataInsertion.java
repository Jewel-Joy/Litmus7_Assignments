package com.litmus7.userregistration.dao;
import com.litmus7.userregistration.jdbc.JDBC;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
public class DataInsertion {
	public String dataInsert(String name,int age,String email,String password) throws SQLException, FileNotFoundException, IOException {
		JDBC jdbc=new JDBC();
		Connection conn=jdbc.connect();
		
	
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
}






