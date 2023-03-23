package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.component.ComponentContainer;
import org.example.entity.GuestEntity;
import org.example.repository.GuestRepository;
import org.example.sevice.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GuestController {
    @Autowired
    private GuestService guestService;
    @Autowired
    private GuestRepository guestRepository;
    public void start(){
        boolean isTrue=true;
        while (isTrue) {
            menu();
            System.out.println("Enter action: ");
            int action = ComponentContainer.intScanner.nextInt();
            switch (action){
                case 0->isTrue=false;
                case 1->addGuest();
                case 2->guestList();
                default -> {
                    System.out.println("Don't be mazgi: ");
                    isTrue=false;
                }
            }
        }
    }

    private void guestList() {
        List<GuestEntity> all = guestRepository.getAll();
        all.forEach(System.out::println);
    }

    private void addGuest() {
        System.out.println("Enter name: ");
        String name = ComponentContainer.strScanner.nextLine();
        System.out.println("Enter surname: ");
        String surname = ComponentContainer.strScanner.nextLine();
        System.out.println("Enter password number: ");
        String password = ComponentContainer.strScanner.nextLine();
        System.out.println("Enter passport given date: 2002-02-23");
        String given_date = ComponentContainer.strScanner.nextLine();
        System.out.println("Enter passport expired date: 2002-02-23");
        String expired_date = ComponentContainer.strScanner.nextLine();
        System.out.println("Enter passport  given by: iib toshkent");
        String givenBy = ComponentContainer.strScanner.nextLine();
        guestService.addGuest(name,surname,password,given_date,expired_date,givenBy);
    }

    public void menu(){
        String menu= """
                0 exit
                1 Add guests
                2 Guest List
                """;
        System.out.println(menu);
    }
}
