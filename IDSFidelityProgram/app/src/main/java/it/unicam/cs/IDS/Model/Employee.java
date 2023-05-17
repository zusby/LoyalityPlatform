package it.unicam.cs.IDS.Model;

import com.google.cloud.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Employee implements User, AuthenticatedUser {

    private String username;
    private boolean permission;
    private String name;
    private String surname;
    private Timestamp birthdate;
    private String telephoneNumber;
    private String email;
    private Address address;
    private List<Purchase> purchaseHistory;
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
    public List<Purchase> getPurchaseHistory() {
        return this.purchaseHistory;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public Date getLastLogin() {
        return this.lastLogin;
    }

    @Override
    public void changePassword(String newPassword) {

    }

    @Override
    public boolean hasPermission(String permission) {
        return this.permission;
    }

    @Override
    public void logout() {
    }
}
