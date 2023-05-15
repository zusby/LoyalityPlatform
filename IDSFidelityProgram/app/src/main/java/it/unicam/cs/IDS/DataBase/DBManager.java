package it.unicam.cs.IDS.DataBase;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import it.unicam.cs.IDS.Model.Address;
import it.unicam.cs.IDS.Model.Customer;
import it.unicam.cs.IDS.Model.Purchase;
import org.checkerframework.checker.units.qual.C;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class DBManager extends FireBaseInitializer{

    private final Firestore db;
    private final FirebaseAuth auth;

    public DBManager() throws IOException {
        this.db = FirestoreClient.getFirestore();
        this.auth = FirebaseAuth.getInstance();
    }


    /**
     * This function retrieves a list of purchases made by a specific client from a Firestore database.
     *
     * @param clientID The clientID parameter is a String that represents the ID of the user whose purchases are being
     * retrieved from the "Purchases" collection in the Firestore database.
     * @return The method `getPurchases` returns a list of `Purchase` objects for a given `clientID`.
     */
    public List<Purchase> getPurchases(String clientID) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = db.collection("Purchases").whereEqualTo("user", clientID).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Purchase> purchases = new ArrayList<>();
        for (DocumentSnapshot document : documents) {
            GregorianCalendar date = new GregorianCalendar();
            date.setTimeInMillis(document.getDate("purchaseDate").getTime());
            purchases.add(
                            new Purchase(document.getId(),
                            date,
                            (Long) document.get("price"),
                            document.get("user").toString(),
                            new ArrayList<>()));
        }
        return purchases;
    }


    /**
     * The function registers a purchase by creating a document in the "Purchases" collection in a Firestore database.
     *
     * @param purchase The parameter "purchase" is an object of the class "Purchase" which contains information about a
     * purchase made by a customer. It is being passed as an argument to the method "registerPurchase".
     */
    public void registerPurchase(Purchase purchase) {
        CollectionReference purchases = db.collection("Purchases");
        List<ApiFuture<WriteResult>> futurePurchases = new ArrayList<>();
        futurePurchases.add(purchases.document(purchase.getID()).create(purchase));
    }

    public void registerCustomer(Customer customer) {
        CollectionReference purchases = db.collection("Clients");
        List<ApiFuture<WriteResult>> futureCustomers = new ArrayList<>();
        futureCustomers.add(purchases.document(customer.getID().toString()).create(customer));
    }

    public Customer getUser(String email) throws FirebaseAuthException, ExecutionException, InterruptedException {
        UserRecord dbCustomer = this.auth.getUserByEmail(email);
        ApiFuture<DocumentSnapshot> future = db.collection("Clients").document(dbCustomer.getUid()).get();
        DocumentSnapshot document = future.get();
        Customer customer =document.toObject(Customer.class);
        return customer;
    }
}
