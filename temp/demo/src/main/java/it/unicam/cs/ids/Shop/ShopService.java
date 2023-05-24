package it.unicam.cs.ids.Shop;

import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Model.Item;
import it.unicam.cs.ids.Model.PrizeAwards;
import it.unicam.cs.ids.Model.Rules.CashBackRule;
import it.unicam.cs.ids.Model.FidelityProgram;
import it.unicam.cs.ids.Model.Rules.CouponRule;
import it.unicam.cs.ids.Model.Rules.LevelsRule;
import it.unicam.cs.ids.Model.Rules.PointsRule;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void registerShop(Shop shop) {
        db.registerShop(shop);
    }

    public void test(FidelityProgram program) {

        if (program instanceof CashBackRule) {
            CashBackRule program1 = (CashBackRule) program;
            System.out.println(program1 + "is instance of Cashbackrule!");
        }

        System.out.println(program.toString());
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

    public void addCashBackRule(CashBackRule program, String id) {

        Shop shop = db.getShop(id);
        List<FidelityProgram> list = shop.getFidelityPrograms();

        for (FidelityProgram item : list) {
            if (Objects.equals(item.getProgramID(), program.getProgramID())) {
                throw new IllegalArgumentException("FidelityProgram already owned");
            }
        }
        list.add(program);
        shop.setFidelityPrograms(list);
        db.registerShop(shop);
    }

    public void addCouponRule(CouponRule program, String id) {
        Shop shop = db.getShop(id);
        List<FidelityProgram> list = shop.getFidelityPrograms();

        for (FidelityProgram item : list) {
            if (Objects.equals(item.getProgramID(), program.getProgramID())) {
                throw new IllegalArgumentException("FidelityProgram already owned");
            }
        }
        list.add(program);
        shop.setFidelityPrograms(list);
        db.registerShop(shop);
    }

    public void addPointsRule(PointsRule program, String id) {
        Shop shop = db.getShop(id);
        List<FidelityProgram> list = shop.getFidelityPrograms();

        for (FidelityProgram item : list) {
            if (Objects.equals(item.getProgramID(), program.getProgramID())) {
                throw new IllegalArgumentException("FidelityProgram already owned");
            }
        }
        list.add(program);
        shop.setFidelityPrograms(list);
        db.registerShop(shop);
    }

    public void addLevelRule(LevelsRule program, String id){
        Shop shop = db.getShop(id);
        List<FidelityProgram> list = shop.getFidelityPrograms();

        for (FidelityProgram item : list) {
            if (Objects.equals(item.getProgramID(), program.getProgramID())) {
                throw new IllegalArgumentException("FidelityProgram already owned");
            }
        }
        list.add(program);
        shop.setFidelityPrograms(list);
        db.registerShop(shop);
    }


}
