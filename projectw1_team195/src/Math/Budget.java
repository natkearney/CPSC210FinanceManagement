package Math;


import ui.FileReaderWriter;
import ui.FinanceApp;
import javax.swing.*;

import java.io.IOException;


public class Budget {

/*    public static int AskBudget(String qMessage, String aMessage, String close){
        Scanner reader = new Scanner(System.in);
        int n = 0;
        System.out.println(qMessage);
        try {
            n = NumberException.readerTry(reader);
        }
        catch(Exception e) {
            n = NumberException.notInteger(reader);
        }
        System.out.println(aMessage + n + close);
        String s = String.valueOf(n);
        try {
            FileReaderWriter.save(1, s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return n;
    }*/

    public static void budget() {
        String amount = JOptionPane.showInputDialog(FinanceApp.frame,
                "Your current monthly budget is $" + FinanceApp.budget +".\n Insert new value:", null);
        if (amount != null){
        try {
            FileReaderWriter.save(1, amount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FinanceApp.budget = Integer.valueOf(amount);
        BudgetCalculator.updateLimits();

    }
    }




}
