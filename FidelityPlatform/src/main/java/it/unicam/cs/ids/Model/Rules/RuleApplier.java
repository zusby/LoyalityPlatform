package it.unicam.cs.ids.Model.Rules;


import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.Purchase;

@FunctionalInterface
public interface RuleApplier {

    void applyRule(FidelityCard card, Purchase purchase);


}
