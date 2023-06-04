package it.unicam.cs.ids.Model;

import java.util.Set;

public class PrizeAwards {

    private Set<Item> awards;

    public PrizeAwards(Set<Item> awards){
        this.awards = awards;
    }

    public PrizeAwards(){
    }

    public Set<Item> getAwards() {
        return awards;
    }

    public void setAwards(Set<Item> awards) {
        this.awards = awards;
    }

    public void addAward(Item item){
        this.awards.add(item);
    }

    public void removeAward(Item item){
        awards.remove(item);
    }
}
