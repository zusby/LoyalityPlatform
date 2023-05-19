/**
 * The Purchase class represents a purchase made by a user, with attributes such as ID, purchase date, price, and user
 * information.
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */

package it.unicam.cs.ids.Model;

import com.google.cloud.Timestamp;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

public class Purchase {
    private String id;
    private GregorianCalendar purchaseDate;
    private Long price;
    private String userID;
    private List<Item> items;


    public Purchase(String id, GregorianCalendar date, Long currency, String user, List<Item> items){
        this.id=Objects.requireNonNull(id);
        this.items = Objects.requireNonNull(items);
        this.purchaseDate=Objects.requireNonNull(date);
        this.price = Objects.requireNonNull(currency);
        this.userID = Objects.requireNonNull(user);
    }


    public String getID() {
        return id;
    }

    public Timestamp getPurchaseDate() {
        return Timestamp.of(purchaseDate.getTime());
    }

    public Long getPrice() {
        return price;
    }

    public String getUserID() {
        return userID;
    }
    public List<Item> getItem(){
        return this.items;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                ", purchaseDate=" + purchaseDate.getTime() +
                ", price=" + price +
                ", user='" + userID + '\'' +
                ", item='" + items + '\'' +
                '}';
    }
}
