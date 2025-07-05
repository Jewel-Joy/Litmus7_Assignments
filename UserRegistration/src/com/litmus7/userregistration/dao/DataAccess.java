package com.litmus7.userregistration.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.litmus7.userregistration.jdbc.JDBC;
import com.litmus7.userregistration.user.User;

public class DataAccess {
	private String name;
	private int age;
	private String email;
	private String password;
	public List<User> dataAccess() {
		List<User> users=new ArrayList<>();
		JDBC jdbc=new JDBC();
		Connection conn=jdbc.connect();
		User user=null;
		ResultSet rs;
		try {
			Statement stmt=conn.createStatement();
			rs = stmt.executeQuery("select * from User");
			while(rs.next()) {
				name=rs.getString("name");
				age=rs.getInt("age");
				email=rs.getString("email");
				password=rs.getNString("password");
				if(name!=null) {
				user=new User(name,age,email,password);
				users.add(user);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;

	}
	
}
