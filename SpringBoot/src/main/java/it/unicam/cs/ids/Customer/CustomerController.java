package it.unicam.cs.ids.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/student/")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService service){
        this.customerService = service;
    }


    @GetMapping
    public List<Customer> getCustomers(){
       return customerService.getCustomers();
    }
}
