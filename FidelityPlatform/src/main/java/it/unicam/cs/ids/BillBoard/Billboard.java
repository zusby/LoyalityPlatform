package it.unicam.cs.ids.BillBoard;

import java.util.Date;

public class Billboard {
    private String ID;
    private String storeID;
    private String label;
    private String imageUrl;
    private Date createdAt;
    private Date updatedAt;

    public Billboard(String ID, String storeID, String label, String imageUrl, Date createdAt, Date updatedAt) {
        this.ID = ID;
        this.storeID = storeID;
        this.label = label;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Billboard(){

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    @Override
    public String toString() {
        return "BillBoard{" +
                "ID='" + ID + '\'' +
                ", storeID='" + storeID + '\'' +
                ", label='" + label + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}