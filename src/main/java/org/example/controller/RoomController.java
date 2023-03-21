package org.example.controller;

import org.example.component.ComponentContainer;
import org.example.entity.ConvenientEntity;
import org.example.entity.RoomEntity;
import org.example.enums.RoomType;
import org.example.repository.ConvenientRepository;
import org.example.repository.RoomRepository;
import org.example.sevice.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomRepository roomRepository;
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
                case 1->addRoom();
                case 2->roomList();
                case 3->deleteRoom();
                case 4->updateRoom();
                case 5->findRoom();
                case 6->roomConvenient();
                default -> {
                    System.out.println("Don't be mazgi: ");
                    isTrue=false;
                }
            }
        }
    }
    private void roomConvenient() {
        System.out.println("Enter room id:");
        int room= ComponentContainer.intScanner.nextInt();
        System.out.println("Enter convenient id ");
        int con = ComponentContainer.intScanner.nextInt();
        ConvenientEntity byId = convenientRepository.getById(room, con);
        System.out.println(byId);
    }
    private void findRoom() {
        System.out.println("Enter id: ");
        int id = ComponentContainer.intScanner.nextInt();
        RoomEntity byId = roomRepository.getById(id);
        System.out.println(byId);
    }
    private void updateRoom() {
        System.out.println("Enter id: ");
        int id = ComponentContainer.intScanner.nextInt();
        System.out.println("Enter number:");
        int number = ComponentContainer.intScanner.nextInt();
        System.out.println("Enter folder: ");
        Integer stage = ComponentContainer.strScanner.nextInt();
        System.out.println("Enter type: ");
        String type = type();
        System.out.println("Enter price: " );
        Double price = ComponentContainer.intScanner.nextDouble();
        System.out.println("Enter area: ");
        int area = ComponentContainer.intScanner.nextInt();
        roomService.updateRoom(id,number,stage, RoomType.valueOf(type),price,area);
    }
    private void deleteRoom() {
        System.out.print("Enter room id: ");
        int id = ComponentContainer.intScanner.nextInt();
        roomService.deleteById(id);
    }
    private void roomList() {
        roomRepository.getAll().forEach(System.out::println);
    }
    public String type(){
        String roomType1 = null;
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
            case 1->roomType1= String.valueOf(RoomType.SIMPLE);
            case 2->roomType1= String.valueOf(RoomType.LUX);
            case 3->roomType1= String.valueOf(RoomType.DUALITY);
            case 4->roomType1= String.valueOf(RoomType.FAMILY);
            case 5->roomType1= String.valueOf(RoomType.PRESIDENT);
            default -> {
                System.out.println("Don't be mazgi");
                addRoom();
            }
        }
        return roomType1;
    }
    public void addRoom(){
        System.out.println("Enter number:");
        int number = ComponentContainer.intScanner.nextInt();
        System.out.println("Enter folder: ");
        Integer stage = ComponentContainer.strScanner.nextInt();
        System.out.println("Enter type: ");
        String type = type();
        System.out.println("Enter price: " );
        Double price = ComponentContainer.intScanner.nextDouble();
        System.out.println("Enter area: ");
        int area = ComponentContainer.intScanner.nextInt();
        boolean adding = roomService.addRoom(number,stage, RoomType.valueOf(type),price,area);
        if (adding){
            System.out.println("Room is successfully added !!!");
        }
    }
    public void menu(){
        String menu= """
                0 exit
                1 Add room
                2 List rooms
                3 Delete room
                4 Update room
                5 Find room
                6 Room convenient
                """;
        System.out.println(menu);
    }
}
