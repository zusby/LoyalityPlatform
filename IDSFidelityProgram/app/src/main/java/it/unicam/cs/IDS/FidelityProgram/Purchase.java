/**
 * The Purchase class represents a purchase made by a user, with attributes such as ID, purchase date, price, and user
 * information.
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */

package it.unicam.cs.IDS.FidelityProgram;

import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Purchase {
    private String id;
    private GregorianCalendar purchaseDate;
    private Long price;
    private String user;
    private String item;


    public Purchase(String id, GregorianCalendar date, Long currency, String user, String item){
        this.id=Objects.requireNonNull(id);
        this.item = Objects.requireNonNull(item);
        this.purchaseDate=Objects.requireNonNull(date);
        this.price = Objects.requireNonNull(currency);
        this.user = Objects.requireNonNull(user);
    }


    public String getID() {
        return id;
    }

    public com.google.cloud.Timestamp getPurchaseDate() {
        return com.google.cloud.Timestamp.of(purchaseDate.getTime());
    }

    public Long getPrice() {
        return price;
    }

    public String getUser() {
        return user;
    }
    public String getItem(){
        return this.item;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id='" + id + '\'' +
                ", purchaseDate=" + purchaseDate.getTime() +
                ", price=" + price +
                ", user='" + user + '\'' +
                ", item='" + item + '\'' +
                '}';
    }
}
