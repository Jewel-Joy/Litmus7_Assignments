package com.litmus7.userregistration.ui;
import com.litmus7.userregistration.controller.Controller;
import com.litmus7.userregistration.user.User;
public class UI {

	public static void main(String[] args) {
		Controller controller=new Controller();
		User user=controller.registration();
		if(user!=null&&user.displayDetails()!=null)
			System.out.println("Valid Input");
		else
			System.out.println("Invalid Input");
		System.out.println(controller.dataInsertion());
	

		System.out.println("Data from database is::");
		User u=controller.dataAccess();
			System.out.println(u.displayDetails());
			
		}

	}


