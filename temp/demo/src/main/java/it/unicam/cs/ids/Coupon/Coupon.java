package it.unicam.cs.ids.Coupon;


import java.util.Date;

public class Coupon {
    private String id;
    private String ownerId;
    private double value;
    private Date expirationDate;


    public Coupon() {
    }

    public Coupon(String id, String ownerId, double value, Date expirationDate) {
        this.id = id;
        this.ownerId = ownerId;
        this.value = value;
        this.expirationDate = expirationDate;
    }

    public Coupon(String id,  double value, Date expirationDate) {
        this.id = id;
        this.value = value;
        this.expirationDate = expirationDate;
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
