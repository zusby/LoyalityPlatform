package it.unicam.cs.ids.Model;

import java.util.List;
import java.util.Set;

public class Catalogue {

    Set<Item> catalogue;

    public Catalogue(){
    }

    public Catalogue(Set<Item> catalogue) {
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

    public Set<Item> getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Set<Item> catalogue) {
        this.catalogue = catalogue;
    }

    @Override
    public String toString() {
        return "catalogue{" +
                "catalogue=" + catalogue +
                '}';
    }
}
