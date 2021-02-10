package me.aparna.retirementcalculator;

import java.time.Year;
import java.util.Scanner;

public class RetirementCalculator {

    private int currentAge;
    private int retirementAge;
    private int yearsLeft;
    private static Scanner scanner = new Scanner(System.in);

    public void setAges(int currentAge, int retirementAge) {
        this.currentAge = currentAge;
        this.retirementAge = retirementAge;
    }

    public int getYearsLeft() {
        return yearsLeft;
    }

    public int getRetirementYear() {
        if(yearsLeft > 0)
            return Year.now().plusYears(yearsLeft).getValue();
        else
            return -1;
    }

    void setInputs() {
        setAges(getAge("What is your current age? "), getAge("At what age would you like to retire? "));
    }

    Integer getAge(String fieldDescription) {
        Integer result = null;
        boolean proceed = true;
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
                throw new RuntimeException("Age cannot be a negative value");
        } catch (NumberFormatException ne) {
            throw new RuntimeException("Age has to be a numeric value");
        }
        return result;
    }

    public void processRetirement() {
        yearsLeft = retirementAge - currentAge;

    }

    public void displayOutput() {
        if(yearsLeft > 0) {
            System.out.println(
                String.format(
                    "You have %d years left until you can retire. %nIt's %d, so you can retire in %d", yearsLeft, Year.now().getValue(), getRetirementYear()
                )
            );
        } else
            System.out.println("You can already retire.");
    }

    public static void main(String[] args) {
        RetirementCalculator calculator = new RetirementCalculator();
        calculator.setInputs();
        calculator.processRetirement();
        calculator.displayOutput();
    }


}
