package it.unicam.cs.ids.Employee;

import it.unicam.cs.ids.Customer.Customer;

import it.unicam.cs.ids.Purchase.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path= "/api/v1/employee")
public class EmployeeController {
    private final EmployeeService service;
    @Autowired
    public EmployeeController(EmployeeService service){
        this.service = service;
    }
    @PostMapping("/employees/add")
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }
    @GetMapping("/{shopId}")
    public List<Employee> getEmployees(@PathVariable String shopId){
        return this.service.getEmployees(shopId);
    }
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable String id){
       return  this.service.getEmployee(id);
    }
}
