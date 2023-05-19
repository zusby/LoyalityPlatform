package it.unicam.cs.ids.Model;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.Transaction;
import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Database.DBManager;

import java.util.GregorianCalendar;

public class CashBackRule extends FidelityProgram{
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
