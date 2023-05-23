package it.unicam.cs.ids.Coupon;

import it.unicam.cs.ids.Database.DBManager;
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
        try {
            return db.getCouponById(id);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean addCoupon(@NotNull Coupon coupon) {

        try {
            Coupon coupon1 = db.getCouponById(coupon.getId());

            if (coupon1 == null) {
                db.addCoupon(coupon);
                return true;
            }
            return false;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removeCoupon(String id) {
        try {
            if(db.getCouponById(id) != null){
                db.deleteCoupon(id);
                return true;
            }
            return false;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCoupon(String id, Date newExpireDate) {
        Coupon coupon = this.getCouponById(id);
        coupon.setExpirationDate(newExpireDate);
        db.updateCoupon(coupon);
    }


    // Altri metodi per la logica di business dei coupon
}
