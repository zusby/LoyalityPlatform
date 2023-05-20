package it.unicam.cs.ids.Customer;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.LoyalityPlatform.CashBackRule;
import it.unicam.cs.ids.Model.Address;
import it.unicam.cs.ids.Model.Item;
import it.unicam.cs.ids.Model.Purchase;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class CustomerService {

    private final DBManager db;
    @Autowired
    public CustomerService(DBManager db) throws IOException {
        this.db = db;
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

    public Purchase previewPurchase(String id ,List<Item> items ){
        Purchase purchase = new Purchase(UUID.randomUUID().toString(),Timestamp.now(),id,items);

        return purchase;
    }

}
