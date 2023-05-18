package it.unicam.cs.ids.Employee;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Model.*;

import java.util.Date;


public class Employee extends Customer implements AuthenticatedUser {



    public Employee(String name, String surname, Timestamp bdt, String telephoneNumber, String email, String id,Address address){
        super(name,surname,bdt,telephoneNumber,email,id,address);

    }
    public Employee(){

    }

    @Override
    public Date getLastLogin() {
        return null;
    }

    @Override
    public void logout() {

    }
}
