package it.unicam.cs.ids.Database;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import it.unicam.cs.ids.Admin.Admin;
import it.unicam.cs.ids.BillBoard.BillBoard;
import it.unicam.cs.ids.Categories.Category;
import it.unicam.cs.ids.Coupon.Coupon;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.*;
import it.unicam.cs.ids.Customer.*;
import it.unicam.cs.ids.Employee.*;
import it.unicam.cs.ids.Purchase.Purchase;
import it.unicam.cs.ids.Shop.Shop;
import it.unicam.cs.ids.ShopOwner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;


@Service
public class DBManager extends FireBaseInitializer {

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
     *                 retrieved from the "Purchases" collection in the Firestore database.
     * @return The method `getPurchases` returns a list of `Purchase` objects for a given `clientID`.
     */
    public List<Purchase> getUserPurchases(String clientID) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = db.collection("Purchases").whereEqualTo("user", clientID).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Purchase> purchases = new ArrayList<>();
        for (DocumentSnapshot document : documents) {
            Purchase s = document.toObject(Purchase.class);
            purchases.add(s);
        }
        return purchases;
    }

    public List<Purchase> getPurchases() {
        ApiFuture<QuerySnapshot> future = db.collection("Purchases").get();
        List<Purchase> purchases = new ArrayList<>();
        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            for (DocumentSnapshot document : documents) {
                Purchase s = document.toObject(Purchase.class);
                purchases.add(s);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return purchases;
    }

    /**
     * This function retrieves a list of customers from a Firestore database and returns them as a list of Customer
     * objects.
     *
     * @return A list of Customer objects.
     */
    public List<Customer> getCustomers() throws InterruptedException, ExecutionException {
        ApiFuture<QuerySnapshot> future = db.collection("Customers").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Customer> customers = new ArrayList<>();
        for (DocumentSnapshot document : documents) {
            Customer s = document.toObject(Customer.class);
            customers.add(s);
        }
        return customers;
    }


    /**
     * This function registers a purchase by creating a document in the "Purchases" collection in a Firestore database.
     *
     * @param purchase The parameter "purchase" is an object of the class "Purchase" which contains information about a
     *                 purchase made by a customer. This information may include the purchase ID, the customer ID, the product ID, the
     *                 quantity purchased, the date of purchase, and the total cost of the purchase.
     */

    public void registerPurchase(Purchase purchase) {
        CollectionReference purchases = db.collection("Purchases");
        DocumentReference purchaseRef = purchases.document(purchase.getID());
        ApiFuture<WriteResult> writeResult = purchaseRef.create(purchase);
        try {
            writeResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

    /**
     * This function registers a customer without a password by creating a document in the "Clients" collection and adding
     * their email and ID to the authentication controller.
     *
     * @param customer The parameter "customer" is an object of the class "Customer" which contains information about a
     *                 customer such as their email, ID, and other details. This method is used to register a customer without a password
     *                 by creating a new document in the "Clients" collection in the Firestore database and adding the
     */
    public void registerCustomerNoPassword(Customer customer) {
        CollectionReference customers = db.collection("Customers");
        try {
            if (auth.getUserByEmail(customer.getEmail()) != null) {
                customer.setID(auth.getUserByEmail(customer.getEmail()).getUid());
                DocumentReference customerRef = customers.document(customer.getID());
                ApiFuture<WriteResult> writeResult = customerRef.create(customer);
                writeResult.get();
            }
            else if (AuthenticationController.registerNoPassword(customer.getEmail(), UUID.randomUUID().toString())) {
                DocumentReference purchaseRef = customers.document(customer.getID());
                ApiFuture<WriteResult> writeResult = purchaseRef.create(customer);
                try {
                    writeResult.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (FirebaseAuthException | ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * This function registers a customer by creating a document in a Firestore collection and calling a method to register
     * their email and password for authentication.
     *
     * @param customer The "customer" parameter is an object of the class "Customer" which contains information about a
     *                 customer such as their name, email, and ID.
     * @param password The password parameter is a String that represents the password that the customer will use to log in
     *                 to their account.
     */
    public void registerCustomer(Customer customer, String password) {
        CollectionReference purchases = db.collection("Customers");
        DocumentReference purchaseRef = purchases.document(customer.getID());
        if (AuthenticationController.register(customer.getEmail(), customer.getID(), password)) {
            ApiFuture<WriteResult> writeResult = purchaseRef.create(customer);
            try {
                writeResult.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * This function registers an employee without a password by creating a document in the "Employees" collection and
     * calling a method to register the employee's email and ID.
     *
     * @param employee The parameter "employee" is an object of the class "Employee" which contains information about an
     *                 employee such as their name, email, ID, etc.
     */
    public void registerEmployeeNoPassword(Employee employee) {
        CollectionReference purchases = db.collection("Employees");
        DocumentReference purchaseRef = purchases.document(employee.getID());
        if (AuthenticationController.registerNoPassword(employee.getEmail(), employee.getID())) {
            ApiFuture<WriteResult> writeResult = purchaseRef.create(employee);
            try {
                writeResult.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * This function registers an employee by creating a document in the "Employee" collection and registering their email
     * and password for authentication.
     *
     * @param employee The employee object that contains the information of the employee being registered, such as their
     *                 name, email, and ID.
     * @param password The password parameter is a String that represents the password that will be used to authenticate
     *                 the employee's account.
     */
    public void registerEmployee(Employee employee, String password) {
        CollectionReference purchases = db.collection("Employee");
        DocumentReference purchaseRef = purchases.document(employee.getID());
        if (AuthenticationController.register(employee.getEmail(), employee.getID(), password)) {
            ApiFuture<WriteResult> writeResult = purchaseRef.create(employee);
            try {
                writeResult.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * This function registers a shop owner by creating a document in the "ShopOwners" collection with the owner's ID and
     * information.
     *
     * @param owner The parameter "owner" is an object of the class "ShopOwner" which contains information about a shop
     *              owner such as their ID, name, email, and password. This method is used to register a new shop owner by adding their
     *              information to the "ShopOwners" collection in the Firestore database.
     */
    public void registerShopOwnerNoPassword(ShopOwner owner) {
        CollectionReference purchases = db.collection("ShopOwnerAcceptanceList");
        DocumentReference purchaseRef = purchases.document(owner.getID());
        if (AuthenticationController.registerNoPassword(owner.getEmail(), owner.getID())) {
            ApiFuture<WriteResult> writeResult = purchaseRef.create(owner);
            try {
                writeResult.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public void acceptShopOwner(ShopOwner owner) {
        CollectionReference purchases = db.collection("ShopOwners");
        DocumentReference purchaseRef = purchases.document(owner.getID());
        ApiFuture<WriteResult> writeResult = purchaseRef.create(owner);
        try {
            writeResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


    /**
     * This Java function retrieves a customer object from a Firestore database based on their email address.
     *
     * @param email The email of the user you want to retrieve from the Firebase Authentication service and Firestore
     *              database.
     * @return The method is returning a Customer object retrieved from the Firestore database based on the provided email
     * address.
     */
    public Customer getUserByEmail(String email) {
        UserRecord dbUser;
        try {
            dbUser = this.auth.getUserByEmail(email);
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }
        ApiFuture<DocumentSnapshot> future = db.collection("Customers").document(dbUser.getUid()).get();
        DocumentSnapshot document;
        try {
            document = future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return document.toObject(Customer.class);
    }

    /**
     * This function retrieves a list of ShopOwner objects from a Firestore collection called "ShopOwnerAcceptanceList".
     *
     * @return A list of ShopOwner objects that are retrieved from the "ShopOwnerAcceptanceList" collection in the
     * database.
     */
    public List<ShopOwner> getShopOwnerRegistrations() {
        ApiFuture<QuerySnapshot> future = db.collection("ShopOwnerAcceptanceList").get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
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
     *           "ShopOwnerAcceptanceList" collection that needs to be deleted.
     * @return A boolean value is being returned. If the deletion operation is successful, it returns true, otherwise it
     * returns false.
     */
    public boolean deleteShopOwnerFromRegistrationAcceptance(String id) {
        ApiFuture<WriteResult> future = db.collection("ShopOwnerAcceptanceList").document(id).delete();
        try {
            future.get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This function removes a shop owner from the Firestore collection.
     *
     * @param id The ID of the shop owner to be removed.
     * @return A boolean value indicating whether the deletion operation was successful or not.
     */
    public boolean deleteShopOwner(String id) {
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
    public boolean deleteEmployee(String id) {
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
    public boolean deleteCustomer(String id) {
        ApiFuture<WriteResult> future = db.collection("Customers").document(id).delete();
        try {
            future.get();
            deleteFidelityCard(id);
            auth.deleteUser(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteFidelityCard(String id) {
        ApiFuture<WriteResult> future = db.collection("Customers").document(this.getFidelityCardByUserID(id).getId()).delete();
        try {
            future.get();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void updateCustomerProfile(Customer customer) {
        DocumentReference couponRef = db.collection("Customers").document(customer.getID());
        couponRef.set(customer);
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


    /**
     * This function adds a coupon to a Firestore database.
     *
     * @param coupon The parameter "coupon" is an object of the class "Coupon" that contains information about a coupon,
     *               such as its ID, name, description, discount amount, and expiration date. The method "addCoupon" takes this object as
     *               input and adds it to a Firestore database collection called "Coupons
     */
    public void addCoupon(Coupon coupon) {

        DocumentReference couponRef = db.collection("Coupons").document(UUID.randomUUID().toString());
        couponRef.set(coupon);
    }

    /**
     * This function updates a coupon in a Firestore database.
     *
     * @param coupon The parameter "coupon" is an object of the class "Coupon" that contains the updated information for a
     *               specific coupon. The method "updateCoupon" updates the document in the "Coupons" collection in the Firestore
     *               database with the new information provided in the "coupon" object. The document to be
     */
    public void updateCoupon(Coupon coupon) {
        DocumentReference couponRef = db.collection("Coupons").document(coupon.getCouponId());
        couponRef.set(coupon);
    }


    /**
     * The function deletes a coupon document from a Firestore database using its ID.
     *
     * @param couponId The parameter `couponId` is a String that represents the unique identifier of the coupon that needs
     *                 to be deleted from the "Coupons" collection in the Firestore database.
     */
    public void deleteCoupon(String couponId) {
        DocumentReference couponRef = db.collection("Coupons").document(couponId);
        couponRef.delete();
    }


    /**
     * This Java function retrieves a list of coupons from a Firestore database.
     *
     * @return The method `getCoupons()` returns a list of `Coupon` objects.
     */
    public List<Coupon> getCoupons() throws ExecutionException, InterruptedException {
        List<Coupon> coupons = new ArrayList<>();
        try {
            ApiFuture<QuerySnapshot> future = db.collection("Coupons").get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();

            for (QueryDocumentSnapshot document : documents) {
                Coupon coupon = document.toObject(Coupon.class);
                coupons.add(coupon);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        return coupons;
    }


    /**
     * This Java function retrieves a coupon object from a Firestore database by its ID.
     *
     * @param couponId a String representing the ID of a coupon to be retrieved from a Firestore database.
     * @return The method returns an object of type Coupon, which represents a coupon retrieved from a Firestore database
     * based on the provided couponId. If the coupon with the given ID does not exist in the database, the method returns
     * null.
     */
    public Coupon getCouponById(String couponId) {

        DocumentReference shopRef = db.collection("Coupons").document(couponId);
        ApiFuture<DocumentSnapshot> futureCoupon = shopRef.get();

        try {
            DocumentSnapshot document = futureCoupon.get();
            return document.toObject(Coupon.class);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This function retrieves a list of coupons associated with a specific user ID from a Firestore database.
     *
     * @param userId The parameter "userId" is a String that represents the unique identifier of a user for whom we want to
     *               retrieve the coupons.
     * @return The method is returning a list of Coupon objects that belong to a specific user, identified by their userId.
     */
    public List<Coupon> getCouponsByUser(String userId) {
        List<Coupon> userCoupons = new ArrayList<>();

        CollectionReference couponsCollection = db.collection("Coupons");
        Query query = couponsCollection.whereEqualTo("ownerId", userId);
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


    /**
     * This function retrieves a FidelityCard object from a Firestore database based on the user ID.
     *
     * @param id The parameter "id" is a String representing the user ID for which we want to retrieve the FidelityCard
     *           object. The method searches for the FidelityCard object in the "FidelityCard" collection in the Firestore database,
     *           where the "cardOwner" field matches the provided user ID.
     * @return This method returns a FidelityCard object that belongs to a user with the specified ID.
     */
    public FidelityCard getFidelityCardByUserID(String id) {
        ApiFuture<QuerySnapshot> future = db.collection("FidelityCards").whereEqualTo("cardOwnerId", id).get();
        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            return documents.get(0).toObject(FidelityCard.class);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<FidelityCard> getFidelityCardByShopID(String id) {
        ApiFuture<QuerySnapshot> future = db.collection("FidelityCards").whereEqualTo("shopId", id).get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        List<FidelityCard> fidelityCards = new ArrayList<>();
        for (DocumentSnapshot document : documents) {
            FidelityCard fidelity = document.toObject(FidelityCard.class);
            fidelityCards.add(fidelity);
        }
        return fidelityCards;
    }

    /**
     * This function retrieves a FidelityCard object from a Firestore database based on its ID.
     *
     * @param id The parameter "id" is a String representing the unique identifier of a FidelityCard object. The method
     *           searches for a FidelityCard object in the Firestore database that matches the given id and returns it.
     * @return This method returns a FidelityCard object that matches the given card ID.
     */
    public FidelityCard getFidelityCardByCardID(String id) {
        ApiFuture<QuerySnapshot> future = db.collection("FidelityCards").whereEqualTo("id", id).get();
        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            return documents.get(0).toObject(FidelityCard.class);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * This function registers a FidelityCard object in a Firestore database.
     *
     * @param fidelityC fidelityC is an object of the class FidelityCard that contains the data of a customer's fidelity
     *                  card. It is passed as a parameter to the method registerFidelityCard() to be stored in the Firestore database.
     */
    public void registerFidelityCard(FidelityCard fidelityC) {
        CollectionReference purchases = db.collection("FidelityCards");
        DocumentReference purchaseRef = purchases.document(fidelityC.getId());

        ApiFuture<WriteResult> writeResult = purchaseRef.create(fidelityC);
        try {
            writeResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }


    /**
     * This function updates the expiration date of a customer's fidelity card in a Firestore database.
     *
     * @param customerId    The ID of the customer whose fidelity card expire date needs to be updated.
     * @param newExpireDate A Date object representing the new expiration date for the customer's fidelity card.
     */
    public void updateFidelityCardExpireDate(String customerId, Date newExpireDate) {
        DocumentReference customerRef = db.collection("FidelityCards").document(customerId);
        customerRef.update("expireDate", Timestamp.of(newExpireDate));
    }


    /**
     * This function updates the fidelity points of a customer with a given card ID by adding a specified number of points.
     *
     * @param cardId      A string representing the unique identifier of a fidelity card in the "FidelityCard" collection in a
     *                    Firestore database.
     * @param pointsToAdd an integer value representing the number of points to add to the existing points of a customer's
     *                    fidelity card.
     */
    public void updateFidelityPointsFromCardId(String cardId, int pointsToAdd, List<Points> history) {
        DocumentReference customerRef = db.collection("FidelityCards").document(cardId);
        customerRef.update("points", FieldValue.increment(pointsToAdd));
        customerRef.update("pointsHistory", history);
    }


    /**
     * This function retrieves a list of Shop objects from a Firestore database.
     *
     * @return This method returns a list of Shop objects.
     */
    public List<Shop> getShops() {
        ApiFuture<QuerySnapshot> future = db.collection("Shops").get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        List<Shop> shops = new ArrayList<>();
        for (DocumentSnapshot document : documents) {

            Shop shop = document.toObject(Shop.class);

            shops.add(shop);
        }
        return shops;
    }

    /**
     * The function deletes a shop document from a Firestore database using its ID.
     *
     * @param shopId The parameter shopId is a String that represents the unique identifier of a shop in a Firestore
     *               database. The method deleteShop() takes this parameter and uses it to create a reference to the specific shop
     *               document in the "Shops" collection. The shopRef.delete() method call then deletes the document from
     */
    public void deleteShop(String shopId) {
        DocumentReference shopRef = db.collection("Shops").document(shopId);
        shopRef.delete();
    }

    /**
     * The function registers a shop by setting its document reference in a Firestore database.
     *
     * @param shop The parameter "shop" is an object of the class "Shop" that contains information about a shop. This
     *             method registers the shop by adding it to the "Shop" collection in the Firestore database. The shop object is added
     *             as a document with the document ID set to the shop's ID.
     */
    public void registerShop(Shop shop) {
        DocumentReference shopRef = db.collection("Shops").document(shop.getId());
        shopRef.set(shop);
    }


    public Shop getShop(String id) {
        DocumentReference shopRef = db.collection("Shops").document(id);
        ApiFuture<DocumentSnapshot> futureShop = shopRef.get();

        try {
            DocumentSnapshot document = futureShop.get();
            if (document.exists()) {
                return document.toObject(Shop.class);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * This Java function retrieves a customer object from a Firestore database using the customer's ID.
     *
     * @param id The parameter "id" is a String representing the unique identifier of a customer in the "Clients"
     *           collection in the database. The method retrieves the customer document with the specified id and returns a Customer
     *           object representing the data stored in the document.
     * @return The method is returning a `Customer` object retrieved from the Firestore database based on the provided
     * `id`. If the document with the provided `id` does not exist, the method returns `null`.
     */
    public Customer getCustomer(String id) {
        DocumentReference shopRef = db.collection("Customers").document(id);
        ApiFuture<DocumentSnapshot> futureCustomer = shopRef.get();

        try {
            DocumentSnapshot document = futureCustomer.get();
            if (document.exists()) {
                return document.toObject(Customer.class);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Employee> getEmployees(String shopId) {
        ApiFuture<QuerySnapshot> future = db.collection("Employees").whereEqualTo("shopId", shopId).get();
        List<QueryDocumentSnapshot> documents;
        try {
            documents = future.get().getDocuments();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        List<Employee> employees = new ArrayList<>();
        for (DocumentSnapshot document : documents) {
            employees.add(document.toObject(Employee.class));
        }
        return employees;
    }

    public List<Shop> getShopsByOwnerId(String shopOwnerID) {
        ApiFuture<QuerySnapshot> future = db.collection("Shops").whereArrayContains("shopOwners", shopOwnerID).get();
        List<QueryDocumentSnapshot> documents;

        try {
            documents = future.get().getDocuments();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<Shop> shops = new ArrayList<>();

        for (DocumentSnapshot document : documents) {
            shops.add(document.toObject(Shop.class));
        }
        return shops;

    }

    public FidelitySpace getFidelitySpace(String shopID) {
        DocumentReference shopRef = db.collection("Shops").document(shopID);
        ApiFuture<DocumentSnapshot> futureCustomer = shopRef.get();

        try {
            DocumentSnapshot document = futureCustomer.get();
            if (document.exists()) {
                return Objects.requireNonNull(document.toObject(Shop.class)).getSpace();
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void updateFidelitySpace(FidelitySpace space, String shopID) {
        DocumentReference shopRef = db.collection("Shops").document(shopID);
        shopRef.update("space", space);

    }

    public List<Points> getFidelityCardPointsHistory(String id) {
        return this.getFidelityCardByCardID(id).getPointsHistory();
    }


    public ShopOwner getShopOwner(String id) {
        ApiFuture<QuerySnapshot> future = db.collection("ShopOwners").whereEqualTo("id", id).get();
        try {
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            return documents.get(0).toObject(ShopOwner.class);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ShopOwner> getShopOwners() {
        ApiFuture<QuerySnapshot> future = db.collection("ShopOwners").get();
        List<ShopOwner> shopOwners = new ArrayList<>();

        try {
            for (DocumentSnapshot document : future.get().getDocuments()) {
                shopOwners.add(document.toObject(ShopOwner.class));
            }
            return shopOwners;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ShopOwner> getShopOwnersByShopId(String shopId) {

        List<Shop> shops = new ArrayList<>();
        List<ShopOwner> shopOwners = new ArrayList<>();
        ApiFuture<QuerySnapshot> future = db.collection("Shops").get();

        try {
            for (DocumentSnapshot document : future.get().getDocuments()) {
                shops.add(document.toObject(Shop.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        for (Shop shop : shops) {
            if (shop.getId().equals(shopId)) {
                for (String shopOwnerID : shop.getShopOwners()) {
                    shopOwners.add(this.getShopOwner(shopOwnerID));
                }
            }
        }

        return shopOwners;
    }

    public Employee getEmployee(String id) {
        DocumentReference shopRef = db.collection("Employees").document(id);
        ApiFuture<DocumentSnapshot> futureEmployee = shopRef.get();

        try {
            DocumentSnapshot document = futureEmployee.get();
            if (document.exists()) {
                return document.toObject(Employee.class);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void updateEmployee(Employee employee) {
        DocumentReference couponRef = db.collection("Customers").document(employee.getID());
        couponRef.set(employee);
    }

    public void updateAdmin(Admin admin) {
        DocumentReference couponRef = db.collection("Admins").document(admin.getID());
        couponRef.set(admin);
    }

    public void deleteAdmin(String id) {
        ApiFuture<WriteResult> future = db.collection("Admins").document(id).delete();
        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Admin getAdmin(String id) {
        DocumentReference shopRef = db.collection("Admins").document(id);
        ApiFuture<DocumentSnapshot> futureEmployee = shopRef.get();

        try {
            DocumentSnapshot document = futureEmployee.get();
            if (document.exists()) {
                return document.toObject(Admin.class);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void registerAdmin(Admin admin) {
        CollectionReference purchases = db.collection("Admins");
        DocumentReference adminRef = purchases.document(admin.getID());
        if (AuthenticationController.registerNoPassword(admin.getEmail(), admin.getID())) {
            ApiFuture<WriteResult> writeResult = adminRef.create(admin);
            try {
                writeResult.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public BillBoard getBillBoardFromID(String id) {
        DocumentReference billBoard = db.collection("BillBoards").document(id);
        ApiFuture<DocumentSnapshot> future = billBoard.get();

        try {
            DocumentSnapshot document = future.get();
            if (document.exists()) {
                return document.toObject(BillBoard.class);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        return null;
    }



    public void registerBillBoard(BillBoard billBoard) {
        DocumentReference shopRef = db.collection("BillBoards").document(billBoard.getID());
        shopRef.set(billBoard);
    }
    public List<BillBoard> getShopBillBoards(String shopID) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = db.collection("BillBoards").whereEqualTo("storeID", shopID).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<BillBoard> purchases = new ArrayList<>();
        for (DocumentSnapshot document : documents) {
            BillBoard billBoard = document.toObject(BillBoard.class);
            purchases.add(billBoard);
        }
        return purchases;
    }


    public void deleteBillBoard(String id) {
            ApiFuture<WriteResult> future = db.collection("BillBoards").document(id).delete();
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    public List<Category> getStoreCategories(String shopID) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = db.collection("Categories").whereEqualTo("storeID", shopID).get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        List<Category> purchases = new ArrayList<>();
        for (DocumentSnapshot document : documents) {
            purchases.add(document.toObject(Category.class));
        }
        return purchases;
    }

    public Category getCategory(String id) {

            DocumentReference category = db.collection("Categories").document(id);
            ApiFuture<DocumentSnapshot> future = category.get();
            try {
                DocumentSnapshot document = future.get();
                if (document.exists()) {
                    return document.toObject(Category.class);
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            return null;
        }

    public void deleteCategory(String id) {
        ApiFuture<WriteResult> future = db.collection("Categories").document(id).delete();
        try {
            future.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerCategory(Category category) {
        DocumentReference shopRef = db.collection("Categories").document(category.getId());
        shopRef.set(category);
    }
}
