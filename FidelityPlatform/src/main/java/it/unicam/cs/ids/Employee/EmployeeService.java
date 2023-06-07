package it.unicam.cs.ids.Employee;

import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Model.Role;
import it.unicam.cs.ids.Purchase.Purchase;
import it.unicam.cs.ids.Shop.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {

    private final DBManager db;

    @Autowired
    public EmployeeService(DBManager db) throws IOException {
        this.db = db;
    }

    public void addEmployee(Employee employee, String shopId){
        db.registerEmployeeNoPassword(employee);
        Shop shop = db.getShop(shopId);
        shop.addEmployee(employee.getID());
        db.registerShop(shop);
    }

    public List<Employee> getEmployees(String shopId) {
        return  db.getEmployees(shopId);
    }

    public Employee getEmployee(String id) {
        return db.getEmployee(id);
    }

    public void deleteEmployee(String id) {
        this.db.deleteEmployee(id);
    }

    public void updateEmployee(Employee employee) {
        this.db.updateEmployee(employee);
    }
}
