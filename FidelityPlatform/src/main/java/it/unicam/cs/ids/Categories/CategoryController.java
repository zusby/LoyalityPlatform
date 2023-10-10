package it.unicam.cs.ids.Categories;

import it.unicam.cs.ids.BillBoard.BillBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
    private final CategoryService service;
    @Autowired
    public CategoryController(CategoryService service){
        this.service = service;
    }
    @GetMapping("/{shopID}/all")
    public List<Category> getStoreCategories(@PathVariable String shopID){
        return this.service.getStoreCategories(shopID);
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable String id){
        return this.service.getCategory(id);
    }

    @DeleteMapping("/{shopID}/{id}/delete")
    public void deleteCategory(@PathVariable String id, @PathVariable String shopID){
        this.service.deleteCategory(id, shopID);
    }

    @GetMapping("/{billboardID}/billboards")
    public List<Category> getCategoryFromBillboard(@PathVariable String billboardID){
        return this.service.getCategoryFromBillboard(billboardID);
    }

    @PostMapping("/add")
    public void registerCategory(@RequestBody Category category){
        this.service.registerCategory(category);
    }



}
