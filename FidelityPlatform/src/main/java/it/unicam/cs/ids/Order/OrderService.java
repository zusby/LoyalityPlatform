package it.unicam.cs.ids.Order;

import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Model.OrderItem;
import it.unicam.cs.ids.Products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final DBManager db;
    @Autowired
    public OrderService(DBManager db){
        this.db=db;
    }

    public void registerOrder(Order order) {
        if(order.getId()==null){
            order.setId(UUID.randomUUID().toString());
        }
        if(order.getCreatedAt()==null){
            order.setCreatedAt(new Date());
        }else{
            order.setUpdatedAt(new Date());
        }
        List<OrderItem> items = order.getOrderItems();

        for(OrderItem item : items){
            item.setOrderID(order.getId());
            if(item.getID()==null){
                item.setId(UUID.randomUUID().toString());
            }
            this.db.registerOrderItem(item);
        }

        this.db.registerOrder(order);
    }

    public List<Order> getOrders(String storeID){
        return this.db.getOrders(storeID);
    }

    public Order getOrder(String orderID) {
        return this.db.getOrder(orderID);
    }

    public List<Order> getPaidOrders(String storeID){
       return  this.db.getPaidOrders(storeID);
    }







    public BigDecimal getTotalRevenue(String storeID) {
        List<Order> storePaidOrders = getPaidOrders(storeID);
        BigDecimal total = BigDecimal.ZERO;
        for(Order order: storePaidOrders){
            total = total.add(order.getOrderItems().stream()
                    .map(orderItem -> db.getProductFromID(orderItem.getProductID()).getPrice())
                    .reduce(BigDecimal.ZERO, BigDecimal::add));
        }
        return total;
    }
}
