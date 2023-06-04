package it.unicam.cs.ids.Admin;

import it.unicam.cs.ids.ShopOwner.ShopOwner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService service){
        this.adminService = service;
    }

    @GetMapping("/all")
    public List<Admin> getAdmins(){
        return adminService.getAdmins();
    }

    @PutMapping("/waiting-list/accept")
    public boolean registerShopOwner(@RequestBody ShopOwner waiting) {
        try {
            return adminService.registerShopOwner(waiting);
        } catch (IOException e) {
            return false;
        }
    }

    @GetMapping("/waiting-list")
    public List<ShopOwner> getShopOwnerWaitingList(){
        return this.adminService.getShopOwnerWaitingList();
    }
}
