package it.unicam.cs.ids.Categories;

import it.unicam.cs.ids.Database.DBManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class CategoryService {
    private DBManager db;

    public CategoryService() throws IOException {
        this.db= new DBManager();
    }

    public List<Category> getStoreCategories(String shopID) {
        try {
            return  db.getStoreCategories(shopID);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(null);
    }

    public Category getCategory(String id) {
        return this.db.getCategory(id);
    }

    public void deleteCategory(String id, String shopID) {
        Category category = this.db.getCategory(id);
        if(category!=null&&category.getStoreID().equals(shopID)){
            this.db.deleteCategory(id);
        }

    }

    public void registerCategory(Category category) {
        System.out.println(category);
        if(category.getId()==null){
            category.setId(UUID.randomUUID().toString());
        }
        if(category.getCreatedAt()==null){
            category.setCreatedAt(new Date());
        }else{
            category.setUpdatedAt(new Date());
        }

        db.registerCategory(category);
    }

    public List<Category> getCategoryFromBillboard(String billboardID) {
        return this.db.getCategoriesByBillboard(billboardID);
    }
}
