package org.example.controller;

import org.example.component.ComponentContainer;
import org.example.entity.EmployeeEntity;
import org.example.sevice.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomController roomController;
    @Autowired
    private ConvenientController convenientController;
    @Autowired
    private EmployeeController employeeController;
    @Autowired
    private GuestController guestController;
    public void start(){
        Boolean isTrue=true;
        while (isTrue){
            menu();
            System.out.print("Enter action: ");
            int action = ComponentContainer.intScanner.nextInt();
            switch (action){
                case 0->isTrue=false;
                case 1->room();
                case 2->convenient();
                case 3->employeeType();
                case 4->employee();
                case 5->guest();
                case 6->booking();
                case 7->outcome();
                default -> {
                    System.out.println("Don't be mazgi???");
                    isTrue=false;
                }
            }
        }
    }

    private void room() {
        roomController.start();
    }
    private void convenient() {
        convenientController.start();
    }

    private void employeeType() {
        employeeController.start();
    }

    private void employee() {
        employeeController.start2();
    }

    private void guest() {
        guestController.start();
    }

    private void booking() {
    }

    private void outcome() {
    }

    public void menu(){
        String menu= """
                0 exit
                1 Room
                2 Convenient
                3 Employee Type
                4 Employee
                5 Guest
                6 Booking
                7 Outcome
                """;
        System.out.println(menu);
    }
}
