package it.unicam.cs.ids.Model;

import java.util.Objects;

public class Item {
    private final double cost;
    private String description;
    private String characteristics;
    private final String id;

    public Item(double cost, String description, String characteristics, String id) {
        this.cost = cost;
        this.description = description;
        this.characteristics = characteristics;
        this.id = id;
    }


    public double getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Item{" +
                "cost=" + cost +
                ", description='" + description + '\'' +
                ", characteristic='" + characteristics + '\'' +
                ", id=" + id +
                '}';
    }
}
