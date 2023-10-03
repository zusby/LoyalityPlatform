package it.unicam.cs.ids.Products;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private String id;
    private String storeID;
    private String categoryID;
    private String sizeID;
    private String colorID;
    private BigDecimal price;
    private String name;


    private boolean isFeatured;
    private boolean isArchived;
    private Date createdAt;
    private Date updatedAt;



    public Product(String id, String storeID, String categoryID, String sizeID, String colorID, BigDecimal price, String name, boolean isFeatured, boolean isArchived, Date createdAt, Date updatedAt) {
        this.id = id;
        this.storeID = storeID;
        this.categoryID = categoryID;
        this.sizeID = sizeID;
        this.colorID = colorID;
        this.price = price;
        this.name = name;
        this.isFeatured = isFeatured;
        this.isArchived = isArchived;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(){}


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

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

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getSizeID() {
        return sizeID;
    }

    public void setSizeID(String sizeID) {
        this.sizeID = sizeID;
    }

    public String getColorID() {
        return colorID;
    }

    public void setColorID(String colorID) {
        this.colorID = colorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsFeatured() {
        return isFeatured;
    }

    public void setIsFeatured(boolean featured) {
        isFeatured = featured;
    }

    public boolean getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(boolean archived) {
        isArchived = archived;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdA) {
        this.createdAt = createdA;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", storeID='" + storeID + '\'' +
                ", categoryID='" + categoryID + '\'' +
                ", sizeID='" + sizeID + '\'' +
                ", colorID='" + colorID + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", isFeatured=" + isFeatured +
                ", isArchived=" + isArchived +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
