package it.unicam.cs.ids.Products;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service){
        this.service = service;
    }

    @Operation(summary = "Get a Product from its ID")
    @GetMapping("/{id}")
    public Product getProductFromID(@PathVariable String id){
        return this.service.getProductFromID(id);
    }

    @PostMapping("/add")
    public void registerProduct(@RequestBody Product product){
        System.out.println(product);
        this.service.addProduct(product);

    }

    @GetMapping("/{storeID}/all")
    public List<Product> getStoreProducts(@PathVariable String storeID){
        return this.service.getProductsByStoreID(storeID);
    }
    @GetMapping("/{storeID}/featured/all")
    public List<Product> getStoreFeaturedProducts(@PathVariable String storeID){
        return this.service.getFeaturedProductsByStoreID(storeID);
    }
    @GetMapping("/category/{categoryID}/all")
    public List<Product> getProductsFromCategory(@PathVariable String categoryID){
        return this.service.getProductsFromCategory(categoryID);
    }

    @GetMapping("/{storeID}/available/all")
    public List<Product> getAvailableProducts(@PathVariable String storeID){
        return this.service.getAvailableProducts(storeID);
    }


    @DeleteMapping("/{storeID}/{id}/delete")
    public void deleteProduct(@PathVariable String id, @PathVariable String storeID){
        this.service.deleteProduct(id, storeID);
    }

    @GetMapping("/{storeID}/archived/all")
    public List<Product> getArchivedProducts(@PathVariable String storeID){
        return this.service.getArchivedProducts(storeID);
    }

    @GetMapping("/{storeID}/paid/all")
    public List<Product> getPaidProducts(@PathVariable String storeID){
        return this.service.getPaidProducts(storeID);
    }



}
