package it.unicam.cs.ids.Employee;

import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path= "/api/v1/employee")
public class EmployeeController {
    private final EmployeeService service;
    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }

    @PostMapping
    public void registerCustomer(@RequestBody Customer customer){
        service.registerCustomer(customer);
    }

    @PostMapping("/purchase/add")
    public void registerPurchase(@RequestBody Purchase purchase){
        service.registerPurchase(purchase);
    }
}
