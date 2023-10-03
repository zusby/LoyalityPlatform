package it.unicam.cs.ids.Colors;

import it.unicam.cs.ids.Database.DBManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class ColorService {
    private DBManager db;

    public ColorService() throws IOException {
        this.db = new DBManager();
    }

    public Color getColorFromID(String id) {
        return this.db.getColorFromID(id);
    }

    public void addColor(Color color){
        if(color.getId() == null){
            color.setId(UUID.randomUUID().toString());
        }
        if(color.getCreatedAt() == null){
            color.setCreatedAt(new Date());
        } else {
            color.setUpdatedAt(new Date());
        }
        db.registerColor(color);
    }

    public List<Color> getColorsFromShopID(String shopID) {
        try {
            return db.getShopColors(shopID);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteColor(String id, String shopID) {
        Color color = this.db.getColorFromID(id);
        if(color != null && color.getStoreID().equals(shopID)) {
            this.db.deleteColor(id);
        }
    }
}
