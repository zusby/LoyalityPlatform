package it.unicam.cs.ids.FidelityCard;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Database.DBManager;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

@Service
public class FidelityCardService {

    private final DBManager dbManager;

    public FidelityCardService(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public FidelityCard createFidelityCard(String cardOwnerId) {
        FidelityCard card = new FidelityCard(
                UUID.randomUUID().toString(),
                cardOwnerId,
                Timestamp.of(new GregorianCalendar().getTime()));
        dbManager.registerFidelityCard(card);
        return card;
    }

    public FidelityCard getFidelityCard(String cardId) {
        return dbManager.getFidelityCardByCardID(cardId);
    }

    public boolean updateExpireDate(String cardId, Date newExpireDate) {
        FidelityCard fidelityCard = dbManager.getFidelityCardByCardID(cardId);
        if (fidelityCard != null) {
            fidelityCard.setDataDiScadenza(newExpireDate);
            dbManager.updateFidelityCardExpireDate(fidelityCard.getCardOwner().toString(), newExpireDate);
            return true;
        }
        //TODO bisogna ritornare uno status, 200 con descrizione se è stato modifcato correttamente, 404 se non è stato trovato
        return false;
    }

    public int getFidelityPoints(String cardId) {
        FidelityCard fidelityCard = dbManager.getFidelityCardByCardID(cardId.toString());
        if (fidelityCard != null) {
            return fidelityCard.getPunti();
        }
        return 0;
    }
}