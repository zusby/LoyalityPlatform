package it.unicam.cs.ids.Employee;

import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Database.DBManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Service
public class EmployeeService {
    private final DBManager db;

    @Autowired
    public EmployeeService(DBManager db){
        this.db = db;
    }


    public void registerCustomer(Customer customer){
        db.registerCustomerNoPassword(customer);
    }
}
