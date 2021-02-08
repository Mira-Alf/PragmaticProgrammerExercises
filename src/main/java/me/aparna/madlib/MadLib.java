package me.aparna.madlib;

import java.util.Scanner;

public class MadLib {

    private String noun;
    private String verb;
    private String adjective;
    private String adverb;
    private static Scanner scanner = new Scanner(System.in);

    public void setInputs(String noun, String verb, String adjective, String adverb) {
        this.noun = noun;
        this.verb = verb;
        this.adjective = adjective;
        this.adverb = adverb;
    }

    public String getOutputString() {
        return String.format("Do you %s your %s %s %s? That's hilarious!", verb, adjective, noun, adverb);
    }

    public void displayOutputString() {
        System.out.println(getOutputString());
    }

    public static void main(String[] args) {
        MadLib madLib = new MadLib();
        System.out.print("Enter a noun: ");
        String noun = scanner.nextLine();
        System.out.print("Enter a verb: ");
        String verb = scanner.nextLine();
        System.out.print("Enter an adjective: ");
        String adjective = scanner.nextLine();
        System.out.print("Enter an adverb: ");
        String adverb = scanner.nextLine();
        madLib.setInputs(noun, verb, adjective, adverb);
        madLib.displayOutputString();
    }




}
