package it.unicam.cs.ids.Customer;



import io.swagger.v3.oas.annotations.Operation;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.Purchase;
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

    @PutMapping("/{id}/update")
    public void modifyCustomerProfile(@RequestBody Customer customer){
        customerService.updateProfile(customer);
    }
}
