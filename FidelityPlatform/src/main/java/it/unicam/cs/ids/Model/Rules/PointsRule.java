package it.unicam.cs.ids.Model.Rules;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.FidelityProgram;
import it.unicam.cs.ids.Model.Points;
import it.unicam.cs.ids.Purchase.Purchase;

import java.util.Date;

public class PointsRule extends FidelityProgram implements RuleApplier {
    private double pointsMultiplier;

    public PointsRule(String programID, Date endingDate, Date startingDate, double pointsMultiplier) {
        super(programID, endingDate, startingDate);
        this.pointsMultiplier = pointsMultiplier;
    }
    public PointsRule(){

    }

    @Override
    public void applyRule(FidelityCard card, Purchase purchase) {
        Points points = new Points((int) (purchase.getPrice()*pointsMultiplier));
        points.setDescription("Points increased automatically due to purchase id:"+purchase.getPurchaseId());
        card.updateFidelityPoints(points);
    }
}
