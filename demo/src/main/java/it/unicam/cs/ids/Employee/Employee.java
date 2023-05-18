package it.unicam.cs.ids.Employee;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Model.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Employee implements User, AuthenticatedUser {

    private String name;
    private String surname;
    private Timestamp birthdate;
    private String telephoneNumber;
    private String email;
    private Address address;
    private String id;

    public Employee(String name, String surname, Timestamp bdt, String telephoneNumber, String email, String id,Address address){
        this.name=name;
        this.surname = surname;
        this.birthdate=bdt;
        this.telephoneNumber=telephoneNumber;
        this.email=email;
        this.id=id;
        this.address=address;
    }
    public Employee(){

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
    public Address getAddress() {
        return this.address;
    }

    @Override
    public String getID() {
        return this.id;
    }



    @Override
    public Date getLastLogin() {
        return null;
    }

    @Override
    public void logout() {
    }
}
