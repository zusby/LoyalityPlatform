package it.unicam.cs.ids.Shop;

import it.unicam.cs.ids.Coupon.Coupon;
import it.unicam.cs.ids.Model.Item;
import it.unicam.cs.ids.Model.Rules.CashBackRule;
import it.unicam.cs.ids.Model.Rules.CouponRule;
import it.unicam.cs.ids.Model.Rules.LevelsRule;
import it.unicam.cs.ids.Model.Rules.PointsRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @PostMapping("/{id}/cashback/add")
    public void addCashBackRule(@RequestBody CashBackRule program, @PathVariable String id){
       service.addCashBackRule(program, id);
    }

    @PostMapping("/{id}/coupon/add")
    public void addCouponRule(@PathVariable String id, @RequestBody CouponRule program){
        this.service.addCouponRule(program,id);
    }
    @PostMapping("/{id}/levels/add")
    public void addLevelRule(@PathVariable String id, @RequestBody LevelsRule program){
        this.service.addLevelRule(program,id);
    }


    @PostMapping("/{id}/points/add")
    public void addPointsRule(@PathVariable String id, @RequestBody PointsRule program){
        this.service.addPointsRule(program, id);
    }

    @GetMapping("/{shopId}/prizes")
    public Set<Item> getPrizes(@PathVariable String shopId) {
        return this.service.getPrizes(shopId);
    }
    @PostMapping("/{shopId}/prizes/add")
    public void addPrize(@PathVariable String shopId, @RequestBody Item item){
        this.service.addPrize(shopId,item);
    }

}
