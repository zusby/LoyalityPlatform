package it.unicam.cs.ids.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrizeAwards {

    private List<Item> awards;

    public PrizeAwards(List<Item> awards){
        this.awards = awards;
    }

    public PrizeAwards(){
        this.awards = new ArrayList<>();
    }

    public List<Item> getAwards() {
        return awards;
    }

    public void setAwards(List<Item> awards) {
        this.awards = awards;
    }

    public void addAward(Item item){
        this.awards.add(item);
    }

    public void removeAward(Item item){
        awards.remove(item);
    }
}
