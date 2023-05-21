package it.unicam.cs.ids.FidelityCard;

import it.unicam.cs.ids.Database.DBManager;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Service
public class FidelityCardService {

    private final DBManager dbManager;

    public FidelityCardService(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public FidelityCard createFidelityCard(UUID cardOwner) {
        FidelityCard fidelityCard = new FidelityCard();
        fidelityCard.setId(UUID.randomUUID());
        fidelityCard.setCardOwner(cardOwner);
        fidelityCard.setDataDiScadenza(new Date());
        fidelityCard.setPunti(0);

        dbManager.registerFidelityCard(fidelityCard);

        return fidelityCard;
    }

    public FidelityCard getFidelityCard(String cardId) {
        return dbManager.getFidelityCardByUserID(cardId);
    }

    public boolean updateExpireDate(String cardId, Date newExpireDate) {
        FidelityCard fidelityCard = dbManager.getFidelityCardByCardID(cardId);
        if (fidelityCard != null) {
            fidelityCard.setDataDiScadenza(newExpireDate);
            dbManager.updateFidelityCardExpireDate(fidelityCard.getCardOwner().toString(), newExpireDate);
            return true;
        }
        return false;
    }

    public int getFidelityPoints(UUID cardId) {
        FidelityCard fidelityCard = dbManager.getFidelityCardByCardID(cardId.toString());
        if (fidelityCard != null) {
            return fidelityCard.getPunti();
        }
        return 0;
    }
}