package it.unicam.cs.ids.Employee;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "registers a new Employee")
    public void addEmployee(@RequestBody Employee employee){
        service.addEmployee(employee);
    }
    @GetMapping("/{shopId}")
    @Operation(summary = "get all Employees")
    public List<Employee> getEmployees(@PathVariable String shopId){
        return this.service.getEmployees(shopId);
    }
    @GetMapping("/{id}")
    @Operation(summary = "get an employee by its ID")
    public Employee getEmployee(@PathVariable String id){
       return  this.service.getEmployee(id);
    }
    @DeleteMapping("/{id}/delete")
    @Operation(summary = "delete employee")
    public void deleteEmployee(@PathVariable String id){
        this.service.deleteEmployee(id);
    }

    @PutMapping("/update")
    @Operation(summary = "update employee's profile")
    public void updateEmployee(@RequestBody Employee employee){
        this.service.updateEmployee(employee);
    }
}
