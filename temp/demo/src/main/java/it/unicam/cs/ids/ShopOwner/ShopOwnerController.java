package it.unicam.cs.ids.ShopOwner;

import it.unicam.cs.ids.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
@RequestMapping(path ="api/v1/shopOwner")
public class ShopOwnerController {
    private final ShopOwnerService soService;
    @Autowired
    public ShopOwnerController(ShopOwnerService soService) {
        this.soService = soService;
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee){
       soService.addEmployee(employee);
    }
}
