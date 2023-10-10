package it.unicam.cs.ids.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    private final OrderService service;
    @Autowired
    public OrderController(OrderService service){
        this.service=service;
    }

    @PostMapping("/checkout")
    public void registerOrder(@RequestBody Order order){
        this.service.registerOrder(order);

    }

    @GetMapping("/{storeID}/all")
    public List<Order> getOrders(@PathVariable String storeID){
        return this.service.getOrders(storeID);
    }

    @GetMapping("/{orderID}")
    public Order getOrder(@PathVariable String orderID){
        return this.service.getOrder(orderID);
    }

    @GetMapping("/{storeID}/revenue/all")
    public BigDecimal getTotalRevenue(@PathVariable String storeID){
        return this.service.getTotalRevenue(storeID);
    }

    @GetMapping("/{storeID}/paid/all")
    public List<Order> getPaidOrders(@PathVariable String storeID){
        return this.service.getPaidOrders(storeID);
    }


}
