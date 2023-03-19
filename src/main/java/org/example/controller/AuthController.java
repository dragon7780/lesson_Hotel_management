package org.example.controller;

import org.example.component.ComponentContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.Access;

@Controller
public class AuthController {
    @Autowired
    private AdminController adminController;
    public void start(){
        boolean isTrue=true;
        while (isTrue){
            menu();
            System.out.print("Enter action: ");
            int action = ComponentContainer.intScanner.nextInt();
            switch (action){
                case 0->isTrue=false;
                case 1->LogIn();
                case 2->Complain();
                default -> {
                    isTrue=false;
                    System.out.println("Don't be mazgi");
                }
            }
        }
    }

    private void Complain() {
    }

    private void LogIn() {
        adminController.start();
    }

    public void menu(){
        String menu= """
                0 exit
                1 LogIn
                2 Complain
                """;
        System.out.println(menu);
    }
}
