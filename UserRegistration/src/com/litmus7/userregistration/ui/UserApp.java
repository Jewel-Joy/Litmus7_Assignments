package com.litmus7.userregistration.ui;
import com.litmus7.userregistration.controller.UserRegistrationController;
import com.litmus7.userregistration.dto.Response;
import com.litmus7.userregistration.model.User;

public class UserApp {

    public static void main(String[] args) {
    	UserRegistrationController controller = new UserRegistrationController();      
        Response registration = controller.registration();
        if (registration.getStatusCode() == 200) {
            System.out.println(registration.getResponseMessage());

            Response insertion = controller.dataInsertion();
            if (insertion.getStatusCode() == 200)
                System.out.println(insertion.getResponseMessage());
            else
                System.out.println("Insertion Error: " + insertion.getErrorMessage());

            
            System.out.println("Data from database is:");
            Response access = controller.dataAccess();
            if (access.getStatusCode() == 200) {
                User u = access.getData();
                System.out.println(u.displayDetails());
                System.out.println(access.getResponseMessage());
            } else {
                System.out.println("Data Access Error: " + access.getErrorMessage());
            }

        } else {
           
            System.out.println("Registration Failed: " + registration.getErrorMessage());
        }
    }
}
