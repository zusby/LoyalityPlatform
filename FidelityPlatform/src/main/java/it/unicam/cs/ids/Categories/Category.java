package it.unicam.cs.ids.Categories;

import it.unicam.cs.ids.BillBoard.Billboard;

import java.util.Date;

public class Category {
    private String id;
    private String storeID;
    private Date updatedAt;
    private Date createdAt;
    private String name;
    private Billboard billboard;

    public Category(String id, String storeID, Date updatedAt, Date createdAt, String name, Billboard billboard) {
        this.id = id;
        this.storeID = storeID;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.name = name;
        this.billboard = billboard;
    }
    public Category(){}

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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Billboard getBillboard() {
        return billboard;
    }

    public void setBillboard(Billboard billboard) {
        this.billboard = billboard;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", storeID='" + storeID + '\'' +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                ", name='" + name + '\'' +
                ", billBoard=" + billboard +
                '}';
    }
}
