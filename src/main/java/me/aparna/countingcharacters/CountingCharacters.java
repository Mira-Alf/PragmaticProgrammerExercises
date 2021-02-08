package me.aparna.countingcharacters;

import java.util.Scanner;

public class CountingCharacters {

    private static Scanner scanner = new Scanner(System.in);
    private String inputString;

    public String getOutputString() {
        if(inputString.length() == 0)
            return "You must enter some input string";
        else
            return inputString + " has " + inputString.length() + " characters.";
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public void countCharacters() {
        System.out.print("What is the input string? ");
        setInputString(scanner.next());
        System.out.println(getOutputString());
    }

    public static void main(String[] args) {
        CountingCharacters countingCharacters = new CountingCharacters();
        countingCharacters.countCharacters();
    }

}
