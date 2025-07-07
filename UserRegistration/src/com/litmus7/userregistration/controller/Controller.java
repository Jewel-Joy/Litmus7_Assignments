package com.litmus7.userregistration.controller;
import java.sql.SQLException;
import com.litmus7.userregistration.dao.DataAccess;
import com.litmus7.userregistration.dao.DataInsertion;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.WeakPasswordException;
import com.litmus7.userregistration.registration.UserRegistration;
import com.litmus7.userregistration.response.Response;
import com.litmus7.userregistration.user.User;

public class Controller {
	User u=null;
	final int ERR_CODE=400;
	final int SUCCESS_CODE=200;
	
	public Response registration() {
		UserRegistration user=new UserRegistration();
		Response response=new Response();
		
		try {
				u=user.userRegistration();
				
				response.setResponseMessage("Registration successful");
				response.setStatusCode(SUCCESS_CODE);
				
		}catch(InvalidAgeException e) {
			response.setErrorMessage("Invalid age limit");
			response.setStatusCode(ERR_CODE);
		}
		catch(InvalidEmailException  e) {
			response.setErrorMessage("Invalid email");
			response.setStatusCode(ERR_CODE);
		}
		catch( WeakPasswordException e) {
			response.setErrorMessage("Weak Passwword");
			response.setStatusCode(ERR_CODE);
			
		}

		return response;
		}
	public Response dataInsertion() {
		Response response=new Response();
		DataInsertion datainsert=new DataInsertion();
		try {
			datainsert.dataInsert(u.getUsername(), u.getAge(),u.getEmail() , u.getPassword());
			response.setResponseMessage("Succesfully Inserted");
			response.setStatusCode(SUCCESS_CODE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.setErrorMessage("Insertion failed"+ e.getMessage());
			response.setStatusCode(ERR_CODE);
		}
		return response;
		
	}
	public Response dataAccess() {
		Response response=new Response();
		DataAccess dataaccess=new DataAccess();
		User users=null;
		try {
			users=dataaccess.dataAccess(u.getEmail());
			response.setData(users);
			response.setResponseMessage("Succesfully retrived");
			response.setStatusCode(SUCCESS_CODE);
		} catch (SQLException e) {
			response.setErrorMessage("Retrival  failed"+ e.getMessage());
			response.setStatusCode(ERR_CODE);
			
		}
		return response; 
	}
	
}
