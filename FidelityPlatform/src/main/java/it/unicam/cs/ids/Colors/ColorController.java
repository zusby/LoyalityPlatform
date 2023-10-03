package it.unicam.cs.ids.Colors;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/color")
public class ColorController {
    private final ColorService service;

    @Autowired
    public ColorController(ColorService service){
        this.service = service;
    }

    @Operation(summary = "Get a Color from its ID")
    @GetMapping("/{id}")
    public Color getColorFromID(@PathVariable String id){
        return this.service.getColorFromID(id);
    }

    @PostMapping("/add")
    public void registerColor(@RequestBody Color color){
        this.service.addColor(color);
    }

    @GetMapping("/{shopID}/all")
    public List<Color> getShopColors(@PathVariable String shopID){
        return this.service.getColorsFromShopID(shopID);
    }

    @DeleteMapping("/{shopID}/{id}/delete")
    public void deleteColor(@PathVariable String id, @PathVariable String shopID){
        this.service.deleteColor(id, shopID);
    }
}
