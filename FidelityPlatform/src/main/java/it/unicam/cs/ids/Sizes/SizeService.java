package it.unicam.cs.ids.Sizes;

import it.unicam.cs.ids.Database.DBManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class SizeService {
    private final DBManager db;

    public SizeService() throws IOException {
        this.db = new DBManager();
    }

    public Size getSizeFromID(String id) {
        return this.db.getSizeFromID(id);
    }

    public void addSize(Size size){
        if(size.getId() == null){
            size.setId(UUID.randomUUID().toString());
        }
        if(size.getCreatedAt() == null){
            size.setCreatedAt(new Date());
        } else {
            size.setUpdatedAt(new Date());
        }
        db.registerSize(size);
    }

    public List<Size> getSizesFromShopID(String shopID) {
        try {
            return db.getShopSizes(shopID);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteSize(String id, String shopID) {
        Size size = this.db.getSizeFromID(id);
        if(size != null && size.getStoreID().equals(shopID)) {
            this.db.deleteSize(id);
        }
    }
}
