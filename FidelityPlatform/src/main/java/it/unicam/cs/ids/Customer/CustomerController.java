package it.unicam.cs.ids.Customer;


import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.Item;
import it.unicam.cs.ids.Model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService service) {
        this.customerService = service;
    }

    @GetMapping("/{id}/fidelityCard")
    public FidelityCard getFidelityCard(@PathVariable String id) {
        return customerService.getFidelityCard(id);
    }

    @Operation(summary = "get a list of all the customers", description = "retrieve a Json Array of objects of type Customer")
    @GetMapping("/all")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }


    @GetMapping("/{customerId}")
    @Operation(summary = "get a Customer by his ID", description = "retrieve a Json object representing a Customer")
    public Customer getCustomer(@PathVariable String customerId) {
        return this.customerService.getCustomer(customerId);
    }

    @GetMapping("/{customerId}/purchases")
    public List<Purchase> getPurchases(@PathVariable String customerId) {
        return customerService.getPurchases(customerId);
    }

    @GetMapping("/{couponID}/ApplyCoupon")
    public Purchase applyCoupon(@RequestBody Purchase purchase, @PathVariable String couponID){
        return customerService.ApplyCoupon(purchase,couponID);
    }

    @GetMapping("/applyCashBack")
    public Purchase applyCashBack(@RequestBody Purchase purchase, double multiplier){
        return customerService.applyCashBack(purchase,multiplier);
    }

    @PostMapping("/purchase")
    public void makePurchase(@RequestBody Purchase purchase) {
        customerService.makePurchase(purchase);
    }


}
