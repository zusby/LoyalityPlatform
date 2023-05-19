package it.unicam.cs.ids.ShopOwner;

import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.Objects;

@Service
public class ShopOwnerService {
    private final DBManager db;

    @Autowired
    public ShopOwnerService(DBManager db) throws IOException {
        this.db = db;
    }

    public void addEmployee(Employee employee){
        db.registerEmployeeNoPassword(employee);
    }
}
