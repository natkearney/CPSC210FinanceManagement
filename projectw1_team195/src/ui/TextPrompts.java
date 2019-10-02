package ui;


import javax.swing.*;


public class TextPrompts {


    public static String CategoryMenu(){
        String amount = JOptionPane.showInputDialog(FinanceApp.frame, "What would you like to do? \n " +
                "[1] Edit Categories \n " +
                "[2] Edit Category Percentage \n " +
                "[3] Add Category \n " +
                "[4] Add Special Category \n " +
                "[5] Remove Category \n " +
                "[6] Check if Equal \n ", null);
        return amount;
    }


    public static void CategoryNameCreated(String answerString) {
        System.out.println("Category " + answerString + " created. Assign percentage:");
    }

    public static void CategoryCreated(String answerString, int answer) {
        System.out.println("Category " + answerString + " with percentage " + answer + "% created.");
    }

    public static void over100() {
    System.out.println("Assigned percentages over 100%. Please Re-assign.");}



}
