package it.unicam.cs.ids.Customer;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService service) {
        this.customerService = service;
    }

    @GetMapping("/all")
    @Operation(summary = "Get a list of all customers", description = "Retrieve a JSON array of objects of type Customer")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/{customerId}")
    @Operation(summary = "Get a customer by ID", description = "Retrieve a JSON object representing a Customer")
    public Customer getCustomer(@PathVariable String customerId) {
        return this.customerService.getCustomer(customerId);
    }

    @PutMapping("/{id}/update")
    @Operation(summary = "Modify customer profile", description = "Update the profile of a customer")
    public void modifyCustomerProfile(@RequestBody Customer customer) {
        System.out.println(customer);
        customerService.updateProfile(customer);
    }

    @DeleteMapping("/{id}/delete")
    @Operation(summary = "Delete a customer", description = "Delete a customer by ID")
    public void deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new customer", description = "Register a new customer")
    public void registerCustomer(@RequestBody Customer customer) {
        customerService.registerCustomer(customer);

    }


    @GetMapping("/{email}/")
    @Operation(summary = "Return a customer by email", description = "Return a customer by email")
    public Customer getCustomerByEmail(@PathVariable String email){
        return this.customerService.getCustomerByEmail(email);
    }


}
