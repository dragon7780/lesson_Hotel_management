package org.example.sevice;

import org.example.entity.GuestEntity;
import org.example.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GuestService {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GuestRepository guestRepository;
    public void addGuest(String name, String surname, String password, String given_date, String expired_date, String givenBy) {
        boolean give = employeeService.checkingDate(given_date);
        boolean expired = employeeService.checkingDate(expired_date);
        if(!give||!expired){
            return;
        }
        GuestEntity guest=new GuestEntity();
        guest.setExpired_date(LocalDate.parse(expired_date));
        guest.setName(name);
        guest.setSurname(surname);
        guest.setPass_number(password);
        guest.setGivenBy(givenBy);
        guest.setGiven_date(LocalDate.parse(given_date));
        guestRepository.save(guest);
    }

}
