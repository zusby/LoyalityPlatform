package it.unicam.cs.ids.ShopOwner;

import it.unicam.cs.ids.Coupon.Coupon;
import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Employee.Employee;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ShopOwnerService {
    private final DBManager db;

    @Autowired
    public ShopOwnerService(DBManager db) throws IOException {
        this.db = db;
    }

    public void addEmployee(Employee employee){
        db.registerEmployeeNoPassword(employee);
    }

    public List<Employee> getEmployees(String shopId) {
       return  db.getEmployees(shopId);
    }

    public void generateCoupon(Coupon coupon, String shopId) {
        List<FidelityCard> fidelityCards = db.getFidelityCardByShopID(shopId);
        for (FidelityCard customer: fidelityCards ) {
            coupon.setOwnerId(customer.getCardOwnerId());
            db.addCoupon(coupon);
        }
    }
}
