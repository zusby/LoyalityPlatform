package it.unicam.cs.ids.Model;


import it.unicam.cs.ids.FidelityCard.FidelityCard;

@FunctionalInterface
public interface RuleApplier {

    void applyRule(FidelityCard card, Purchase purchase);


}
