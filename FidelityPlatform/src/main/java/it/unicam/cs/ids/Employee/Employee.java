package it.unicam.cs.ids.Employee;

import com.google.cloud.Timestamp;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.lang.annotation.Documented;
import java.util.Date;
import java.util.StringJoiner;


public class Employee extends Customer {



    public Employee(String name, String surname, Timestamp bdt, String telephoneNumber, String email, String id, Address address){
        super(name,surname,bdt,telephoneNumber,email,id,address);

    }
    public Employee(){
    }

    @Override
    public String toString() {
        return "Employee{} " + super.toString();
    }
}
