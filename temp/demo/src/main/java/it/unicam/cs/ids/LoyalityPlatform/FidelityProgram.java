package it.unicam.cs.ids.LoyalityPlatform;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.Model.Purchase;

import java.util.GregorianCalendar;
import java.util.UUID;

public abstract class FidelityProgram {

    String programID;
    Timestamp startingDate;
    Timestamp  endingDate;

    String description;

    public abstract void applyRule(Purchase purchase);


}
