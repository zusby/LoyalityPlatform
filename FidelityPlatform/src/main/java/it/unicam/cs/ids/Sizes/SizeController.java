package it.unicam.cs.ids.Sizes;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/size")
@RestController
public class SizeController {
    private final SizeService service;

    @Autowired
    public SizeController(SizeService service){
        this.service = service;
    }

    @Operation(summary = "Get a Size from its ID")
    @GetMapping("/{id}")
    public Size getSizeFromID(@PathVariable String id){
        return this.service.getSizeFromID(id);
    }

    @PostMapping("/add")
    public void registerSize(@RequestBody Size size){
        System.out.println(size);
        this.service.addSize(size);
    }

    @GetMapping("/{shopID}/all")
    public List<Size> getShopSizes(@PathVariable String shopID){
        return this.service.getSizesFromShopID(shopID);
    }

    @DeleteMapping("/{shopID}/{id}/delete")
    public void deleteSize(@PathVariable String id, @PathVariable String shopID){
        this.service.deleteSize(id, shopID);
    }
}
