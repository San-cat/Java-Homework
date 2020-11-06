package com.company;

public class CookingMeasurementConverter {
    public static CookingMeasurement convert(CookingMeasurement originalMeasurement,String unit) {
        float newAmount = Cooking.Units.Amounts.switching(originalMeasurement,unit);
        return new CookingMeasurement(newAmount, unit);
    }
}

