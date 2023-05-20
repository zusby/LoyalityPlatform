package it.unicam.cs.ids.LoyalityPlatform;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.LoyalityPlatform.FidelityProgram;
import it.unicam.cs.ids.Model.Purchase;

import java.util.GregorianCalendar;

public class CashBackRule extends FidelityProgram {
    private double cashBackPercentage;

    public CashBackRule(double cashBackPercentage, Timestamp endingDate){
        this.cashBackPercentage = cashBackPercentage;
        this.startingDate = Timestamp.of(new GregorianCalendar().getTime());
        this.endingDate = endingDate;
    }


    @Override
    public void applyRule(Purchase purchase) {
        double cashbackAmount = purchase.getPrice() * cashBackPercentage / 100;
        // Aggiungi il cashback all'utente


    }
}
