package com.company;

public class Cooking {

    public static class Units {
        public static final String ML = "ML";
        public static final String TSP = "TSP";
        public static final String TBSP = "TBSP";
        public static final String FL_OUNCE = "FL_OUNCE";
        public static final String CUP = "CUP";
        public static final String PINT = "PINT";
        public static final String QUART = "QUART";
        public static final String GALLON = "GALLON";
        public static final String OZ = "OZ";
        public static final String POUND = "POUND";

        public static String[] values = {ML, TSP, TBSP, FL_OUNCE, CUP, PINT, QUART, GALLON, OZ, POUND};

        public static boolean isValid (String input) {
            for (String value : values) {
                if (input.toUpperCase().equals(value)) {
                    return true;
                }
            }
            return false;
        }

        public static class Amounts {
            public static final float TSP = 5f;
            public static final float ML = 1f;
            public static final float TBSP = 15f;
            public static final float FL_OUNCE = 30f;
            public static final float CUP = 237f;
            public static final float PINT = 473f;
            public static final float QUART = 946f;
            public static final float GALLON = 3785f;
            public static final float OZ = 30f;
            public static final float POUND = 454f;

            public static float value(String unit) {
                return switch (unit) {
                    case Units.TSP -> TSP;
                    case Units.ML -> ML;
                    case Units.OZ -> OZ;
                    case Units.POUND -> POUND;
                    case Units.GALLON -> GALLON;
                    case Units.QUART -> QUART;
                    case Units.PINT -> PINT;
                    case Units.CUP -> CUP;
                    case Units.FL_OUNCE -> FL_OUNCE;
                    case Units.TBSP -> TBSP;
                    default -> 0;
                };
            }
            public static float switching(CookingMeasurement originalMeasurement, String unit) {
                float newAmount = 0;
                switch (unit.toUpperCase()) {
                    case "TSP" -> newAmount = (value(originalMeasurement.getUnit()) / getTSP()) * originalMeasurement.getAmount();
                    case "OZ" -> newAmount = (value(originalMeasurement.getUnit()) / getOZ()) * originalMeasurement.getAmount();
                    case "POUND" -> newAmount = (value(originalMeasurement.getUnit()) / getPOUND()) * originalMeasurement.getAmount();
                    case "QUART" -> newAmount = (value(originalMeasurement.getUnit()) / getQUART()) * originalMeasurement.getAmount();
                    case "GALLON" -> newAmount = (value(originalMeasurement.getUnit()) / getGALLON()) * originalMeasurement.getAmount();
                    case "PINT" -> newAmount = (value(originalMeasurement.getUnit()) / getPINT()) * originalMeasurement.getAmount();
                    case "CUP" -> newAmount = (value(originalMeasurement.getUnit()) / getCUP()) * originalMeasurement.getAmount();
                    case "FL_OUNCE" -> newAmount = (value(originalMeasurement.getUnit()) / getFlOunce()) * originalMeasurement.getAmount();
                    case "TBSP" -> newAmount = (value(originalMeasurement.getUnit()) / getTBSP()) * originalMeasurement.getAmount();
                    case "ML" -> newAmount = (value(originalMeasurement.getUnit()) / getML()) * originalMeasurement.getAmount();
                    default -> System.out.println("Enter again");
                }
                return newAmount;
            }
            private static float getML() {
                return 0;
            }
            private static float getTBSP() {
                return 0;
            }
            private static float getFlOunce() {
                return 0;
            }
            private static float getCUP() {
                return 0;
            }
            private static float getPINT() {
                return 0;
            }
            private static float getGALLON() {
                return 0;
            }
            private static float getQUART() {
                return 0;
            }
            private static float getPOUND() {
                return 0;
            }
            private static float getOZ() {
                return 0;
            }
            private static float getTSP() {
                return 0;
            }
        }
    }
}
