package com.litmus7.userregistration.service;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import com.litmus7.userregistration.dao.DataAccess;
import com.litmus7.userregistration.exception.DuplicateEntry;
import com.litmus7.userregistration.exception.InvalidAgeException;
import com.litmus7.userregistration.exception.InvalidEmailException;
import com.litmus7.userregistration.exception.WeakPasswordException;
import com.litmus7.userregistration.model.User;


public class UserRegistration {

	public User userRegistration() throws InvalidAgeException,InvalidEmailException,WeakPasswordException, DuplicateEntry, SQLException, FileNotFoundException, IOException {
		DataAccess data=new DataAccess();
		Scanner scanner=new Scanner(System.in);
	try {
		
		System.out.println("Enter the name");
		String name=scanner.next();
		System.out.println("Enter the age");
		int age=scanner.nextInt();
		if(age<18||age>60)
			throw new InvalidAgeException("The age in not within the limit");
		System.out.println("Enter the email");
		String email=scanner.next();
		if(!email.contains("@")||!email.contains("."))
			throw new InvalidEmailException("The email is invalid");
		if(data.duplicateEntry(email)==false)
			throw new DuplicateEntry("The email already exist");
		
		System.out.println("Enter the pasword");
		String password=scanner.next();
		if(password.length()<=6)
			throw new WeakPasswordException("The password is weak");
		return new User(name,age,email,password);
		
	}finally {
		
		scanner.close();
	}
}
}

