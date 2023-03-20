package org.example.controller;

import org.example.component.ComponentContainer;
import org.example.enums.RoomType;
import org.example.sevice.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoomType roomType;
    public void start() {
        boolean isTrue=true;
        while (isTrue){

        }
    }
    public RoomType type(){
        String menu= """
                1 Simple
                2 Lux
                3 Duality
                4 Family
                5 President
                """;
        System.out.println(menu);
        System.out.print("Enter action: ");
        int action = ComponentContainer.intScanner.nextInt();
        switch (action){
            case 1->roomType=RoomType.SIMPLE;
            case 2->roomType=RoomType.LUX;
            case 3->roomType=RoomType.DUALITY;
            case 4->roomType=RoomType.FAMILY;
            case 5->roomType=RoomType.PRESIDENT;
            default -> {
                System.out.println("Don't be mazgi");
                addRoom();
            }
        }
        return roomType;
    }
    public void addRoom(){
        System.out.println("Enter number:");
        int number = ComponentContainer.intScanner.nextInt();
        System.out.println("Enter folder: ");
        Integer stage = ComponentContainer.strScanner.nextInt();
        System.out.println("Enter type: ");
        RoomType type = type();
        System.out.println("Enter price: " );
        Double price = ComponentContainer.intScanner.nextDouble();
        System.out.println("Enter area: ");
        int area = ComponentContainer.intScanner.nextInt();
        boolean adding = adminService.addRoom(number,stage,type,price,area);
        if (adding){
            System.out.println("Room is successfully added !!!");
        }
    }
}
