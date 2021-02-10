package me.aparna.areacalculator;

import java.util.Scanner;

public class UpgradedAreaCalculator {

    private int length;
    private int breadth;
    private static Scanner scanner = new Scanner(System.in);

    private Unit unit;

    public void setDimensions(int unit, int length, int breadth) {
        this.unit = unit == 0 ? Unit.METRE : Unit.FEET;
        this.length = length;
        this.breadth = breadth;
    }

    public void setDimensions(Unit unit, int length, int breadth) {
        this.unit = unit;
        this.length = length;
        this.breadth = breadth;
    }

    public double getAreaInSquareMetres() {
        int area = length * breadth;
        double areaInDouble = unit == Unit.METRE ? area : convertValue(area);
        return Double.parseDouble(String.format("%.3f", areaInDouble));
    }

    public double getAreaInSquareFeet() {
        int area = length * breadth;
        double areaInDouble = unit == Unit.FEET ? area : convertValue(area);
        return Double.parseDouble(String.format("%.3f", areaInDouble));
    }

    private double convertValue(int area) {
        return unit == Unit.METRE ? ConversionUtil.getSquareFeetFromMetres(area) : ConversionUtil.getSquareMetresFromFeet(area);
    }

    public void setInputs() {
        setDimensions(getInput("unit", "Enter the unit of the dimension(0 for metre or 1 for feet): "),
                    getInput("length", "What is the length of the room? "),
                    getInput("breadth", "What is the breadth of the room? "));
    }

    public Integer getInput(String fieldName, String fieldDescription) {
        boolean proceed = true;
        Integer result = null;
        while(proceed) {
            try {
                System.out.print(fieldDescription);
                result = validateResult(fieldName, scanner.nextLine());
                proceed = false;
            } catch(RuntimeException re) {
                System.out.println(re.getMessage());
            }
        }
        return result;
    }

    public static Integer validateResult(String fieldName, String fieldValue) {
        Integer result = null;
        try {
            result = Integer.parseInt(fieldValue);
            if(fieldName.equals("unit") && result != 0 && result != 1)
                    throw new RuntimeException("Please enter a valid value - 0 for metre and 1 for feet");
            else{
                if(result < 0)
                    throw new RuntimeException("Do not enter negative values");
            }
        } catch(NumberFormatException ne) {
            throw new RuntimeException("Please enter a numerical value");
        }
        return result;
    }

    public void displayOutput() {
        System.out.printf(getOutput());
    }

    public String getOutput() {
        return String.format("You entered dimensions of %d %s by %d %s. %n" +
                "The area is %n" +
                "%.3f square feet%n" +
                "%.3f square meters", length, unit == Unit.METRE ? "meters" : "feet",
                breadth, unit == Unit.METRE ? "meters" : "feet",
                getAreaInSquareFeet(), getAreaInSquareMetres());
    }

    public static void main(String[] args) {
        UpgradedAreaCalculator calculator = new UpgradedAreaCalculator();
        calculator.setInputs();
        calculator.displayOutput();

    }
}

enum Unit {
    METRE, FEET;
}
