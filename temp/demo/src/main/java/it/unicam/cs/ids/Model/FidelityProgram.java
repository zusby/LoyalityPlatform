package it.unicam.cs.ids.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.FidelityCard.FidelityCard;

import java.util.GregorianCalendar;
import java.util.UUID;

public abstract class FidelityProgram {
    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    public Timestamp getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Timestamp startingDate) {
        this.startingDate = startingDate;
    }

    public Timestamp getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Timestamp endingDate) {
        this.endingDate = endingDate;
    }

    String programID;
    Timestamp startingDate;
    Timestamp endingDate;

    public abstract void applyRule(FidelityCard customer, Purchase purchase);
}
