package it.unicam.cs.IDS.Model;

import com.google.cloud.Timestamp;
import it.unicam.cs.IDS.DataBase.AuthenticationController;
import it.unicam.cs.IDS.DataBase.DBManager;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

public class ShopOwner extends Employee implements User, AuthenticatedUser{
    private boolean permission;
    private String name;
    private String surname;
    private Timestamp birthdate;
    private String telephoneNumber;
    private String email;
    private List<Purchase> purchaseHistory;
    private String id;
    private Date lastLogin;
    private Role rank = Role.UNACCEPTED_SHOP_OWNER;


    public ShopOwner(String name, String surname, Timestamp birthdate, String telephoneNumber, String email, Address address, String id, Date lastLogin, Role rank) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.id = id;
        this.lastLogin = lastLogin;
        this.rank = rank;
    }



    @Deprecated
    public ShopOwner(){
    }

    public Role getRank() {
        return rank;
    }
    public void setRank(Role rank) {
        this.rank = rank;
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
    public String getID() {
        return this.id;
    }


    @Override
    public Date getLastLogin() {
        return this.lastLogin;
    }

    @Override
    public boolean hasPermission(String permission) {
        return this.permission;
    }

    @Override
    public void logout() {
    }




    public void addEmployee(Employee newEmployee) throws IOException {
        DBManager db = new DBManager();
        db.registerEmployeeNoPassword(newEmployee);

    }


}
