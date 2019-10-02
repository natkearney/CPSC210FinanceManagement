package Category;

import ui.FinanceApp;
import ui.TextPrompts;
import ui.UserInteraction;
import Math.BudgetCalculator;

import javax.swing.*;


public class CategoryEditor {

    public static String PrintCategories() {
        int i = 1;
        String s = "";

        for (Category c : FinanceApp.ListOfCategories) {
            if (c.isSpecial == false) {
                if (c.name != "") {
                    s += "[" + c.getType() + " – " + i + "]: " + c.name + ", Percentage Assigned: " + c.percentage + "% \n";
                    i++;
                }
            }
            if (c.isSpecial == true) {
                if (c.name != "") {
                    s +="[" + c.getType() + " – " + i + "]: " + c.name + ", Budget Given: $" + c.percentage + "\n";
                    i++;
                }
            }
        }
    return s;
    }

    public static void categoryCreator() {
        JOptionPane.showMessageDialog(FinanceApp.frame, "No categories found.\n Please create categories now:");
        FinanceApp.c1.addCategory();
        CategoryQuickSearch.addCategory(FinanceApp.c1);
        CategoryQuickSearch.addLimit(FinanceApp.c1);
        createAnotherCategory();
        UserInteraction.WhatToDo();
    }

    public static void createAnotherCategory() {
        int yesOrNo = JOptionPane.showConfirmDialog(FinanceApp.frame, "Add another category?", "Add Category?", JOptionPane.YES_OPTION);

        if (yesOrNo == 0) {
            addCategoryCheck();
            createAnotherCategory();
        }
    }

    public static void percentageFix() {
        int answer;
        int newPercentage;

        String amount = JOptionPane.showInputDialog(FinanceApp.frame, "These are your current budgets: \n" + PrintCategories() +
                "\n Which would you like to change their assigned percentage?", null);

        answer = Integer.valueOf(amount);
        String name = FinanceApp.ListOfCategories.get(answer+2).name;
        amount = JOptionPane.showInputDialog(FinanceApp.frame, "Category " + name + ". Assign percentage:", null);
        /*try {
            newPercentage = NumberException.readerTry(reader);
        }
        catch(Exception e) {
            newPercentage = NumberException.notInteger(reader);
        }*/
        newPercentage = Integer.valueOf(amount);

        FinanceApp.ListOfCategories.get(answer + 2).changePercentage(newPercentage);
        boolean percentageOK = BudgetCalculator.PercentageCheck(FinanceApp.ListOfCategories);
        if (percentageOK == false) {
            JOptionPane.showMessageDialog(FinanceApp.frame,
                    "Percentages still over 100%. Please try again.");
            percentageFix();
        }
        BudgetCalculator.updateLimits();
        int yesOrNo = JOptionPane.showConfirmDialog(FinanceApp.frame, "Change another category?", "Change another?", JOptionPane.YES_OPTION);
        if (yesOrNo == 0) {
            percentageFix();
        }
        UserInteraction.WhatToDo();
    }

    public static void nameFix() {
        int answer;

        String amount = JOptionPane.showInputDialog(FinanceApp.frame, "These are your current categories: \n" + PrintCategories() +
                "\n Which would you like to change their name?", null);
        answer = Integer.valueOf(amount);
        amount = JOptionPane.showInputDialog(FinanceApp.frame, "Category " + FinanceApp.ListOfCategories.get(answer + 2).name + ". \n New name:");
        FinanceApp.ListOfCategories.get(answer + 2).changeName(amount);
    }

    public static void removeCategory() {
        int answer;

        String amount = JOptionPane.showInputDialog(FinanceApp.frame, "These are your current categories: \n" + PrintCategories() +
                "\n Which would you like to remove?", null);
        answer = Integer.valueOf(amount);
        int yesOrNo = JOptionPane.showConfirmDialog(FinanceApp.frame, "Category " + FinanceApp.ListOfCategories.get(answer + 2).name + " will be removed. " +
                "\n Are you sure?", "Delete Category?", JOptionPane.YES_OPTION);
        if (yesOrNo == 0)
            FinanceApp.ListOfCategories.get(answer + 2).name = "";
    }

    public static void addCategoryCheck(){
        if (FinanceApp.c1.checkIfEmpty() == true){
            FinanceApp.c1.addCategory();
            CategoryQuickSearch.addCategory(FinanceApp.c1);
            CategoryQuickSearch.addLimit(FinanceApp.c1);
        }
        else if (FinanceApp.c2.checkIfEmpty() == true){
            FinanceApp.c2.addCategory();
            CategoryQuickSearch.addCategory(FinanceApp.c2);
            CategoryQuickSearch.addLimit(FinanceApp.c2);
        }
        else if (FinanceApp.c3.checkIfEmpty() == true){
            FinanceApp.c3.addCategory();
            CategoryQuickSearch.addCategory(FinanceApp.c3);
            CategoryQuickSearch.addLimit(FinanceApp.c3);

        }
        else if (FinanceApp.c4.checkIfEmpty() == true){
            FinanceApp.c4.addCategory();
            CategoryQuickSearch.addCategory(FinanceApp.c4);
            CategoryQuickSearch.addLimit(FinanceApp.c4);

        }
        else if (FinanceApp.c5.checkIfEmpty() == true){
            FinanceApp.c5.addCategory();
            CategoryQuickSearch.addCategory(FinanceApp.c5);
            CategoryQuickSearch.addLimit(FinanceApp.c5);

        }
        else {
            JOptionPane.showMessageDialog(FinanceApp.frame,
                    "All category slots taken. Please delete category before adding a new one."); }
    }

    public static void check() {
        boolean percentageOK = BudgetCalculator.PercentageCheck(FinanceApp.ListOfCategories);
        if (percentageOK == true) {
            BudgetCalculator.updateLimits();
        } else {
            TextPrompts.over100();
            percentageFix();
        }
    }

    public static boolean checkIfListEmpty(){
        for (Category c : FinanceApp.ListOfCategories) {
           if(c.name != "") {return false;}
        }
    return true;
    }

    public static void isEqual(Category r, Category s){
        if (r.equals(s)){
            JOptionPane.showMessageDialog(FinanceApp.frame,
                    "These categories are the same.");
        }
        else {
            JOptionPane.showMessageDialog(FinanceApp.frame,
                    "These categories are not the same.");
            }
    }

    public static String printLimit() {
        int i = 1;
        String s = "";
        for (Category c : FinanceApp.ListOfCategories) {

            if (c.isSpecial == false) {
                if (c.name != "") {
                    s += "[" + c.getType() + " – " + i + "]: "  + c.name + ", Limit: $" + c.limit + "\n";
                    i++;
                }
            }

            if (c.isSpecial == true) {
                if (c.name != "") {
                    s += "[" + c.getType() + " – " + i + "]: "  + c.name + ", Budget: $" + c.percentage + "\n";
                    i++;
                }
            }
        }
        return s;
    }
}
