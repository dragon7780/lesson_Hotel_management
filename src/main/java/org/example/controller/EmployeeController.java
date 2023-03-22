package org.example.controller;

import org.example.component.ComponentContainer;
import org.example.entity.EmployeeEntity;
import org.example.entity.EmployeeTypeEntity;
import org.example.repository.EmployeeRepository;
import org.example.sevice.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    public void start() {
        boolean isTrue=true;
        while (isTrue){
            menu();
            System.out.println("Enter action: ");
            int action = ComponentContainer.intScanner.nextInt();
            switch (action){
                case 0->isTrue=false;
                case 1->addEmployeeType();
                case 2->employeeTypeList();
                case 3->deleteEmployeeType();
                default -> {
                    System.out.println("Don't be mazgi");
                    isTrue=false;
                }
            }
        }
    }
    public void start2() {
        boolean isTrue=true;
        while (isTrue){
            menu();
            System.out.println("Enter action: ");
            int action = ComponentContainer.intScanner.nextInt();
            switch (action){
                case 0->isTrue=false;
                case 1->addEmployee();
                case 2->employeeList();
                case 3->deleteEmployee();
                default -> {
                    System.out.println("Don't be mazgi");
                    isTrue=false;
                }
            }
        }
    }

    private void deleteEmployee() {
        System.out.println("Enter employee id");
        int id = ComponentContainer.intScanner.nextInt();
        employeeService.deleteEmployee(id);
    }
    private void employeeList() {
        List<EmployeeEntity> allEmployee = employeeRepository.getAllEmployee();
        allEmployee.forEach(System.out::println);
    }
    private void addEmployee() {
        System.out.println("Enter name: ");
        String name = ComponentContainer.strScanner.nextLine();
        System.out.println("Enter surname: ");
        String surname = ComponentContainer.strScanner.nextLine();
        System.out.println("Enter phone: ");
        String phone = ComponentContainer.strScanner.nextLine();
        System.out.println("Enter birthday(YYYY-mm-dd)");
        String date = ComponentContainer.strScanner.nextLine();
        System.out.println("Enter type id");
        int typeID = ComponentContainer.intScanner.nextInt();
        Boolean employee = employeeService.addEmployee(name, surname, phone, date, typeID);
        if (!employee){
            System.err.println("Employee unsuccessfully !!!");
        }else {
            System.out.println("Employee successfully added !!!");
        }
    }
    private void addEmployeeType() {
        System.out.println("Add name:");
        String name = ComponentContainer.strScanner.nextLine();
        employeeService.addEmployeeType(name);
    }
    private void employeeTypeList() {
        List<EmployeeTypeEntity> all = employeeRepository.getAll();
        all.forEach(System.out::println);
    }
    private void deleteEmployeeType() {
        System.out.println("Enter id: ");
        int id = ComponentContainer.intScanner.nextInt();
        employeeService.deleteEmployeeType(id);
    }
    public void menu(){
        String menu= """
                0 exit
                1 Add Employee
                2 Employee List
                3 Delete employee
                """;
        System.out.println(menu);
    }
}
