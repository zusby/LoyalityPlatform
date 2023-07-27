package it.unicam.cs.ids.Model;

import java.util.HashMap;
import java.util.Map;

public enum Level {
    BRONZE(0, 500),
    SILVER(501, 1000),
    GOLD(1001, 2000),
    PLATINUM(2001, Integer.MAX_VALUE);

    private int minValue;
    private int maxValue;
    Level(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }


    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public static Level getLevelByValue(int value) {
        for (Level level : Level.values()) {
            if (value >= level.getMinValue() && value <= level.getMaxValue()) {
                return level;
            }
        }
        return Level.BRONZE;
    }

}