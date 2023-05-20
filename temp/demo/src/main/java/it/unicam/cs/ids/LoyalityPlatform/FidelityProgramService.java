package it.unicam.cs.ids.LoyalityPlatform;

import it.unicam.cs.ids.Database.DBManager;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FidelityProgramService {
    private final DBManager db;
    @Autowired
    public FidelityProgramService(DBManager db) {
        this.db = db;
    }

    public List<FidelityProgram> getPromos(String shopID){
        return db.getPromos(shopID);
    }



}
