package org.example.sevice;

import org.example.entity.EmployeeEntity;
import org.example.entity.EmployeeTypeEntity;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public void addEmployeeType(String name) {
        EmployeeTypeEntity employeeType=new EmployeeTypeEntity();
        employeeType.setType(name);
        employeeRepository.saveType(employeeType);
    }
    public void deleteEmployeeType(int id) {
        EmployeeTypeEntity employeeTypeById = employeeRepository.getEmployeeTypeById(id);
        if (employeeTypeById == null){
            return;
        }
        employeeRepository.deleteEmployeeTypeById(id);
    }
    public Boolean addEmployee(String name, String surname, String phone, String date,Integer typeID) {
       boolean checkDate = checkingDate(date);
       if (!checkDate){
           return false;
       }
       EmployeeTypeEntity typeById = employeeRepository.getEmployeeTypeById(typeID);
       if (typeById == null){
           return false;
       }
        EmployeeEntity employee=new EmployeeEntity();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setPhone(phone);
        employee.setBirthday(LocalDate.parse(date));
        employee.setEmployeeType(typeById);
        employeeRepository.saveEmployee(employee);
        return true;
    }
    private boolean checkingDate(String date) {
        String[] split = date.split("-");
        if(split.length==0){
            return false;
        } else if (split[0].length() != 4) {
            System.err.println("Check year!!! It must be YYY");
            return false;
        } else if (split[1].length() != 2) {
            System.err.println("Check moth!!! It must be 1-12");
            return false;
        } else if (split[2].length() != 4) {
            System.err.println("Check day!!! It must be 1-31");
            return false;
        }else if (!split[0].matches("^[0-9]+$")){
            System.err.println("Check year!!! It must be integer");
            return false;
        }else if (!split[1].matches("^[0-9]+$")){
            System.err.println("Check moths !!! It must be integer");
            return false;
        }else if (!split[2].matches("^[0-9]+$")){
            System.out.println("Check day !!! It must be integer");
            return false;
        }
        return true;
    }
    public void deleteEmployee(int id) {
        EmployeeEntity employeeById = employeeRepository.getEmployeeById(id);
        if (employeeById == null){
            return;
        }
        employeeRepository.deleteEmployeeTypeById(id);
    }
}
