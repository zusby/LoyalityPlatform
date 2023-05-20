package it.unicam.cs.ids.Coupon;

import it.unicam.cs.ids.Database.DBManager;

import java.io.IOException;
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

    public void save() {
        try {
            DBManager dbManager = new DBManager();
            dbManager.saveCoupon(this);
        } catch (IOException e) {
            // Gestione dell'errore
        }
    }

    public void update() {
        try {
            DBManager dbManager = new DBManager();
            dbManager.updateCoupon(this);
        } catch (IOException e) {
            // Gestione dell'errore
        }
    }

    public void delete() {
        try {
            DBManager dbManager = new DBManager();
            dbManager.deleteCoupon(this.getId());
        } catch (IOException e) {
            // Gestione dell'errore
        }
    }


}
