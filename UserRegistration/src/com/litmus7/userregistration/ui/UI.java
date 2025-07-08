package com.litmus7.userregistration.ui;
import com.litmus7.userregistration.controller.Controller;
import com.litmus7.userregistration.response.Response;
import com.litmus7.userregistration.user.User;

public class UI {

    public static void main(String[] args) {
        Controller controller = new Controller();

        
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
