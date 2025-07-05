package com.litmus7.userregistration.ui;

import java.util.List;
import java.util.ArrayList;

import com.litmus7.userregistration.controller.Controller;
import com.litmus7.userregistration.user.User;
import java.util.Scanner;


public class UI {

	public static void main(String[] args) {
		Controller controller=new Controller();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Do you want to \n 1 : Insert Value \n 2 : Retrive data from database ");
		int choice=scanner.nextInt();
		switch(choice) {
			case 1:
				User user=controller.registration();
				if(user!=null&&user.displayDetails()!=null)
					System.out.println("Valid Input");
				else
					System.out.println("Invalid Input");
				System.out.println(controller.dataInsertion());
				break;
			case 2:
				System.out.println("Data from database is::");
				List<User> users=new ArrayList<>();
				users=controller.dataAccess();
				for(User u:users) {
					System.out.println(u.displayDetails());
			}
		}

	}

}
