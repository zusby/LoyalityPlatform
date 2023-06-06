package it.unicam.cs.ids.ShopOwner;

import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ShopOwnerService {
    private final DBManager db;

    @Autowired
    public ShopOwnerService(DBManager db) throws IOException {
        this.db = db;
    }

    public boolean registerShopOwner(ShopOwner waiting) throws IOException {
        String id = waiting.getID();
        waiting.setRank(Role.SHOP_OWNER);
        db.registerShopOwnerNoPassword(waiting);
        return db.deleteShopOwnerFromRegistrationAcceptance(id);
    }

    public List<ShopOwner> getShopOwnerWaitingList() {
        return this.db.getShopOwnerRegistrations();
    }


    public ShopOwner getShopOwner(String id) {

        return db.getShopOwner(id);
    }

    public List<ShopOwner> getShopOwners() {
        return db.getShopOwners();
    }

    public List<ShopOwner> getShopOwnersByShopId(String shopId) {
        return db.getShopOwnersByShopId(shopId);
    }

    public void deleteShopOwner(String id) {
        db.deleteShopOwner(id);
    }

    public void registerShopOwnerWaitingList(ShopOwner shopOwner) {
        shopOwner.setRank(Role.UNACCEPTED_SHOP_OWNER);
        db.registerShopOwnerNoPassword(shopOwner);
    }
}
