package it.unicam.cs.ids.Colors;

import java.util.Date;

public class Color {

    private String id;
    private String storeID;
    private String value;
    private String name;
    private Date createdAt;
    private Date updatedAt;

    public Color(String id, String storeID, String value, String name, Date createdAt, Date updatedAt) {
        this.id = id;
        this.storeID = storeID;
        this.value = value;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Color() {}

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Color{" +
                "id='" + id + '\'' +
                ", storeID='" + storeID + '\'' +
                ", value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
