/**
 * The Purchase class represents a purchase made by a user, with attributes such as ID, purchase date, price, and user
 * information.
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */

package it.unicam.cs.ids.Purchase;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Model.Item;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Purchase {
    private String purchaseId;
    private Date purchaseDate;
    private Double price;
    private String userID;
    private List<Item> items;
    private double discount;

    public String shopId;



    public Purchase(String purchaseId, Date date, String user, List<Item> items, String shopId) {
        this.purchaseId = Objects.requireNonNull(purchaseId);
        this.items = Objects.requireNonNull(items);
        this.purchaseDate = Objects.requireNonNull(date);
        this.userID = Objects.requireNonNull(user);
        this.shopId = shopId;
    }

    public Purchase(){
    }
    public double getDiscountedPrice(){
        return this.price - this.discount;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getID() {
        return purchaseId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public double getPrice() {
        calculatePrice();
        return price;
    }

    public String getUserID() {
        return userID;
    }

    public List<Item> getItem(){
        return this.items;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void calculatePrice() {
        this.price= items.stream().mapToDouble(Item::getCost).sum();
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + purchaseId + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", user='" + userID + '\'' +
                ", item='" + items + '\'' +
                '}';
    }
}
