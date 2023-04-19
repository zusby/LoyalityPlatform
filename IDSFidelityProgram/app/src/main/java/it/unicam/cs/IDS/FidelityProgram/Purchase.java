/**
 * The Purchase class represents a purchase made by a user, with attributes such as ID, purchase date, price, and user
 * information.
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */

package it.unicam.cs.IDS.FidelityProgram;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Purchase {
    private final String ID;
    private final GregorianCalendar purchaseDate;
    private final Integer price;
    private final String userID;


    public Purchase(String ID, GregorianCalendar date, Integer currency, String user){
        this.ID=Objects.requireNonNull(ID);
        this.purchaseDate=Objects.requireNonNull(date);
        this.price = Objects.requireNonNull(currency);
        this.userID = Objects.requireNonNull(user);
    }

    public String getID() {
        return ID;
    }

    public GregorianCalendar getPurchaseDate() {
        return purchaseDate;
    }

    public Integer getPrice() {
        return price;
    }

    public String getUserID() {
        return userID;
    }
}
