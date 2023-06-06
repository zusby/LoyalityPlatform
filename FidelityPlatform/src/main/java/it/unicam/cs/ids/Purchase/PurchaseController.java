package it.unicam.cs.ids.Purchase;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/purchase")
public class PurchaseController {
    private final PurchaseService service;
    @Autowired
    public PurchaseController(PurchaseService service){
        this.service=service;
    }

    @GetMapping("/{customerId}/purchases")
    @Operation(summary = "Get user purchases")
    public List<Purchase> getUserPurchases(@PathVariable String customerId) {
        return service.getUserPurchases(customerId);
    }

    @GetMapping("/all")
    @Operation(summary = "Get all purchases")
    public List<Purchase> getPurchases() {
        return this.service.getPurchases();
    }

    @GetMapping("/{couponID}/ApplyCoupon")
    @Operation(summary = "Apply a coupon to a purchase")
    public Purchase applyCoupon(@RequestBody Purchase purchase, @PathVariable String couponID) {
        return service.ApplyCoupon(purchase, couponID);
    }

    @GetMapping("/applyCashBack/{multiplier}")
    @Operation(summary = "Apply cashback to a purchase")
    public Purchase applyCashBack(@RequestBody Purchase purchase, @PathVariable double multiplier) {
        return service.applyCashBack(purchase, multiplier);
    }

    @PostMapping("/add")
    @Operation(summary = "Register a purchase")
    public void registerPurchase(@RequestBody Purchase purchase) {
        service.makePurchase(purchase);
    }

    @DeleteMapping("/remove/{id}")
    @Operation(summary = "Remove a purchase")
    public void removePurchase(@PathVariable String id) {
        service.removePurchase(id);
    }


}
