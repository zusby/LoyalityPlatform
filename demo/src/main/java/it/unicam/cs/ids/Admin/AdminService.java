package it.unicam.cs.ids.Admin;

import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Model.Address;
import it.unicam.cs.ids.Model.Role;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;
import it.unicam.cs.ids.ShopOwner.*;
@Service
public class AdminService {


    public List<Admin> getAdmins() {

        return null;
    }

    public boolean registerShopOwner(ShopOwner waiting) throws IOException {
        String id = waiting.getID();
        try {
            DBManager dbManager = new DBManager();
            waiting.setRank(Role.SHOP_OWNER);
            dbManager.registerShopOwner(waiting);
            return dbManager.removeShopOwnerFromRegistrationAcceptance(id);
        }catch(IOException e){e.printStackTrace();};

        return false;
    }
}
