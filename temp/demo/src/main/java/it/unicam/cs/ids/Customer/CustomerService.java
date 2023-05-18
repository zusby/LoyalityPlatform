package it.unicam.cs.ids.Customer;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Model.Address;
import it.unicam.cs.ids.Model.Purchase;
import org.checkerframework.checker.units.qual.A;
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
}
