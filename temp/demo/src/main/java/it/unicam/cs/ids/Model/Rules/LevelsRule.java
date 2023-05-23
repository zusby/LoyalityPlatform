package it.unicam.cs.ids.Model.Rules;

import com.google.cloud.Timestamp;
import it.unicam.cs.ids.FidelityCard.FidelityCard;
import it.unicam.cs.ids.Model.FidelityProgram;
import it.unicam.cs.ids.Model.Level;
import it.unicam.cs.ids.Model.Purchase;
import it.unicam.cs.ids.Model.RuleApplier;

public class LevelsRule extends FidelityProgram implements RuleApplier {
    private Level bronze = Level.BRONZE;
    private Level silver = Level.SILVER;
    private Level gold = Level.GOLD;
    private Level platinum = Level.PLATINUM;
    private double multiplier;


    public Level getBronze() {
        return bronze;
    }

    public void setBronze(Level bronze) {
        this.bronze = bronze;
    }

    public Level getSilver() {
        return silver;
    }

    public void setSilver(Level silver) {
        this.silver = silver;
    }

    public Level getGold() {
        return gold;
    }

    public void setGold(Level gold) {
        this.gold = gold;
    }


    public void setBronzeRange(int minRange, int maxRange) {
        this.platinum.setMaxValue(maxRange);
        this.platinum.setMinValue(minRange);
    }

    public void setSilverRange(int minRange, int maxRange) {
        this.platinum.setMaxValue(maxRange);
        this.platinum.setMinValue(minRange);
    }

    public void setGoldRange(int minRange, int maxRange) {
        this.platinum.setMaxValue(maxRange);
        this.platinum.setMinValue(minRange);
    }

    public void setPlatinumRange(int minRange, int maxRange) {
       this.platinum.setMaxValue(maxRange);
       this.platinum.setMinValue(minRange);
    }

    public Level getLevel(int exp){
        return Level.getLevelByValue(exp);
    }


    public LevelsRule(Timestamp startingDate, Timestamp endingDate, double multiplier) {
        super("1", startingDate, endingDate);
        this.multiplier = multiplier;
    }

    public LevelsRule() {

    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public void applyRule(FidelityCard card, Purchase purchase) {
        card.updateExp((int)(purchase.getPrice()*multiplier));
    }

    @Override
    public String toString() {
        return "LevelsRule{" +
                "multiplier=" + multiplier +
                "} " + super.toString();
    }
}
