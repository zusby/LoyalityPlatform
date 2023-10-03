package it.unicam.cs.ids.Images;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/image")
public class ImageController {
    private final ImageService service;

    @Autowired
    public ImageController(ImageService service){
        this.service = service;
    }

    @Operation(summary = "Get an Image from its ID")
    @GetMapping("/{id}")
    public Image getImageFromID(@PathVariable String id){
        return this.service.getImageFromID(id);
    }

    @PostMapping("/add")
    public void registerImage(@RequestBody Image image){
        this.service.addImage(image);
    }

    @PostMapping("/addList")
    public void RegisterImages(@RequestBody List<Image> images){
        this.service.registerImages(images);
    }

    @GetMapping("/{productID}/all")
    public List<Image> getProductImages(@PathVariable String productID){
        return this.service.getImagesByProductID(productID);
    }

    @DeleteMapping("/{productID}/delete/all")
        public void deleteProductImages(@PathVariable String productID){
        this.service.deleteProductImages(productID);
    }
    @DeleteMapping("/{id}/delete")
    public void deleteImage(@PathVariable String id){
        this.service.deleteImage(id);
    }
}
