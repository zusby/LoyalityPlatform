package it.unicam.cs.ids.Model.Rules;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.FidelityProgram;
import it.unicam.cs.ids.Model.Purchase;

public class PointsRule extends FidelityProgram implements RuleApplier {
    private double pointsMultiplier;

    public PointsRule(String programID, Timestamp endingDate, Timestamp startingDate, double pointsMultiplier) {
        super(programID, endingDate, startingDate);
        this.pointsMultiplier = pointsMultiplier;
    }

    @Override
    public void applyRule(FidelityCard card, Purchase purchase) {
        card.updateFidelityPoints(purchase.getPrice()*pointsMultiplier);
    }
}
