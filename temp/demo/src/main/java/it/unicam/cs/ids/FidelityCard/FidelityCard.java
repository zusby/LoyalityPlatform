package it.unicam.cs.ids.FidelityCard;

import com.google.cloud.Timestamp;

import java.util.Date;

public class FidelityCard {
    private String id;
    private String cardOwnerId;
    private Timestamp expireDate;
    private int points;

    private double balance;

    public FidelityCard(String id, String cardOwner, Timestamp expireDate) {
        this.id = id;
        this.cardOwnerId = cardOwner;
        this.expireDate = expireDate;
        this.points = 0;
        balance =0;
    }

    public FidelityCard() {
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



    public void updateFidelityPoints(int price) {
        int newPoints = (int) Math.floor(price); // Arrotonda il prezzo all'intero inferiore
        points += newPoints; // Aggiungi i punti al saldo corrente
    }
}