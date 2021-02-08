package me.aparna.simplemath;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleMathCalculator {

    private int number1;
    private int number2;
    private int sum, diff, prod, quot;
    private static Scanner scanner = new Scanner(System.in);


    public void setInputs(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public void setNumbers() {
        setInputs(getInput("number1"), getInput("number2"));
    }

    public Integer getInput(String fieldName) {
        Integer result = null;
        boolean proceed = true;
        while(proceed) {
            try {
                System.out.printf("What is the %s number? ", fieldName.equals("number1") ? "first" : "second");
                result = validateResult(fieldName, scanner.nextLine());
                proceed = false;
            } catch (RuntimeException re) {
                System.out.println(re.getMessage());
            }
        }
        return result;
    }

    public static Integer validateResult(String fieldName, String fieldValue) {
        Integer result = null;
        try {
            result = Integer.parseInt(fieldValue);
            if (result.intValue() < 0)
                throw new RuntimeException("Do not enter negative numbers");
        } catch (NumberFormatException ne) {
            throw new RuntimeException("Enter only numeric values");
        }
        return result;
    }

    public void performOperations() {
        this.sum = number1 + number2;
        this.diff = number1 - number2;
        this.prod = number1 * number2;
        this.quot = number1 / number2;
    }

    public int getSum() {
        return sum;
    }

    public int getDiff() {
        return diff;
    }

    public int getProd() {
        return prod;
    }

    public int getQuot() {
        return quot;
    }

    public void displayOutput() {
        Map<String, Integer> operatorValues = new LinkedHashMap<>();
        operatorValues.put("+", sum);
        operatorValues.put("-", diff);
        operatorValues.put("*", prod);
        operatorValues.put("/", quot);
        for(String op : operatorValues.keySet())
            System.out.printf("%d %s %d = %d%n", number1, op, number2, operatorValues.get(op));
    }

    public static void main(String[] args) {
        SimpleMathCalculator calculator = new SimpleMathCalculator();
        calculator.setNumbers();
        calculator.performOperations();
        calculator.displayOutput();
    }

}
