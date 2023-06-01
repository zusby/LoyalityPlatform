package it.unicam.cs.ids.Admin;

import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Customer.CustomerService;
import it.unicam.cs.ids.ShopOwner.ShopOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/admin/")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService service){
        this.adminService = service;
    }

    @GetMapping
    public List<Admin> getAdmins(){
        return adminService.getAdmins();
    }

    public boolean registerShopOwner(ShopOwner waiting) {
        try {
            return adminService.registerShopOwner(waiting);
        } catch (IOException e) {
            return false;
        }
    }

    public List<ShopOwner> getShopOwnerWaitingList(){
        return this.adminService.getShopOwnerWaitingList();
    }
}
