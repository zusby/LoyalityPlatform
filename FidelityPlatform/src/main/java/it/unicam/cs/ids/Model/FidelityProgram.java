package it.unicam.cs.ids.Model;

import com.google.cloud.Timestamp;

import java.util.Date;
import java.util.Objects;

public class FidelityProgram{
    private String programID;

    private Date startingDate;
    private Date endingDate;


    public FidelityProgram(String programID, Date endingDate, Date startingDate) {
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
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
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
