package it.unicam.cs.ids.Model;

import com.google.cloud.Timestamp;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class FidelityCard {
    private UUID id;
    private UUID cardOwner;
    private Timestamp dataDiScadenza;
    private int punti;

    public FidelityCard(UUID id, UUID cardOwner, Timestamp dataDiScadenza, int punti) {
        this.id = id;
        this.cardOwner = cardOwner;
        this.dataDiScadenza = dataDiScadenza;
        this.punti = punti;
    }
    public FidelityCard(){

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(UUID cardOwner) {
        this.cardOwner = cardOwner;
    }

    public Date getExpireDate() {
        return dataDiScadenza.toDate();
    }


    public void setDataDiScadenza(Date dataDiScadenza) {
        this.dataDiScadenza = Timestamp.of(dataDiScadenza);
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    @Override
    public String toString() {
        return "FidelityCard{" +
                "id=" + id +
                ", cardOwner=" + cardOwner +
                ", dataDiScadenza=" + dataDiScadenza +
                ", punti=" + punti +
                '}';
    }
}
