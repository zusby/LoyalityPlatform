package it.unicam.cs.ids.Customer;

import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.Item;
import it.unicam.cs.ids.Model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService service){
        this.customerService = service;
    }

    @GetMapping("/{id}/fidelityCard")
    public FidelityCard getFidelityCard(@PathVariable String id){
        return customerService.getFidelityCard(id);
    }
    @GetMapping
    public List<Customer> getCustomers(){
       return customerService.getCustomers();
    }
    @GetMapping("/{id}")
    public List<Purchase> getPurchases(@PathVariable String id){
        return customerService.getPurchases(id);
    }

    @PostMapping("/{shopId}/{customerId}/purchase")
    public void makePurchase(@RequestBody List<Item> items, @PathVariable String customerId, @PathVariable String shopId) {
        customerService.makePurchase(items, customerId, shopId);
    }

}
