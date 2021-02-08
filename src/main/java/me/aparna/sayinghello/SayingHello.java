package me.aparna.sayinghello;

import java.util.Scanner;

public class SayingHello {

    private String name;
    private static Scanner scanner = new Scanner(System.in);

    public String getName() {
        System.out.print("What is your name? ");
        return scanner.next();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreeting() {
        return "Hello, "+this.name+", nice to meet you!";
    }

    public void displayGreeting() {
        System.out.println(getGreeting());
    }

    public static void main(String[] args) {
        SayingHello helloWorld = new SayingHello();
        helloWorld.setName( helloWorld.getName() );
        helloWorld.displayGreeting();
    }
}
