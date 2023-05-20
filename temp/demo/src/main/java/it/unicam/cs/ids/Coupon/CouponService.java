package it.unicam.cs.ids.Coupon;

import it.unicam.cs.ids.Database.DBManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
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

    // Altri metodi per la logica di business dei coupon
}
