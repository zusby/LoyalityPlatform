package it.unicam.cs.ids.Model;


import com.google.cloud.Timestamp;

import java.util.Date;
import java.util.GregorianCalendar;

public class Points {
    private int points;
    private Timestamp date;

    public Points(int points) {
        this.points = points;
        this.date = Timestamp.of(new GregorianCalendar().getTime());
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getDate() {
        return date.toDate();
    }

    public void setDate(Date date) {
        this.date = Timestamp.of(date);
    }
}
