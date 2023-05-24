package it.unicam.cs.ids.Admin;

import com.google.cloud.Timestamp;

import it.unicam.cs.ids.ShopOwner.ShopOwner;
import it.unicam.cs.ids.Model.User;
import it.unicam.cs.ids.Model.Address;

import java.util.Date;

public class Admin extends ShopOwner {

    public Admin() {

    }

    public Admin(String name, String surname, Timestamp bdt, String telephoneNumber, String email, String id, Address address) {
        super(name, surname, bdt, telephoneNumber, email, id, address);
    }






}
