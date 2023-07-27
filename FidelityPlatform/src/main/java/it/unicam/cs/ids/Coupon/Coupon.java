package it.unicam.cs.ids.Coupon;


import java.util.Date;
import java.util.Objects;

public class Coupon {
    private String code;
    private String ownerId;
    private double value;
    private Date expirationDate;
    private boolean isUsed = false;

    private double discountPercentage;
    private int minimumPrice;
    private String couponId;


    public Coupon(String couponId,String code, String ownerId, double value, Date expirationDate, double discountPercentage, int minimumPrice) {
        this.code = code;
        this.ownerId = ownerId;
        this.value = value;
        this.expirationDate = expirationDate;
        this.discountPercentage = discountPercentage;
        this.minimumPrice = minimumPrice;
        this.couponId = couponId;
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


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
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

    @Override
    public String toString() {
        return "Coupon{" +
                "code='" + code + '\'' +
                ", couponId='" + couponId + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", expirationDate=" + expirationDate +
                ", isUsed=" + isUsed +
                ", minimumPrice=" + minimumPrice +
                ", ownerId='" + ownerId + '\'' +
                ", value=" + value +
                '}';
    }
}
