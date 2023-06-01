package it.unicam.cs.ids.ShopOwner;

import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Employee.Employee;
import it.unicam.cs.ids.Employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path ="api/v1/shopOwner")
public class ShopOwnerController {
    private final ShopOwnerService soService;
    private final EmployeeService emplService;
    @Autowired
    public ShopOwnerController(ShopOwnerService soService, EmployeeService emplService) {
        this.soService = soService;
        this.emplService = emplService;
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee){
       soService.addEmployee(employee);
    }
    @GetMapping("/{shopId}/employees")
    public List<Employee> getEmployees(@PathVariable String shopId){
        return this.soService.getEmployees(shopId);
    }
    //TODO add generateCoupon
    @PostMapping
    public void registerCustomer(@RequestBody Customer customer){
        emplService.registerCustomer(customer);
    }



}
