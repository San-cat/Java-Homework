package com.company;
import java.util.Scanner;

public class ReceiptPrompt {

    public void run(){
        Scanner scanner = new Scanner(System.in);
        displayMenu();
        System.out.println("Select number from menu");
        int action = scanner.nextInt();
        switch (action) {
            case 1 -> cookingMeasurementConverter();
            case 2 -> recipeFromStringConverter();
            }
        }
    public void recipeFromStringConverter () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ingredient, amount, unit: ");
        String input = scanner.nextLine();

        String [] measurements = input.split(" ");

        for (int i = 0; i < measurements.length; i++) {
            if (numberCheck(measurements[i])) {
                float number = Float.parseFloat(measurements[i++]);

                if (Cooking.Units.isValid(measurements[i])) {
                    CookingMeasurement calculated = CookingMeasurementConverter.convert(new CookingMeasurement(number,
                            measurements[i].toUpperCase()), "ML");
                    System.out.println(" Amount: " + calculated.getAmount() + " ML");
                }
            }
            if (!numberCheck(measurements[i]) && !Cooking.Units.isValid(measurements[i])) {
                String component = measurements[i];
                System.out.println(component);
            }
        }
    }
    private boolean numberCheck(String num) {
        try {
            Float.parseFloat(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void cookingMeasurementConverter () {
        float amount = promptAmount();
        String fromUnit = promptUnit();
        String toUnit = promptUnit1();
        CookingMeasurement calculated = CookingMeasurementConverter.convert(new CookingMeasurement(amount, fromUnit.toUpperCase()),toUnit);
        System.out.println("Amount = " + calculated.getAmount() + "\nUnit from which converted: " +
                fromUnit.toUpperCase() + "\nConverted to: " + toUnit.toUpperCase());
    }

    private float promptAmount(){
        System.out.println("Enter amount:");
        Scanner input = new Scanner(System.in);
        float amount = input.nextFloat();
        while (amount <= 0){
            System.out.println("Number should be entered:");
            amount = input.nextFloat();
        }
        return amount;
    }
    private String promptUnit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter unit:");
        String unit = scanner.next().toUpperCase();
        if (Cooking.Units.isValid(unit)) {
            while (Cooking.Units.isValid(unit)) {
                System.out.println("Unit doesn't exist, enter again:");
                unit = scanner.next().toUpperCase();
            }
        }
        return unit;
    }
    private String promptUnit1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter unit to convert:");
        String unit = scanner.next().toUpperCase();
        if (Cooking.Units.isValid(unit)) {
            while (Cooking.Units.isValid(unit)) {
                System.out.println("Unit doesn't exist, enter again:");
                unit = scanner.next().toUpperCase();
            }
        }
        return unit;
    }

    private void displayMenu () {
        System.out.println("Menu");
        System.out.println("[1] - basic conversion of a measurement\n" +
                "[2] - recipe processing");
    }
}


