/**
 * The Purchase class represents a purchase made by a user, with attributes such as ID, purchase date, price, and user
 * information.
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */

package it.unicam.cs.ids.Model;

import java.sql.Timestamp;

import java.util.List;
import java.util.Objects;

public class Purchase {
    private String id;
    private Timestamp purchaseDate;
    private Double price;
    private String userID;
    private List<Item> items;
    private Long discout;


    public Purchase(String id, Timestamp date, String user, List<Item> items){
        this.id=Objects.requireNonNull(id);
        this.items = Objects.requireNonNull(items);
        this.purchaseDate=Objects.requireNonNull(date);
        this.userID = Objects.requireNonNull(user);
        this.price = calculatePrice();
    }


    public String getID() {
        return id;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public double getPrice() {
        return price;
    }

    public String getUserID() {
        return userID;
    }
    public List<Item> getItem(){
        return this.items;
    }

    private double calculatePrice() {
        return items.stream().mapToDouble(Item::getCost).sum();
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", price=" + price +
                ", user='" + userID + '\'' +
                ", item='" + items + '\'' +
                '}';
    }
}
