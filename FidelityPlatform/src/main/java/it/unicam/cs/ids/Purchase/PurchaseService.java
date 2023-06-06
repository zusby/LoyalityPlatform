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

    public List<Purchase> getUserPurchases(String id){
        try {
            return db.getUserPurchases(id);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


    public Purchase ApplyCoupon(Purchase purchase, String couponID) {
        FidelityCard userFidelityCard = db.getFidelityCardByUserID(purchase.getUserID());
        Coupon coupon = db.getCouponById(couponID);
        for (FidelityProgram program : db.getShop(purchase.getShopId()).getFidelityPrograms()) {
            if (program instanceof CouponRule) {
                ((CouponRule) program).setCoupon(coupon);
                ((CouponRule) program).applyRule(userFidelityCard, purchase);
            }
        }
        return purchase;
    }

    public Purchase applyCashBack(Purchase purchase, double multiplier) {
        FidelityCard userFidelityCard = db.getFidelityCardByUserID(purchase.getUserID());
        double discount = userFidelityCard.getBalance() * multiplier;
        purchase.setDiscount(purchase.getDiscount() + discount);
        return purchase;
    }

    public void makePurchase(Purchase purchaseObj) {
        try {
            FidelityCard userFidelityCard = db.getFidelityCardByUserID(purchaseObj.getUserID());
            Shop shop = db.getShop(purchaseObj.getShopId());

            for (FidelityProgram program : shop.getFidelityPrograms()) {
                if (program instanceof CashBackRule) {
                    ((CashBackRule) program).applyRule(userFidelityCard, purchaseObj);
                } else if (program instanceof LevelsRule) {
                    ((LevelsRule) program).applyRule(userFidelityCard, purchaseObj);
                } else if (program instanceof PointsRule) {
                    ((PointsRule) program).applyRule(userFidelityCard, purchaseObj);
                }
            }
            //TODO Dobbiamo implementare la generazione dei Coupon
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
