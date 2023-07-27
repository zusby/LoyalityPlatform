package it.unicam.cs.ids.Purchase;

import it.unicam.cs.ids.Coupon.Coupon;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.FidelityProgram;
import it.unicam.cs.ids.Model.Rules.CashBackRule;
import it.unicam.cs.ids.Model.Rules.CouponRule;
import it.unicam.cs.ids.Model.Rules.LevelsRule;
import it.unicam.cs.ids.Model.Rules.PointsRule;
import it.unicam.cs.ids.Shop.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class PurchaseService {
    private final DBManager db;


    @Autowired
    public PurchaseService(DBManager db) {
        this.db = db;
    }

    public List<Purchase> getUserPurchases(String id) {
        try {
            return db.getUserPurchases(id);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public Purchase ApplyCoupon(Purchase purchase, String couponCode) {
        FidelityCard userFidelityCard = db.getFidelityCardByUserID(purchase.getUserID());

        List<Coupon> couponsByUser =db.getCouponsByUser(purchase.getUserID());


        for(Coupon coupon: couponsByUser){
            if(coupon.getCode().equals(couponCode)){
                Shop shop = db.getShop(purchase.getShopId());
                if (shop.getCouponRule() != null) {
                    shop.getCouponRule().setCoupon(coupon);
                    if(coupon.isUsed()){
                        throw new IllegalArgumentException();
                    }
                    shop.getCouponRule().applyRule(userFidelityCard, purchase);
                    coupon.setUsed(true);
                    db.updateCoupon(coupon);
                }
            }
        }
        System.out.println(purchase);
        return purchase;
    }

    public Purchase applyCashBack(Purchase purchase, double multiplier) {
        FidelityCard userFidelityCard = db.getFidelityCardByUserID(purchase.getUserID());
        System.out.println(purchase);
        double discount = userFidelityCard.getBalance() * multiplier;
        purchase.setDiscount(purchase.getDiscount() + discount);
        return purchase;
    }

    public void makePurchase(Purchase purchaseObj) {
        try {
            FidelityCard userFidelityCard = db.getFidelityCardByUserID(purchaseObj.getUserID());
            Shop shop = db.getShop(purchaseObj.getShopId());

            if (shop.getCashBackRule() != null) {
                shop.getCashBackRule().applyRule(userFidelityCard, purchaseObj);
            }
            if (shop.getLevelsRule() != null) {
                shop.getLevelsRule().applyRule(userFidelityCard, purchaseObj);
            }
            if (shop.getPointsRule() != null) {
                shop.getPointsRule().applyRule(userFidelityCard, purchaseObj);
            }
            purchaseObj.calculatePrice();
            db.registerPurchase(purchaseObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Purchase> getPurchases() {
        return this.db.getPurchases();
    }

    public void removePurchase(String id) {
        db.removePurchase(id);
    }
}
