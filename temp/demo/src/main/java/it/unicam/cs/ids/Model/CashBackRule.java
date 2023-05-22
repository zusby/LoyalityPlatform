package it.unicam.cs.ids.Model;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Customer.CustomerController;
import it.unicam.cs.ids.FidelityCard.FidelityCard;

import java.util.GregorianCalendar;

public class CashBackRule extends FidelityProgram{
    private double cashBackPercentage;

    public CashBackRule(double cashBackPercentage, Timestamp endingDate){
        this.cashBackPercentage = cashBackPercentage;
        this.startingDate = Timestamp.of(new GregorianCalendar().getTime());
        this.endingDate = endingDate;
    }
    public CashBackRule(){

    }

    public double getCashBackPercentage() {
        return cashBackPercentage;
    }

    public void setCashBackPercentage(double cashBackPercentage) {
        this.cashBackPercentage = cashBackPercentage;
    }

    @Override
    public void applyRule(FidelityCard card, Purchase purchase) {
        double cashbackAmount = purchase.getPrice() * cashBackPercentage / 100;



    }
}
