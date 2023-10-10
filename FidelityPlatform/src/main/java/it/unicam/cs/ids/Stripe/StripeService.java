package it.unicam.cs.ids.Stripe;

import com.google.gson.JsonObject;
import com.stripe.param.checkout.SessionCreateParams;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Model.OrderItem;
import it.unicam.cs.ids.Order.Order;
import it.unicam.cs.ids.Products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class StripeService {
    private final DBManager db;
    @Autowired
    public StripeService(DBManager db){
        this.db=db;
    }


    public List<SessionCreateParams.LineItem> getLineItems(Order order) {
        List<SessionCreateParams.LineItem> lineItems = new ArrayList<>();
        for(OrderItem pid:order.getOrderItems()){
            Product temp = this.db.getProductFromID(pid.getProductID());
            lineItems.add(SessionCreateParams.LineItem.builder().setPriceData(SessionCreateParams.LineItem.PriceData
                            .builder()
                            .setCurrency("eur")
                            .setUnitAmount(temp.getPrice().longValue()*100) // 123 EUR in cents
                                     .setProductData(
                                             SessionCreateParams.LineItem.PriceData.ProductData
                                                     .builder().setName(temp.getName())
                                                     .build())
                            .build()).setQuantity(1L)
                    .build());
        }



        return lineItems;
    }

    public void updateOrder(JsonObject jsonPayload) {
        String phoneNumber = jsonPayload
                .getAsJsonObject("data")
                .getAsJsonObject("object")
                .getAsJsonObject("customer_details")
                .getAsJsonPrimitive("phone")
                .getAsString();
        JsonObject billingAddress = jsonPayload
                .getAsJsonObject("data")
                .getAsJsonObject("object")
                .getAsJsonObject("customer_details")
                .getAsJsonObject("address");
        String addressCity = billingAddress.getAsJsonPrimitive("city").getAsString();
        String addressLine1 = billingAddress.getAsJsonPrimitive("line1").getAsString();
        String addressState = billingAddress.getAsJsonPrimitive("state").getAsString();
        String orderId = jsonPayload
                .getAsJsonObject("data")
                .getAsJsonObject("object")
                .getAsJsonObject("metadata")
                .getAsJsonPrimitive("orderID")
                .getAsString();
        Order order = this.db.getOrder(orderId);
        order.setAddress(addressLine1+" "+addressCity+" "+addressState);
        order.setPhone(phoneNumber.substring(3));
        order.setIsPaid(true);
        this.db.registerOrder(order);
    }

    public void registerUnpaidOrder(Order order) {
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
}
