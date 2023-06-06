package it.unicam.cs.ids.Customer;

import it.unicam.cs.ids.Coupon.Coupon;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.FidelityProgram;
import it.unicam.cs.ids.Purchase.Purchase;
import it.unicam.cs.ids.Model.Rules.CashBackRule;
import it.unicam.cs.ids.Model.Rules.CouponRule;
import it.unicam.cs.ids.Model.Rules.LevelsRule;
import it.unicam.cs.ids.Model.Rules.PointsRule;
import it.unicam.cs.ids.Shop.Shop;
import org.springframework.stereotype.Service;

import java.io.IOException;
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


    public FidelityCard getFidelityCard(String id) {
        return db.getFidelityCardByUserID(id);
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

    public void deleteCustomer(String id) {
        db.deleteCustomer(id);
    }


    public void registerCustomer(Customer customer){
        db.registerCustomerNoPassword(customer);
    }

    public Customer getCustomerByEmail(String email) {
        return db.getUserByEmail(email);
    }
}
