package it.unicam.cs.ids.Model;


import com.google.cloud.Timestamp;

import java.util.Date;
import java.util.GregorianCalendar;

public class Points {
    private int points;
    private Date date;
    private String description;
    public Points(int points) {
        this.points = points;
        this.date = new GregorianCalendar().getTime();
    }
    public Points(){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
