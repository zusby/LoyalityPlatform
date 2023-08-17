package it.unicam.cs.ids.Shop;

import it.unicam.cs.ids.Coupon.Coupon;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.FidelitySpace;
import it.unicam.cs.ids.Model.Item;
import it.unicam.cs.ids.Model.PrizeAwards;
import it.unicam.cs.ids.Model.Rules.CashBackRule;
import it.unicam.cs.ids.Model.FidelityProgram;
import it.unicam.cs.ids.Model.Rules.CouponRule;
import it.unicam.cs.ids.Model.Rules.LevelsRule;
import it.unicam.cs.ids.Model.Rules.PointsRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Service
public class ShopService {
    private final DBManager db;

    @Autowired
    public ShopService(DBManager db) {
        this.db = db;
    }

    public List<Shop> getShops() {
        return db.getShops();
    }

    /**
     * This function registers a shop by calling the registerShop method on a database object with the given shop object as
     * a parameter.
     *
     * @param shop The parameter "shop" is an object of the class "Shop". It is being passed as an argument to the method
     * "registerShop". The method is responsible for registering the shop object in the database.
     */
    public void registerShop(Shop shop) {
        db.registerShop(shop);
    }

    public Set<Item> getPrizes(String shopId) {
        return db.getShop(shopId).getPrizes().getAwards();
    }

    public void addPrize(String shopId, Item item) {
        Shop shop = db.getShop(shopId);
        PrizeAwards prizes = shop.getPrizes();
        prizes.addAward(item);
        shop.setPrizes(prizes);
        registerShop(shop);
    }

    public void updatePrize(String shopId, Item item) {
        Shop shop = db.getShop(shopId);
        PrizeAwards prizes = shop.getPrizes();
        prizes.removeAward(item);
        prizes.addAward(item);
        shop.setPrizes(prizes);
        registerShop(shop);
    }
    public void removePrize(String shopId, Item item) {
        Shop shop = db.getShop(shopId);
        PrizeAwards prizes = shop.getPrizes();
        prizes.removeAward(item);
        shop.setPrizes(prizes);
        registerShop(shop);
    }

    public void addCashBackRule(CashBackRule program, String id) {

        Shop shop = db.getShop(id);
        if(shop.getCashBackRule()!=null){
            throw new IllegalArgumentException("FidelityProgram already owned");
        }
        shop.setCashBackRule(program);
        db.registerShop(shop);
    }

    public void addCouponRule(CouponRule program, String id) {

        Shop shop = db.getShop(id);
        if(shop.getCouponRule()!=null){
            throw new IllegalArgumentException("FidelityProgram already owned");
        }
        shop.setCouponRule(program);
        db.registerShop(shop);
    }

    public void addPointsRule(PointsRule program, String id) {
        Shop shop = db.getShop(id);
        if(shop.getPointsRule()!=null){
            throw new IllegalArgumentException("FidelityProgram already owned");
        }
        shop.setPointsRule(program);
        db.registerShop(shop);
    }

    public void addLevelRule(LevelsRule program, String id){

        Shop shop = db.getShop(id);
        if(shop.getLevelsRule()!=null){
            throw new IllegalArgumentException("FidelityProgram already owned");
        }
        shop.setLevelsRule(program);
        db.registerShop(shop);
    }
    public List<Shop> getShopsByOwnerID(String shopOwnerID) {
        return db.getShopsByOwnerId(shopOwnerID);
    }
    public FidelitySpace getFidelitySpace(String shopID) {
        return db.getFidelitySpace(shopID);
    }
    public void updateFidelitySpace(FidelitySpace space, String shopID) {
        db.updateFidelitySpace(space,shopID);
    }

    public void deleteShopOwner(String id) {
        db.deleteShopOwner(id);
    }

    public void deleteShop(String shopID) {
        db.deleteShop(shopID);
    }

    public Shop getShopByID(String shopId) {
        return db.getShop(shopId);
    }
}
