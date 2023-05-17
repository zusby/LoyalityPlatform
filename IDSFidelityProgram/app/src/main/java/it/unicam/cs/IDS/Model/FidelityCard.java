package it.unicam.cs.IDS.Model;

import java.util.GregorianCalendar;
import java.util.UUID;

public class FidelityCard {
    private UUID id;
    private UUID cardOwner;
    private GregorianCalendar dataDiScadenza;
    private int punti;

    public FidelityCard(UUID id, UUID cardOwner, GregorianCalendar dataDiScadenza, int punti) {
        this.id = id;
        this.cardOwner = cardOwner;
        this.dataDiScadenza = dataDiScadenza;
        this.punti = punti;
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

    public GregorianCalendar getDataDiScadenza() {
        return dataDiScadenza;
    }

    public void setDataDiScadenza(GregorianCalendar dataDiScadenza) {
        this.dataDiScadenza = dataDiScadenza;
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
