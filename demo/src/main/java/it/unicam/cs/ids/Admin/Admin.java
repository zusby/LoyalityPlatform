package it.unicam.cs.ids.Admin;

import com.google.cloud.Timestamp;

import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Model.AuthenticatedUser;
import it.unicam.cs.ids.ShopOwner.ShopOwner;
import it.unicam.cs.ids.Model.User;
import it.unicam.cs.ids.Model.Address;
import it.unicam.cs.ids.Model.Purchase;
import it.unicam.cs.ids.Model.Role;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Admin extends ShopOwner implements User, AuthenticatedUser {

    public Admin() {

    }

    public Admin(String name, String surname, Timestamp bdt, String telephoneNumber, String email, String id, Address address) {
        super(name, surname, bdt, telephoneNumber, email, id, address);
    }

    private String username;
    private boolean permission;
    private String name;
    private String surname;
    private Timestamp birthdate;
    private String telephoneNumber;
    private String email;
    private Address address;

    private String id;
    private Date lastLogin;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public Timestamp getBirthDate() {
        return this.birthdate;
    }

    @Override
    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public Address getAddress() {
        return this.address;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public Date getLastLogin() {
        return this.lastLogin;
    }
}
