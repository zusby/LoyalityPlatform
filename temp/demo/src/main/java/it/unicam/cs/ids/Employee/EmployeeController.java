package it.unicam.cs.ids.Employee;

import it.unicam.cs.ids.Customer.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path= "/api/v1/employee")
public class EmployeeController {

    @PostMapping
    public void registerCustomer(@RequestBody Customer customer){
        System.out.println(customer);
    }
}
