package it.unicam.cs.ids.Model;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Customer.Customer;

import java.util.GregorianCalendar;
import java.util.UUID;

public abstract class FidelityProgram {

    UUID programID;
    Timestamp startingDate;
    Timestamp endingDate;

    public abstract void applyRule(Purchase purchase);


}
