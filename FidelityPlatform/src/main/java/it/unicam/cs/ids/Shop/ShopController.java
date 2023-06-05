package it.unicam.cs.ids.Shop;


import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.FidelitySpace;
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

    /**
     * This Java function registers a shop by accepting a Shop object as a request body and passing it to a service method.
     *
     * @param shop The parameter "shop" is of type Shop and is annotated with @RequestBody. This means that the data for
     * this parameter will be obtained from the request body of the HTTP POST request. The registerShop() method of the
     * service object will be called with this parameter to register a new shop.
     */
    @PostMapping
    public void registerShop(@RequestBody Shop shop){
        System.out.println(shop);
        service.registerShop(shop);
    }

    /**
     * This Java function adds a cashback rule to a program with a specified ID.
     *
     * @param program The program parameter is of type CashBackRule and is annotated with @RequestBody. This means that the
     * parameter will be deserialized from the request body of the HTTP POST request. The CashBackRule object represents a
     * cashback rule that will be added to the system.
     * @param id The "id" parameter is a path variable that is used to identify a specific resource or object in the
     * system. It is used in the URL of the API endpoint to specify which resource the request is targeting. In this case,
     * it is used to identify the specific program to which the cashback rule
     */
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

    @PutMapping("/{shopId}/prizes/modify")
    public void updatePrize(@PathVariable String shopId, @RequestBody Item item){
        this.service.updatePrize(shopId,item);
    }
    @DeleteMapping("/{shopId}/prizes/delete")
    public void deletePrize(@PathVariable String shopId, @RequestBody Item item){
        this.service.removePrize(shopId,item);
    }


    @GetMapping("/{shopOwnerID}/shops")
    public List<Shop> getShopsByOwnerID(@PathVariable String shopOwnerID){
        return service.getShopsByOwnerID(shopOwnerID);
    }
    @GetMapping("/{shopID}/fidelity-space")
    public FidelitySpace getFidelitySpace(@PathVariable String shopID){
        return this.service.getFidelitySpace(shopID);
    }

    @PutMapping("/{shopID}/fidelity-space/update")
    public void updateFidelitySpace(@RequestBody FidelitySpace space, @PathVariable String shopID){
        this.service.updateFidelitySpace(space,shopID);
    }

    @GetMapping("/{shopID}/fidelitycards")
    public List<FidelityCard> getFidelityCardByShopID(@PathVariable String shopID){
        return this.service.getFidelityCardByShopID(shopID);
    }
}
