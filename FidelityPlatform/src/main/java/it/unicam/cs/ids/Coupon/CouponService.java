package it.unicam.cs.ids.Coupon;

import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CouponService {
    private final DBManager db;

    public CouponService() throws IOException {
        this.db = new DBManager();
    }

    public List<Coupon> getCoupons() {
        try {
            return db.getCoupons();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Coupon getCouponById(String id) {
        return db.getCouponById(id);
    }

    public boolean addCoupon(Coupon coupon) {

        Coupon coupon1 = db.getCouponById(coupon.getCouponId());

        if (coupon1 == null) {
            db.addCoupon(coupon);
            return true;
        }
        return false;
    }

    public boolean removeCoupon(String id) {
        if(db.getCouponById(id) != null){
            db.deleteCoupon(id);
            return true;
        }
        return false;
    }

    public void updateCoupon(String id, Date newExpireDate) {
        Coupon coupon = this.getCouponById(id);
        coupon.setExpirationDate(newExpireDate);
        db.updateCoupon(coupon);
    }

    public List <Coupon> getCouponsByUserId(String id) {
        return db.getCouponsByUser(id);
    }



    public void generateCoupon(Coupon coupon, String shopId) {
        List<FidelityCard> fidelityCards = db.getFidelityCardByShopID(shopId);
        for (FidelityCard customer: fidelityCards ) {
            coupon.setOwnerId(customer.getCardOwnerId());
            db.addCoupon(coupon);
        }
    }
    // Altri metodi per la logica di business dei coupon
}
