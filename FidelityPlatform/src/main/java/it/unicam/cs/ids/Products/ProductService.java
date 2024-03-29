package it.unicam.cs.ids.Products;

import it.unicam.cs.ids.Database.DBManager;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class ProductService {
    private final DBManager db;

    public ProductService() throws IOException {
        this.db = new DBManager();
    }

    public Product getProductFromID(String id) {
        return this.db.getProductFromID(id);
    }

    public void addProduct(Product product){
        if(product.getId() == null){
            product.setId(UUID.randomUUID().toString());
        }
        if(product.getCreatedAt() == null){
            product.setCreatedAt(new Date());
        } else {
            product.setUpdatedAt(new Date());
        }
        db.registerProduct(product);
    }

    public List<Product> getFeaturedProductsByStoreID(String storeID) {

            List<Product> products= db.getProductsByStoreID(storeID);
        products.removeIf(product -> !product.getIsFeatured());
            return products;

    }
    public List<Product> getProductsByStoreID(String storeID){
        return this.db.getProductsByStoreID(storeID);
    }

    public void deleteProduct(String id, String storeID) {
        Product product = this.db.getProductFromID(id);
        if(product != null && product.getStoreID().equals(storeID)) {
            this.db.deleteProduct(id);
        }
    }

    public List<Product> getProductsFromCategory(String categoryID) {
        return this.db.getProductsFromCategory(categoryID);
    }

    public List<Product> getAvailableProducts(String storeID) {
        List<Product>  featured= getProductsByStoreID(storeID);

        featured.removeIf(Product::getIsArchived);
        return featured;
    }

    public List<Product> getArchivedProducts(String storeID) {
        List<Product> archived = getProductsByStoreID(storeID);
        archived.removeIf(product -> !product.getIsArchived());
        return archived;
    }

    public List<Product> getPaidProducts(String storeID) {
        return null;
    }
}
