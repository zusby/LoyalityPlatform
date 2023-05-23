package it.unicam.cs.ids.Shop;

import it.unicam.cs.ids.Model.Rules.CashBackRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/shop")
public class ShopController {

    private final ShopService service;
    @Autowired
    public ShopController(ShopService service) {
        this.service = service;
    }

    @GetMapping
    public List<Shop> getShops(){
        return service.getShops();
    }

    @PostMapping
    public void registerShop(@RequestBody Shop shop){
        System.out.println(shop);
        service.registerShop(shop);
    }

    @PostMapping("/{id}")
    public void addCashBackRule(@RequestBody CashBackRule program, @PathVariable String id){

       service.addCashBackRule(program, id);
    }

}
