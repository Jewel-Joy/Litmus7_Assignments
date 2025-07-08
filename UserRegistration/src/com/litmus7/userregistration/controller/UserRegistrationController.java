package com.litmus7.userregistration.controller;
import java.sql.SQLException;
import com.litmus7.userregistration.dao.DataAccess;
import com.litmus7.userregistration.dao.DataInsertion;
import com.litmus7.userregistration.dto.Response;
import com.litmus7.userregistration.exception.DuplicateEntry;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.WeakPasswordException;
import com.litmus7.userregistration.model.User;
import com.litmus7.userregistration.service.UserRegistration;

public class UserRegistrationController {
	User u=null;
	final int ERR_CODE=400;
	final int SUCCESS_CODE=200;
	Response response=new Response();
	
	public Response registration() {
		UserRegistration user=new UserRegistration();
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
		catch( DuplicateEntry e) {
			response.setErrorMessage("Email already exist");
			response.setStatusCode(ERR_CODE);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			response.setErrorMessage("Wrong SQL syntax");
			response.setStatusCode(ERR_CODE);
		}

		return response;
		}
	public Response dataInsertion() {
		
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
