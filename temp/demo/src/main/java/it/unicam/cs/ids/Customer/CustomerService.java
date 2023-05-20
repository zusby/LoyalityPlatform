package it.unicam.cs.ids.Customer;

import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.Item;
import it.unicam.cs.ids.Model.Purchase;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
public class CustomerService  {

    private final DBManager db;

    public CustomerService() throws IOException {
        this.db = new DBManager();
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

    /*public void makePurchase(Item... items){
        new Purchase(UUID.randomUUID(),Timestamp.from(Instant.now()),items);
    }*/

    public void makePurchase(Item[] purchase) {
        try {
            String customerId = purchase[0].getId().toString();
            FidelityCard fidelityCard = db.getFidelityCardByUserID(customerId);

            Date currentDate = new Date();
            Timestamp purchaseDate = new Timestamp(currentDate.getTime());

            // Creazione dell'oggetto Purchase
            Purchase purchaseObj = new Purchase(UUID.randomUUID().toString(), purchaseDate, customerId, Arrays.asList(purchase));
            fidelityCard.updateFidelityPoints(purchaseObj.getPrice());// Aggiorna i punti fedeltà sulla carta fedeltà
            db.registerPurchase(purchaseObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
