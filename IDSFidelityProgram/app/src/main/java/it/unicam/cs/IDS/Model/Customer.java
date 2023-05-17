package it.unicam.cs.IDS.Model;

import com.google.cloud.Timestamp;
import it.unicam.cs.IDS.DataBase.DBManager;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class Customer implements User, AuthenticatedUser{
    private Role rank = Role.CUSTOMER;
    private final String name,surname,telephoneNumber,email;
    private final Address address;
    private final Timestamp birthDate;
    private UUID ID;
    private String password;
    private List<Purchase> purchaseHistory;

    @Deprecated
    public Customer (){
        this.address = null;
        this.birthDate=null;
        this.name = null;
        this.surname = null;
        this.telephoneNumber = null;
        this.email = null;
        this.ID = null;
    }

    public Customer(String name, String surname, String telephoneNumber, String email, Address address, UUID id, GregorianCalendar date) {
        this.address = address;
        this.birthDate=Timestamp.of(date.getTime());
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.ID = id;
    }
    public Customer(String password, String name, String surname, String telephoneNumber, String email, Address address, UUID id, GregorianCalendar date) {
        this.password = password;
        this.address = address;
        this.birthDate=Timestamp.of(date.getTime());
        this.name = name;
        this.surname = surname;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.ID = id;
    }


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
        return this.birthDate;
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

    private void retrievePurchaseHistory(){
        try {
            DBManager s = new DBManager();
            this.purchaseHistory= s.getPurchases(this.ID.toString());
        } catch (IOException | ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
    }


    public List<Purchase> getPurchaseHistory(){
        return this.purchaseHistory;
    }


    public void setPurchaseHistory(List<Purchase> purchases){
        this.purchaseHistory = purchases;
    }


    @Override
    public String getID() {
        return this.ID.toString();
    }


    public void setID(String ID) {
        this.ID = UUID.fromString(ID);
    }


    public Role getRank() {
        return rank;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public Date getLastLogin() {
        return null;
    }



    @Override
    public boolean hasPermission(String permission) {
        return false;
    }

    @Override
    public void logout() {

    }

    @Override
    public String toString() {
        return "Customer{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", birthDate=" + this.birthDate +
                ", ID=" + ID +
                '}';
    }


}
