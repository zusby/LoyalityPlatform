package it.unicam.cs.ids.FidelityCard;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Model.Level;

import java.util.Date;

public class FidelityCard {
    private String id;
    private String cardOwnerId;
    private Timestamp expireDate;
    private int points;
    private Level rank;
    private int exp;

    private double balance;

    public FidelityCard(String id, String cardOwner, Timestamp expireDate) {

        this.rank = Level.BRONZE;
        this.id = id;
        this.cardOwnerId = cardOwner;
        this.expireDate = expireDate;
        this.points = 0;
        this.balance =0;


    }


    public FidelityCard() {
    }

    public String getCardOwnerId() {
        return cardOwnerId;
    }

    public void setCardOwnerId(String cardOwnerId) {
        this.cardOwnerId = cardOwnerId;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }

    public Level getRank() {
        return rank;
    }

    public void setRank(Level rank) {
        this.rank = rank;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardOwner() {
        return cardOwnerId;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwnerId = cardOwner;
    }

    public Date getExpireDate() {
        return expireDate.toDate();
    }


    public void setExpireDate(Date expireDate) {
        this.expireDate = Timestamp.of(expireDate);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }



    public void updateFidelityPoints(int points) {

        this.points += points;
    }

    public void updateExp(int exp) {
        this.exp+=exp;
    }
}