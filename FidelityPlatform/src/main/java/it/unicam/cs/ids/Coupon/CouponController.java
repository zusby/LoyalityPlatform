package it.unicam.cs.ids.Coupon;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/coupon")
public class CouponController {
    private final CouponService couponService;

    @Autowired
    public CouponController(CouponService service){
        this.couponService = service;
    }

    @Operation(summary = "Get all coupons")
    @GetMapping("/all")
    public List<Coupon> getCoupons() {
        return couponService.getCoupons();
    }

    @Operation(summary = "Get a coupon by ID")
    @GetMapping("/{id}")
    public Coupon getCouponById(@PathVariable String id) {
        return couponService.getCouponById(id);
    }

    @Operation(summary = "Add a new coupon")
    @PutMapping("/add")
    public ResponseEntity<Coupon> addCoupon(@RequestBody Coupon coupon) {
        if (this.couponService.addCoupon(coupon)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(400).build();
    }

    @Operation(summary = "Remove a coupon by ID")
    @PostMapping("/remove/{id}")
    public ResponseEntity<Coupon> removeCoupon(@PathVariable String id) {
        if (this.couponService.removeCoupon(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Update a coupon's expiration date")
    @PutMapping("/{id}")
    public void updateCoupon(@PathVariable String id, @RequestBody Date newExpireDate) {
        couponService.updateCoupon(id, newExpireDate);
    }

    @Operation(summary = "Get coupons by user ID")
    @GetMapping("/{userId}/coupons")
    public List<Coupon> getCouponsByUserId(@PathVariable String userId) {
        return couponService.getCouponsByUserId(userId);
    }

    @Operation(summary = "Generate a coupon for all fidelity clients of a shop")
    @PostMapping("/coupon/generate")
    public void generateCoupon(@RequestBody Coupon coupon, String shopId) {
        couponService.generateCoupon(coupon, shopId);
    }
}

