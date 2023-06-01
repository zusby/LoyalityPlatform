package it.unicam.cs.ids.Admin;

import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import it.unicam.cs.ids.ShopOwner.*;
@Service
public class AdminService {


    private final DBManager db;
    @Autowired
    public AdminService(DBManager db) {
        this.db = db;
    }

    public List<Admin> getAdmins() {
        return null;
    }

    public boolean registerShopOwner(ShopOwner waiting) throws IOException {
        String id = waiting.getID();
        waiting.setRank(Role.SHOP_OWNER);
        db.registerShopOwner(waiting);
        return db.removeShopOwnerFromRegistrationAcceptance(id);

    }

    public List<ShopOwner> getShopOwnerWaitingList() {
        return this.db.getShopOwnerRegistrations();
    }
}
