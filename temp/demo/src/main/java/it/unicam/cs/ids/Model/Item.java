package it.unicam.cs.ids.Model;

import java.util.UUID;

public class Item {
    private final Long cost;
    private String description;
    private String characteristics;
    private final UUID id;

    public Item(Long cost, String description, String characteristics, UUID id) {
        this.cost = cost;
        this.description = description;
        this.characteristics = characteristics;
        this.id = id;
    }


    public Long getCost() {
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

    public UUID getId() {
        return id;
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
