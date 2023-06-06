package it.unicam.cs.ids.Model.Rules;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.FidelityProgram;
import it.unicam.cs.ids.Purchase.Purchase;

public class CashBackRule extends FidelityProgram implements RuleApplier {

    private double cashBackPercentage;

    public CashBackRule( Timestamp startingDate, Timestamp endingDate, double cashBackPercentage) {
        super("1", startingDate, endingDate);
        this.cashBackPercentage = cashBackPercentage;
    }

    public CashBackRule() {
    }

    public double getCashBackPercentage() {
        return cashBackPercentage;
    }

    public void setCashBackPercentage(double cashBackPercentage) {
        this.cashBackPercentage = cashBackPercentage;
    }

    @Override
    public void applyRule(FidelityCard card, Purchase purchase) {
        card.updateBalance(purchase.getPrice() * this.cashBackPercentage/100);
    }

    @Override
    public String toString() {
        return "CashBackRule{" +
                "cashBackPercentage=" + cashBackPercentage +
                "} " + super.toString();
    }
}
