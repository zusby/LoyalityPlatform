package it.unicam.cs.ids.Coupon;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/coupon")
public class CouponController {
    private final CouponService couponService;

    @Autowired
    public CouponController(CouponService service){
        this.couponService = service;
    }

    @GetMapping("/")
    public List<Coupon> getCoupons() {
        return couponService.getCoupons();
    }

    @GetMapping("/{id}")
    public Coupon getCouponById(@PathVariable String id) {
        return couponService.getCouponById(id);
    }

}

