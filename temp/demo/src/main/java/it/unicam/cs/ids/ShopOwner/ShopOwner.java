package it.unicam.cs.ids.ShopOwner;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Employee.Employee;
import it.unicam.cs.ids.Model.*;

import java.io.IOException;

import java.util.Date;


public class ShopOwner extends Employee implements User {

    private Role rank = Role.UNACCEPTED_SHOP_OWNER;

    public ShopOwner() {
    }

    public ShopOwner(String name, String surname, Timestamp bdt, String telephoneNumber, String email, String id, Address address) {
        super(name, surname, bdt, telephoneNumber, email, id, address);
    }

    public Role getRank() {
        return rank;
    }

    public void setRank(Role rank) {
        this.rank = rank;
    }


    @Override
    public String toString() {
        return "ShopOwner{" +
                "rank=" + rank +
                "} " + super.toString();
    }
}
