package me.aparna.areacalculator;

import java.awt.geom.Area;
import java.util.Scanner;

public class AreaCalculator {
    private int lengthInFeet;
    private int breadthInFeet;
    private static Scanner scanner = new Scanner(System.in);

    public void setDimensions(int lengthInFeet, int breadthInFeet) {
        this.lengthInFeet = lengthInFeet;
        this.breadthInFeet = breadthInFeet;
    }

    public void setInputs() {
        setDimensions(getInput("What is the length of the room in feet? "),
                getInput("What is the breadth of the room in feet? "));
    }

    public Integer getInput(String fieldDescription) {
        boolean proceed = true;
        Integer result = null;
        while(proceed) {
            try {
                System.out.print(fieldDescription);
                result = validateResult(scanner.nextLine());
                proceed = false;
            } catch (RuntimeException re) {
                System.out.println(re.getMessage());
            }
        }
        return result;
    }

    public Integer validateResult(String fieldValue) {
        Integer result = null;
        try {
            result = Integer.parseInt(fieldValue);
            if(result < 0)
                throw new RuntimeException("Do not enter negative values");
        } catch(NumberFormatException ne) {
            throw new RuntimeException("Please enter numerical value");
        }
        return result;
    }
    public int getSquareFeet() {
        return lengthInFeet * breadthInFeet;
    }

    public double getSquareMetres() {
        return ConversionUtil.getSquareMetresFromFeet(lengthInFeet * breadthInFeet);
    }

    public void displayOutput() {
        System.out.printf("You entered dimensions of %d feet by %d feet. %n" +
                "The area is %n" +
                "%d square feet%n" +
                "%.3f square meters", lengthInFeet, breadthInFeet, getSquareFeet(), getSquareMetres());
    }

    public static void main(String[] args) {
        AreaCalculator calculator = new AreaCalculator();
        calculator.setInputs();
        calculator.displayOutput();
    }
}

class ConversionUtil {
    public static double getSquareMetresFromFeet(int squareFeet) {
        return squareFeet * 0.09290304;
    }

    public static double getSquareFeetFromMetres(int squareMetres) {
        return squareMetres / 0.0929034;
    }
}
