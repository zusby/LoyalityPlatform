package it.unicam.cs.ids.Coupon;


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

    @GetMapping("/all")
    public List<Coupon> getCoupons() {
        return couponService.getCoupons();
    }

    @GetMapping("/{id}")
    public Coupon getCouponById(@PathVariable String id) {
        return couponService.getCouponById(id);
    }

    @PutMapping("/add")
    public ResponseEntity<Coupon> addCoupon(@RequestBody Coupon coupon){
       if(this.couponService.addCoupon(coupon)){
           return ResponseEntity.ok().build();
       }
       return ResponseEntity.status(400).build();
    }

    @PostMapping("/remove/{id}")
    public ResponseEntity<Coupon> removeCoupon(@PathVariable String id){
        if(this.couponService.removeCoupon(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public void updateCoupon(@PathVariable String id, @RequestBody Date newExpireDate){
        couponService.updateCoupon(id,newExpireDate);
    }

    @GetMapping("/{userId}/coupons")
    public List<Coupon> getCouponsByUserId(@PathVariable String userId){
        return couponService.getCouponsByUserId(userId);
    }


    /**
     * Method that allows the ShopOwner to generate coupons for all over his fidelity clients
     *
     * @param coupon the new coupon
     * @param shopId the id of the ShopOwner's  shop
     */
    @PostMapping("/coupon/generate")
    public void generateCoupon(@RequestBody Coupon coupon, String shopId){
        couponService.generateCoupon(coupon, shopId);
    }
}

