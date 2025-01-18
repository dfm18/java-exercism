package com.dfm18.exercism.cookyourlasagna;

public class Lasagna {

    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int minutes) {
        if (expectedMinutesInOven() - minutes > 0) {
            return expectedMinutesInOven() - minutes;
        } else {
            return 0;
        }
    }

    public int preparationTimeInMinutes(int layers) {
        return 2 * layers;
    }

    public int totalTimeInMinutes(int layers, int minutes) {
        return preparationTimeInMinutes(layers) + minutes;
    }
}
