package it.unicam.cs.ids.Admin;

import it.unicam.cs.ids.Database.DBManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {


    private final DBManager db;
    @Autowired
    public AdminService(DBManager db) {
        this.db = db;
    }

    public List<Admin> getAdmins() {
        return null;
    }

    public void updateAdmin(Admin admin) {
        this.db.updateAdmin(admin);
    }

    public void deleteAdmin(String id) {
        this.db.deleteAdmin(id);
    }

    public Admin getAdmin(String id) {
        return this.db.getAdmin(id);
    }

    public void addAdmin(Admin admin) {
        this.db.registerAdmin(admin);
    }
}
