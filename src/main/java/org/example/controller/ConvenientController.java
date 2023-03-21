package org.example.controller;

import org.example.component.ComponentContainer;
import org.example.entity.ConvenientEntity;
import org.example.repository.ConvenientRepository;
import org.example.sevice.ConvenientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ConvenientController {
    @Autowired
    private ConvenientRepository convenientRepository;
    @Autowired
    private ConvenientService convenientService;
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

    private void deleteConvenient() {
        System.out.println("Enter id: ");
        int id = ComponentContainer.intScanner.nextInt();
        convenientService.deleteById(id);
    }

    private void convenientList() {
        List<ConvenientEntity> convenientEntities = convenientRepository.geAll();
        convenientEntities.forEach(System.out::println);
    }

    private void addConvenient() {
        System.out.println("Enter name:");
        String name = ComponentContainer.strScanner.nextLine();
        convenientService.addConvenient(name);
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
