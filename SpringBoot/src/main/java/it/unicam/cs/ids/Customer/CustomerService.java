package it.unicam.cs.ids.Customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;
@Service
public class CustomerService {


    public List<Customer> getCustomers(){
        Customer kacper = new Customer(
                "Kacper",
                "Osicki",
                "+393349417779",
                "" + "gaspareosicki@gmail.com",
                new Address("Via giulia piccolomini cicarelli, 92","62032","Camerino","Macerata"),
                UUID.randomUUID(),
                new GregorianCalendar(1999,9,24));
        return List.of(kacper,kacper);
    }
}
