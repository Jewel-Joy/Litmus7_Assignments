package com.litmus7.userregistration.controller;
import java.sql.SQLException;
import com.litmus7.userregistration.dao.DataAccess;
import com.litmus7.userregistration.dao.DataInsertion;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.WeakPasswordException;
import com.litmus7.userregistration.registration.UserRegistration;
import com.litmus7.userregistration.user.User;

public class Controller {
	UserRegistration user=new UserRegistration();
	DataInsertion datainsert=new DataInsertion();
	DataAccess dataaccess=new DataAccess();
	User u=null;
	
	public User registration() {
	
		try {
				u=user.userRegistration();
		}catch(InvalidAgeException | InvalidEmailException | WeakPasswordException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
		}
	public String dataInsertion() {
		String data="";
		try {
			data= datainsert.dataInsert(u.getUsername(), u.getAge(),u.getEmail() , u.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return data;
		
	}
	public User dataAccess() {
		User users=null;
		try {
			users=dataaccess.dataAccess(u.getEmail());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users; 
	}
	
}
