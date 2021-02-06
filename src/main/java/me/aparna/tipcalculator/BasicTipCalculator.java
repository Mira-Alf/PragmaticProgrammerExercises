package me.aparna.tipcalculator;

import java.util.Scanner;

public class BasicTipCalculator {

    private static Scanner scanner = new Scanner(System.in);
    private static BasicTipCalculator calculator = new BasicTipCalculator();
    private double billAmount;
    private int tipPercentage;
    private double tipAmount;
    private double totalAmount;

    public void setInputs(double billAmount, int tipPercentage) {
        this.billAmount = billAmount;
        this.tipPercentage = tipPercentage;
    }

    private void setBillAmount() {
        this.billAmount = getInput("billAmount", "Enter the bill amount: ").doubleValue();
    }

    private void setTipPercentage() {
        this.tipPercentage = getInput("tipPercentage", "Enter the tip percentage: ").intValue();
    }

    private static Number getInput(String fieldName, String description) {
        boolean proceed = true;
        Number result = null;
        while(proceed) {
            try {
                System.out.print(description);
                String fieldValue = scanner.next();
                result = validateResult(fieldName, fieldValue);
                proceed = false;
            } catch(RuntimeException re) {
                System.out.println(re.getMessage());
                proceed = true;
            }
        }
        return result;
    }

    public static Number validateResult(String fieldName, String fieldValue) {
        Number result = null;
        try {
            if (fieldName.equals("billAmount")) {
                fieldValue = fieldValue.startsWith("$") ? fieldValue.substring(1) : fieldValue;
                result = Double.parseDouble(fieldValue);
            } else {
                fieldValue = fieldValue.endsWith("%") ? fieldValue.substring(0, fieldValue.length() - 1) : fieldValue;
                result = Integer.parseInt(fieldValue);
            }
            if (result.doubleValue() < 0)
                throw new RuntimeException("Do not enter negative numbers");
        } catch (NumberFormatException ne) {
            throw new RuntimeException("Enter only numeric values");
        }
        return result;
    }

    public void calculateTip() {
        this.tipAmount = (tipPercentage/100.0)*billAmount;
    }

    public void calculateTotal() {
        calculateTip();
        this.totalAmount = billAmount + tipAmount;
    }

    public String getTip() {
        return formatCurrency(tipAmount);
    }

    public String getTotal() {
        return formatCurrency(totalAmount);
    }

    public static void main(String[] args) {
        calculator.setBillAmount();
        calculator.setTipPercentage();
        calculator.calculateTotal();
        System.out.println("The tip is "+calculator.getTip());
        System.out.println("The total amount is "+calculator.getTotal());
    }

    public static String formatCurrency(double amount) {
        return String.format("$%.2f", amount);
    }
}