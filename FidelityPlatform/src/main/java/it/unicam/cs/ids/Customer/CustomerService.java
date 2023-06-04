package it.unicam.cs.ids.Customer;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Coupon.Coupon;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.FidelityProgram;
import it.unicam.cs.ids.Model.Item;
import it.unicam.cs.ids.Model.Purchase;
import it.unicam.cs.ids.Model.Rules.CashBackRule;
import it.unicam.cs.ids.Model.Rules.CouponRule;
import it.unicam.cs.ids.Model.Rules.LevelsRule;
import it.unicam.cs.ids.Model.Rules.PointsRule;
import it.unicam.cs.ids.Shop.Shop;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class CustomerService  {

    private final DBManager db;

    public CustomerService() throws IOException {
        this.db = new DBManager();
    }

    public  void updateProfile(Customer customer) {
        db.updateCustomerProfile(customer);
    }


    public List<Customer> getCustomers() {
        try {
            return db.getCustomers();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    public List<Purchase> getPurchases(String id){
        try {
            return db.getPurchases(id);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public FidelityCard getFidelityCard(String id) {
        return db.getFidelityCardByUserID(id);
    }


    public Purchase ApplyCoupon(Purchase purchase, String couponID){
        FidelityCard userFidelityCard = db.getFidelityCardByUserID(purchase.getUserID());
        Coupon coupon = db.getCouponById(couponID);
        for(FidelityProgram program: db.getShop(purchase.getShopId()).getFidelityPrograms()){
            if(program instanceof CouponRule){
                ((CouponRule) program).setCoupon(coupon);
                ((CouponRule) program).applyRule(userFidelityCard,purchase);
            }
        }
        return purchase;
    }
    public Purchase applyCashBack(Purchase purchase, double multiplier) {
        FidelityCard userFidelityCard = db.getFidelityCardByUserID(purchase.getUserID());
        double discount = userFidelityCard.getBalance()*multiplier;
        purchase.setDiscount(purchase.getDiscount()+discount);
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

    /**
     * This function returns a customer object from a database based on the provided ID.
     *
     * @param id The parameter "id" is a String that represents the unique identifier of a customer. This method retrieves
     * the customer object from the database based on the provided id.
     * @return A `Customer` object is being returned. The `getCustomer` method takes a `String` parameter `id` and
     * retrieves the corresponding `Customer` object from the database (`db`) and returns it.
     */
    public Customer getCustomer(String id) {
        return db.getCustomer(id);
    }

}
