package me.aparna.sayinghello;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SayingHelloUpgrade {
    private static List<String> greetings = List.of("nice to meet you", "how are you doing?", "howdy!", "hope you are well");
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public void displayGreeting() {
        System.out.print("What is your name? ");
        System.out.println("Hello, "+scanner.next()+", " + greetings.get(random.nextInt(greetings.size())));
    }

    public static void main(String[] args) {
        SayingHelloUpgrade sayingHelloUpgrade = new SayingHelloUpgrade();
        sayingHelloUpgrade.displayGreeting();
    }
}
