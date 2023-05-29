package it.unicam.cs.ids.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Customer.Customer;
import it.unicam.cs.ids.FidelityCard.FidelityCard;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.UUID;

public class FidelityProgram{
    private String programID;

    private Timestamp startingDate;
    private Timestamp endingDate;


    public FidelityProgram(String programID, Timestamp endingDate, Timestamp startingDate) {
        this.programID = programID;
        this.endingDate = endingDate;
        this.startingDate = startingDate;
    }
    public FidelityProgram(){

    }



    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    public Date getStartingDate() {
        return startingDate.toDate();
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = Timestamp.of(startingDate);
    }

    public Date getEndingDate() {
        return endingDate.toDate();
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = Timestamp.of(endingDate);
    }

    @Override
    public String toString() {
        return "FidelityProgram{" +
                "endingDate=" + endingDate +
                ", programID='" + programID + '\'' +
                ", startingDate=" + startingDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FidelityProgram that = (FidelityProgram) o;
        return getProgramID().equals(that.getProgramID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProgramID());
    }
}