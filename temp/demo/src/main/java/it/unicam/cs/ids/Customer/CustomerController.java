package it.unicam.cs.ids.Customer;

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
    private CustomerController(CustomerService service){
        this.customerService = service;
    }


    @GetMapping("/")
    private List<Customer> getCustomers(){
       return customerService.getCustomers();
    }
    @GetMapping("/{id}")
    private List<Purchase> getPurchases(@PathVariable String id){
        return customerService.getPurchases(id);
    }


    @PostMapping("{id}/getPurchase")
    private void makePurchase(@RequestBody List<Item> items, @PathVariable String id){
        customerService.previewPurchase(id, items);
    }

}
