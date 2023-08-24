package it.unicam.cs.ids.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Catalogue {

    List<Item> catalogue;

    public Catalogue(){
        this.catalogue = new ArrayList<>();
    }

    public Catalogue(List<Item> catalogue) {
        this.catalogue = catalogue;
    }

    public void addItem(Item item){
        catalogue.add(item);
    }

    public void removeItem(Item item){
        catalogue.remove(item);
    }

    public void updateItem(Item item){
        catalogue.remove(item);
        catalogue.add(item);
    }

    public List<Item> getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(List<Item> catalogue) {
        this.catalogue = catalogue;
    }

    @Override
    public String toString() {
        return "catalogue{" +
                "catalogue=" + catalogue +
                '}';
    }
}
