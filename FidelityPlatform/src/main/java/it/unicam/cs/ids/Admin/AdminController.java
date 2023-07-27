package it.unicam.cs.ids.Admin;

import io.swagger.v3.oas.annotations.Operation;
import it.unicam.cs.ids.Employee.Employee;
import it.unicam.cs.ids.Employee.EmployeeService;
import it.unicam.cs.ids.ShopOwner.ShopOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    private final AdminService service;

    @Autowired
    public AdminController(AdminService service){
        this.service = service;
    }

    @GetMapping("/all")
    @Operation(summary = "get all Admins")
    public List<Admin> getAdmins(){
        return service.getAdmins();
    }

    @PostMapping("/add")
    @Operation(summary = "registers a new admin")
    public void addAdmin(@RequestBody Admin admin){
        service.addAdmin(admin);
    }

    @GetMapping("/{id}")
    @Operation(summary = "get an Admin by its ID")
    public Admin getAdmin(@PathVariable String id){
        return this.service.getAdmin(id);
    }
    @DeleteMapping("/{id}/delete")
    @Operation(summary = "delete an admin by its id")
    public void deleteAdmin(@PathVariable String id){
        this.service.deleteAdmin(id);
    }

    @PutMapping("/update")
    @Operation(summary = "update an admin profile")
    public void updateAdmin(@RequestBody Admin admin){
        this.service.updateAdmin(admin);
    }
}
