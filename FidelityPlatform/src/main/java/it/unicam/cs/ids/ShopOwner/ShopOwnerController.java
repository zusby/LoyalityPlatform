package it.unicam.cs.ids.ShopOwner;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/shopOwner")
public class ShopOwnerController {
    private final ShopOwnerService soService;

    @Autowired
    public ShopOwnerController(ShopOwnerService soService) {
        this.soService = soService;
    }

    @Operation(summary = "Register a shop owner from the waiting list")
    @PostMapping("/waiting-list/accept")
    public boolean registerShopOwner(@RequestBody ShopOwner waiting) {
        try {
            return soService.registerShopOwner(waiting);
        } catch (IOException e) {
            return false;
        }
    }

    @Operation(summary = "Register a shop owner in the waiting list")
    @PostMapping("/waiting-list/add")
    public void registerShopOwnerWaitingList(@RequestBody ShopOwner shopOwner) {
        this.soService.registerShopOwnerWaitingList(shopOwner);
    }

    @Operation(summary = "Get the list of shop owners in the waiting list")
    @GetMapping("/waiting-list")
    public List<ShopOwner> getShopOwnerWaitingList() {
        return this.soService.getShopOwnerWaitingList();
    }

    @Operation(summary = "Get a shop owner by their ID")
    @GetMapping("/{id}")
    public ShopOwner getShopOwner(@PathVariable String id) {
        return soService.getShopOwner(id);
    }

    @Operation(summary = "Get all shop owners")
    @GetMapping("/all")
    public List<ShopOwner> getShopOwners() {
        return soService.getShopOwners();
    }

    @Operation(summary = "Get shop owners by shop ID")
    @GetMapping("/{shopId}/shop-owners")
    public List<ShopOwner> getShopOwnersByShopId(@PathVariable String shopId) {
        return soService.getShopOwnersByShopId(shopId);
    }

    @Operation(summary = "Delete a shop owner by their ID")
    @DeleteMapping("/{id}/delete")
    public void deleteShopOwner(@PathVariable String id) {
        soService.deleteShopOwner(id);
    }

}
