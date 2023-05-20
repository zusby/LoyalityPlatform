/**
 * The Purchase class represents a purchase made by a user, with attributes such as ID, purchase date, price, and user
 * information.
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */

package it.unicam.cs.ids.Model;

import com.google.cloud.Timestamp;

import java.sql.Time;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

public class Purchase {
    private String id;
    private Timestamp purchaseDate;
    private Double price;
    private String userID;
    private List<Item> items;


    public Purchase(String id, Timestamp date, String user, List<Item> items){
        this.id=Objects.requireNonNull(id);
        this.items = Objects.requireNonNull(items);
        this.purchaseDate=Objects.requireNonNull(date);
        this.price = calculateTotalPrice();
        this.userID = Objects.requireNonNull(user);
    }


    public String getID() {
        return id;
    }

    public Date getPurchaseDate() {
        return purchaseDate.toDate();
    }

    public Double getPrice() {
        return price;
    }

    public String getUserID() {
        return userID;
    }
    public List<Item> getItem(){
        return this.items;
    }

    private Double calculateTotalPrice(){
        return items.stream().mapToDouble(items->items.getCost()).sum();
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                ", purchaseDate=" + purchaseDate.toDate() +
                ", price=" + price +
                ", user='" + userID + '\'' +
                ", item='" + items + '\'' +
                '}';
    }
}
