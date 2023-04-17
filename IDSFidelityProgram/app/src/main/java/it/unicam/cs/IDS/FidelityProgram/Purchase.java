/**
 * The Purchase class represents a purchase made by a user, with attributes such as ID, purchase date, price, and user
 * information.
 * @Authors Kacper Henryk Osicki, Anthony Eleuteri, Yuri Orsili
 */

package it.unicam.cs.IDS.FidelityProgram;

import java.util.Date;
import java.util.Objects;

public class Purchase {
    private final int ID;
    private final Date purchaseDate;
    private final Integer price;
    private final User user;


    public Purchase(Integer ID, Date date, Integer currency, User user){
        this.ID=Objects.requireNonNull(ID);
        this.purchaseDate=Objects.requireNonNull(date);
        this.price = Objects.requireNonNull(currency);
        this.user = Objects.requireNonNull(user);
    }

    public int getID() {
        return ID;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public Integer getPrice() {
        return price;
    }

    public User getUser() {
        return user;
    }
}
