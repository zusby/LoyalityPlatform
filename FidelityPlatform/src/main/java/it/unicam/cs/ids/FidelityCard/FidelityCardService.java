package it.unicam.cs.ids.FidelityCard;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.Database.DBManager;
import it.unicam.cs.ids.Model.Points;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
public class FidelityCardService {

    private final DBManager dbManager;

    public FidelityCardService(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public FidelityCard createFidelityCard(String cardOwnerId, String shopId) {
        GregorianCalendar expireDate = new GregorianCalendar();
        expireDate.add(Calendar.YEAR,1);
        FidelityCard card = new FidelityCard(
                UUID.randomUUID().toString(),
                cardOwnerId,
                Timestamp.of(expireDate.getTime()),
                shopId);
        dbManager.registerFidelityCard(card);
        return card;
    }

    public FidelityCard getFidelityCard(String cardId) {
        return dbManager.getFidelityCardByCardID(cardId);
    }

    public boolean updateExpireDate(String cardId, Date newExpireDate) {
        FidelityCard fidelityCard = dbManager.getFidelityCardByCardID(cardId);
        if (fidelityCard != null) {
            fidelityCard.setExpireDate(newExpireDate);
            dbManager.updateFidelityCardExpireDate(fidelityCard.getCardOwnerId(), newExpireDate);
            return true;
        }
        return false;
    }


    /**
     * This function retrieves the number of fidelity points associated with a given fidelity card ID.
     *
     * @param cardId The parameter `cardId` is a String representing the unique identifier of a fidelity card.
     * @return The method is returning an integer value which represents the number of fidelity points associated with the
     * fidelity card identified by the given cardId. If the fidelity card is found in the database, the method returns the
     * number of points associated with it. If the fidelity card is not found, the method returns -1.
     */
    public int getFidelityPoints(String cardId) {
        FidelityCard fidelityCard = dbManager.getFidelityCardByCardID(cardId.toString());
        if (fidelityCard != null) {
            return fidelityCard.getPoints();
        }
        return -1;
    }

    public boolean updatePoints(String cardId, Integer points) {
        FidelityCard fidelityCard = dbManager.getFidelityCardByCardID(cardId);
        if (fidelityCard != null) {
            fidelityCard.updateFidelityPoints(points);
            dbManager.updateFidelityPointsFromCardId(cardId,points);
            return true;
        }
        return false;
    }

    public FidelityCard getFidelityCardByUserId(String userId) {
        return dbManager.getFidelityCardByUserID(userId);
    }

    public List<Points> getPointsHistory(String id) {
        return dbManager.getFidelityCardPointsHistory(id);
    }

    public void deleteFidelityCard(String id) {
        this.dbManager.deleteFidelityCard(id);
    }

    public List<FidelityCard> getFidelityCardByShopID(String shopID) {
        return dbManager.getFidelityCardByShopID(shopID);
    }



}