package it.unicam.cs.ids.Coupon;


import java.util.Date;

public class Coupon {
    private String id;
    private String ownerId;
    private double value;
    private Date expirationDate;
    private boolean isUsed = false;

    private double discountPercentage;
    private int minimumPrice;


    public Coupon(String id, String ownerId, double value, Date expirationDate, double discountPercentage, int minimumPrice) {
        this.id = id;
        this.ownerId = ownerId;
        this.value = value;
        this.expirationDate = expirationDate;
        this.discountPercentage = discountPercentage;
        this.minimumPrice = minimumPrice;
    }

    public Coupon() {
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(int minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed() {
        isUsed = true;
    }

    public void setUsed(boolean bool) {
        isUsed = bool;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


}
