package me.aparna.printingquotes;

import java.util.Scanner;

public class PrintingQuotes {
    private String quote;
    private String speaker;
    private static Scanner scanner = new Scanner(System.in);

    public void setInputs(String quote, String speaker) {
        this.quote = quote;
        this.speaker = speaker;
    }

    public String getOutputString() {
        return speaker + " says, \"" + quote + "\"";
    }

    public void displayOutput() {
        System.out.println(getOutputString());
    }

    public static void main(String[] args) {
        System.out.print("What is the quote? ");
        String quote = scanner.nextLine();
        System.out.print("Who said it? ");
        String speaker = scanner.nextLine();
        PrintingQuotes printingQuotes = new PrintingQuotes();
        printingQuotes.setInputs(quote, speaker);
        printingQuotes.displayOutput();
    }
}
