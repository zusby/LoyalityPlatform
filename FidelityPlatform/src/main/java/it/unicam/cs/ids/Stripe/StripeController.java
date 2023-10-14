package it.unicam.cs.ids.Stripe;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import it.unicam.cs.ids.Order.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/stripe")
public class StripeController {

    private final StripeService service;

    @Autowired
    public StripeController(StripeService service){
        this.service = service;
    }


    @PostMapping("/create-checkout-session")
    public ResponseEntity<String> createCheckoutSession(@RequestBody Order order) {

        Stripe.apiKey = "sk_test_51NyFRiFkKBdrEOuyFBPg4u9cqMhSrMWdwwMQZTFvpSdvaKWMMSXs4vwGBDUyaXg315McTgO0DoXlQXRnUKtDC5nt00jlE0BnKH";

        if(order.getId()==null){
            order.setId(UUID.randomUUID().toString());
        }
        if(!order.getOrderItems().isEmpty()) {
            this.service.registerUnpaidOrder(order);
        }
        List<SessionCreateParams.LineItem> lineItems = service.getLineItems(order);
        if(!order.getOrderItems().isEmpty()) {
            SessionCreateParams params = SessionCreateParams.builder()
                    .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl("http://localhost:5174/cart?success=true")
                    .setCancelUrl("http://localhost:5174/cart?canceled=true")
                    .putMetadata("orderID",order.getId())
                    .addAllLineItem(lineItems)
                    .setPhoneNumberCollection(
                            SessionCreateParams.PhoneNumberCollection.builder()
                                    .setEnabled(true)
                                    .build())
                    .setBillingAddressCollection(SessionCreateParams.BillingAddressCollection.REQUIRED)
                    .build();
            try {
                Session session = Session.create(params);
                return ResponseEntity.ok(session.getUrl());
            } catch (StripeException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error creating Checkout session: " + e.getMessage());
            }
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/webhook")
    public ResponseEntity<String> handleStripeWebhook(@RequestBody String payload) {

        JsonParser jsonParser = new JsonParser();
        JsonObject jsonPayload = jsonParser.parse(payload).getAsJsonObject();

        if ("checkout.session.completed".equals(jsonPayload.get("type").getAsString())) {
            this.service.updateOrder(jsonPayload);
        }
        return ResponseEntity.ok().build();
    }
}

