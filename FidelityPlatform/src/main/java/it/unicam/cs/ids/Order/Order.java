package it.unicam.cs.ids.Order;

import it.unicam.cs.ids.Model.OrderItem;

import java.util.Date;
import java.util.List;

public class Order {
    private String id;
    private String storeID;
    private List<OrderItem> orderItems;

    private boolean isPaid;
    private String phone;

    private String address;
    private Date createdAt;
    private Date updatedAt;

    public Order(String id, String storeID, List<OrderItem> orderItems, boolean isPaid, String phone, String address, Date createdAt, Date updatedAt) {
        this.id = id;
        this.storeID = storeID;
        this.orderItems = orderItems;
        this.isPaid = isPaid;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Order(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

