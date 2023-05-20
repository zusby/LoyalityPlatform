package it.unicam.cs.ids.Database;

import com.google.api.core.ApiFuture;
import java.sql.Timestamp;
import com.google.cloud.firestore.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import it.unicam.cs.ids.Coupon.Coupon;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.*;
import it.unicam.cs.ids.Customer.*;
import it.unicam.cs.ids.Employee.*;
import it.unicam.cs.ids.ShopOwner.*;
import it.unicam.cs.ids.Admin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Instant;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;


@Service
public class DBManager extends FireBaseInitializer{

    private final Firestore db;
    private final FirebaseAuth auth;

    @Autowired
    public DBManager() throws IOException {
        this.auth = FirebaseAuth.getInstance();
        this.db = FirestoreClient.getFirestore();
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
            java.util.Date purchaseDate = document.getDate("purchaseDate");
            Timestamp timestamp = Timestamp.from(purchaseDate.toInstant());
            purchases.add(
                            new Purchase(document.getId(),
                            timestamp,
                            document.get("user").toString(),
                            new ArrayList<>()));
        }
        return purchases;
    }

    public List<Customer> getCustomers() throws InterruptedException, ExecutionException {
        ApiFuture<QuerySnapshot> future = db.collection("Clients").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Customer> shopOwners = new ArrayList<>();

        for (DocumentSnapshot document : documents) {
            System.out.println(document.toString());
            Customer s = document.toObject(Customer.class);
            System.out.println(s);
            shopOwners.add(s);
        }
        return shopOwners;
    }




    /**
     * This function registers a purchase by creating a document in the "Purchases" collection in a Firestore database.
     *
     * @param purchase The parameter "purchase" is an object of the class "Purchase" which contains information about a
     * purchase made by a customer. This information may include the purchase ID, the customer ID, the product ID, the
     * quantity purchased, the date of purchase, and the total cost of the purchase.
     */
    public void registerPurchase(Purchase purchase) {
        CollectionReference purchases = db.collection("Purchases");
        List<ApiFuture<WriteResult>> futurePurchases = new ArrayList<>();
        futurePurchases.add(purchases.document(purchase.getID()).create(purchase));
    }

    /**
     * This function registers a customer without a password by creating a document in the "Clients" collection and adding
     * their email and ID to the authentication controller.
     *
     * @param customer The parameter "customer" is an object of the class "Customer" which contains information about a
     * customer such as their email, ID, and other details. This method is used to register a customer without a password
     * by creating a new document in the "Clients" collection in the Firestore database and adding the
     */
    public void registerCustomerNoPassword(Customer customer) {
        CollectionReference customers = db.collection("Clients");
        List<ApiFuture<WriteResult>> futureCustomers = new ArrayList<>();
        AuthenticationController.registerNoPassword(customer.getEmail(),customer.getID());
        futureCustomers.add(customers.document(customer.getID()).create(customer));
    }

    /**
     * This function registers a customer by creating a document in a Firestore collection and calling a method to register
     * their email and password for authentication.
     *
     * @param customer The "customer" parameter is an object of the class "Customer" which contains information about a
     * customer such as their name, email, and ID.
     * @param password The password parameter is a String that represents the password that the customer will use to log in
     * to their account.
     */
    public void registerCustomer(Customer customer, String password) {
        CollectionReference customers = db.collection("Clients");
        List<ApiFuture<WriteResult>> futureCustomers = new ArrayList<>();
        futureCustomers.add(customers.document(customer.getID().toString()).create(customer));
        AuthenticationController.register(customer.getEmail(),password, customer.getID());
    }
    /**
     * This function registers an employee without a password by creating a document in the "Employees" collection and
     * calling a method to register the employee's email and ID.
     *
     * @param employee The parameter "employee" is an object of the class "Employee" which contains information about an
     * employee such as their name, email, ID, etc.
     */
    public void registerEmployeeNoPassword(Employee employee) {
        CollectionReference employees = db.collection("Employees");
        List<ApiFuture<WriteResult>> futureCustomers = new ArrayList<>();
        AuthenticationController.registerNoPassword(employee.getEmail(),employee.getID());
        futureCustomers.add(employees.document(employee.getID()).create(employee));
    }
    /**
     * This function registers an employee by creating a document in the "Employee" collection and registering their email
     * and password for authentication.
     *
     * @param employee The employee object that contains the information of the employee being registered, such as their
     * name, email, and ID.
     * @param password The password parameter is a String that represents the password that will be used to authenticate
     * the employee's account.
     */
    public void registerEmployee(Employee employee, String password) {
        CollectionReference employees = db.collection("Employee");
        List<ApiFuture<WriteResult>> futureEmployees = new ArrayList<>();
        futureEmployees.add(employees.document(employee.getID()).create(employee));
        AuthenticationController.register(employee.getEmail(), password, employee.getID());
    }
    /**
     * This function registers a shop owner by creating a document in the "ShopOwners" collection with the owner's ID and
     * information.
     *
     * @param owner The parameter "owner" is an object of the class "ShopOwner" which contains information about a shop
     * owner such as their ID, name, email, and password. This method is used to register a new shop owner by adding their
     * information to the "ShopOwners" collection in the Firestore database.
     */
    public void registerShopOwner(ShopOwner owner) {
        CollectionReference shopOwners = db.collection("ShopOwners");
        List<ApiFuture<WriteResult>> futureShopOwners = new ArrayList<>();
        futureShopOwners.add(shopOwners.document(owner.getID()).create(owner));

    }
    /**
     * This Java function retrieves a customer object from a Firestore database based on their email address.
     *
     * @param email The email of the user you want to retrieve from the Firebase Authentication service and Firestore
     * database.
     * @return The method is returning a Customer object retrieved from the Firestore database based on the provided email
     * address.
     */
    public Customer getUser(String email) throws FirebaseAuthException, ExecutionException, InterruptedException {
        UserRecord dbUser = this.auth.getUserByEmail(email);
        ApiFuture<DocumentSnapshot> future = db.collection("Clients").document(dbUser.getUid()).get();
        DocumentSnapshot document = future.get();
        return document.toObject(Customer.class);
    }
    /**
     * This function retrieves a list of ShopOwner objects from a Firestore collection called "ShopOwnerAcceptanceList".
     *
     * @return A list of ShopOwner objects that are retrieved from the "ShopOwnerAcceptanceList" collection in the
     * database.
     */
    public List<ShopOwner> getShopOwnerRegistrations() throws InterruptedException, ExecutionException {
        ApiFuture<QuerySnapshot> future = db.collection("ShopOwnerAcceptanceList").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<ShopOwner> shopOwners = new ArrayList<>();

        for (DocumentSnapshot document : documents) {
            shopOwners.add(document.toObject(ShopOwner.class));
        }
        return shopOwners;
    }


    /**
     * This function removes a shop owner's registration acceptance from a Firestore collection.
     *
     * @param id The parameter "id" is a String representing the unique identifier of a document in the
     * "ShopOwnerAcceptanceList" collection that needs to be deleted.
     * @return A boolean value is being returned. If the deletion operation is successful, it returns true, otherwise it
     * returns false.
     */
    public boolean removeShopOwnerFromRegistrationAcceptance(String id){
        ApiFuture<WriteResult> future = db.collection("ShopOwnerAcceptanceList").document(id).delete();
        try{
            future.get();
            return true;}
        catch(Exception e){return false;}
    }

    /**
     * This function removes a shop owner from the Firestore collection.
     *
     * @param id The ID of the shop owner to be removed.
     * @return A boolean value indicating whether the deletion operation was successful or not.
     */
    public boolean removeShopOwner(String id) {
        ApiFuture<WriteResult> future = db.collection("ShopOwners").document(id).delete();
        try {
            future.get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This function removes an employee from the Firestore collection.
     *
     * @param id The ID of the employee to be removed.
     * @return A boolean value indicating whether the deletion operation was successful or not.
     */
    public boolean removeEmployee(String id) {
        ApiFuture<WriteResult> future = db.collection("Employees").document(id).delete();
        try {
            future.get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This function removes a customer from the Firestore collection.
     *
     * @param id The ID of the customer to be removed.
     * @return A boolean value indicating whether the deletion operation was successful or not.
     */
    public boolean removeCustomer(String id) {
        ApiFuture<WriteResult> future = db.collection("Clients").document(id).delete();
        try {
            future.get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This function removes a purchase from the Firestore collection.
     *
     * @param id The ID of the purchase to be removed.
     * @return A boolean value indicating whether the deletion operation was successful or not.
     */
    public boolean removePurchase(String id) {
        ApiFuture<WriteResult> future = db.collection("Purchases").document(id).delete();
        try {
            future.get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    // Metodo per salvare un coupon nel database
    public void saveCoupon(Coupon coupon) {
        DocumentReference couponRef = db.collection("Coupons").document(coupon.getId());
        couponRef.set(coupon);
    }

    // Metodo per aggiornare un coupon esistente nel database
    public void updateCoupon(Coupon coupon) {
        DocumentReference couponRef = db.collection("Coupons").document(coupon.getId());
        couponRef.set(coupon);
    }

    // Metodo per eliminare un coupon dal database
    public void deleteCoupon(String couponId) {
        DocumentReference couponRef = db.collection("Coupons").document(couponId);
        couponRef.delete();
    }


    // Metodo per ottenere tutti i coupon
    public List<Coupon> getCoupons() throws ExecutionException, InterruptedException {
        List<Coupon> coupons = new ArrayList<>();

        Firestore db = FirestoreClient.getFirestore();  // Ottieni l'istanza del database Firestore

        try {
            ApiFuture<QuerySnapshot> future = db.collection("Coupons").get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();

            for (QueryDocumentSnapshot document : documents) {
                Coupon coupon = document.toObject(Coupon.class);
                coupons.add(coupon);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw e;
        }

        return coupons;
    }


    // Metodo per ottenere un coupon dato l'ID
    public Coupon getCouponById(String couponId) throws InterruptedException, ExecutionException {
        DocumentReference couponRef = db.collection("Coupons").document(couponId);
        ApiFuture<DocumentSnapshot> future = couponRef.get();

        try {
            DocumentSnapshot document = future.get();
            if (document.exists()) {
                Coupon coupon = document.toObject(Coupon.class);
                return coupon;
            }
        } catch (InterruptedException | ExecutionException e) {
            throw e; // Rilancia le eccezioni al chiamante
        }

        return null;
    }

    public List<Coupon> getCouponsByUser(String userId) {
        List<Coupon> userCoupons = new ArrayList<>();

        CollectionReference couponsCollection = db.collection("Coupons");
        Query query = couponsCollection.whereEqualTo("userId", userId);
        ApiFuture<QuerySnapshot> future = query.get();

        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                Coupon coupon = document.toObject(Coupon.class);
                userCoupons.add(coupon);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return userCoupons;
    }


    public FidelityCard getFidelityCardByUserID(String id) {
        ApiFuture<QuerySnapshot> future = db.collection("FidelityCard").whereEqualTo("cardOwner", id).get();
        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            return  documents.get(0).toObject(FidelityCard.class);
        }catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void registerFidelityCard(FidelityCard fidelityC){
        CollectionReference fidelityCard = db.collection("FidelityCard");
        List<ApiFuture<WriteResult>> futureFidelityCard = new ArrayList<>();
        futureFidelityCard.add(fidelityCard.document(fidelityC.getId().toString()).create(fidelityC));
    }

    /**
     * This function retrieves the authenticated customer ID based on their email.
     *
     * @param email The email address of the authenticated customer.
     * @return The customer ID associated with the provided email address.
     */
    public String getAuthenticatedCustomerId(String email) throws FirebaseAuthException {
        UserRecord dbUser = this.auth.getUserByEmail(email);
        return dbUser.getUid();
    }

    /**
     * This function updates the fidelity points for a customer in the Firestore database.
     *
     * @param customerId The ID of the customer whose fidelity points need to be updated.
     * @param pointsToAdd The number of points to add to the customer's current fidelity points.
     */
    public void updateFidelityPoints(String customerId, int pointsToAdd) {
        DocumentReference customerRef = db.collection("Clients").document(customerId);
        customerRef.update("fidelityPoints", FieldValue.increment(pointsToAdd));
    }


}
