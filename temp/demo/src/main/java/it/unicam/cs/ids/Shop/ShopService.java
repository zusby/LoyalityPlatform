package it.unicam.cs.ids.Shop;

import it.unicam.cs.ids.Database.DBManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
