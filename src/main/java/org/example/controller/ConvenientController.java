package org.example.controller;

import org.example.component.ComponentContainer;
import org.example.repository.ConvenientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ConvenientController {
    @Autowired
    private ConvenientRepository convenientRepository;
    public void start() {
        boolean isTrue=true;
        while (isTrue){
            menu();
            System.out.println("Enter action: ");
            int action = ComponentContainer.intScanner.nextInt();
            switch (action){
                case 0->isTrue=false;
                case 1->addConvenient();
                case 2->convenientList();
                case 3->deleteConvenient();
                default -> {
                    System.out.println("Don't be mazgi: ");
                    isTrue=false;
                }
            }
        }
    }

    private void addConvenient() {
        
    }

    public void menu(){
        String menu= """
                0 exit
                1 Add convenient
                2 Convenient List
                3 Delete convenient
                """;
        System.out.println(menu);
    }
}
