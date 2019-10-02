package Exceptions;

import Observer.BudgetObserver;

import java.util.Scanner;

public class NumberException {

    public static int notInteger(Scanner reader) {
    System.out.print("Type a integer, Not String. ");
    // AskBudget(qMessage, aMessage, close);
    System.out.println("Please try again:");
    String str = reader.next();
    int n =  Integer.parseInt(str);
    return n;
    }

    public static int readerTry (Scanner reader) {
        String str = reader.next();
        int n =  Integer.parseInt(str);
        return n;
    }
}
