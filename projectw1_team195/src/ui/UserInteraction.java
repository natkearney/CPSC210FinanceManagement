package ui;

import java.io.IOException;
import java.util.Scanner;

import Category.CategoryEditor;
import Category.RegularCategory;
import Category.SpecialCategoryEditor;
import Exceptions.NumberException;
import Observer.BudgetObserver;
import Observer.Subject;
import Math.Budget;
import Transaction.Transaction;

import javax.swing.*;


public class UserInteraction extends Subject {

    public static void WhatToDo() {
        FinanceApp.createAndShowGUI();
        }


    public static void categoryPrompt(){
        String amount = JOptionPane.showInputDialog(FinanceApp.frame, "These are your current categories: \n" + CategoryEditor.PrintCategories() +
                "\n What would you like to do? \n [1] Edit Categories\n [2] Return to Main Menu", null);
        int answer = Integer.valueOf(amount);
        if (answer == 1) {
            answer = Integer.valueOf(TextPrompts.CategoryMenu());
            if (answer == 1) {
                CategoryEditor.nameFix();
            } else if (answer == 2) {
                CategoryEditor.percentageFix();
            } else if (answer == 3) {
                CategoryEditor.addCategoryCheck();
                int yesOrNo = JOptionPane.showConfirmDialog(FinanceApp.frame, "Would you like to add another category?", "Add Category?", JOptionPane.YES_OPTION);
                if (yesOrNo == 0) {
                    CategoryEditor.addCategoryCheck();
                }
            } else if (answer == 4) {
                SpecialCategoryEditor.addCategoryCheck();
                int yesOrNo = JOptionPane.showConfirmDialog(FinanceApp.frame, "Would you like to add another special category?", "Add Category?", JOptionPane.YES_OPTION);
                if (yesOrNo == 0) {
                    SpecialCategoryEditor.addCategoryCheck();
                }
            } else if (answer == 5) {
                CategoryEditor.removeCategory();
            } else if (answer == 6) {
                CategoryEditor.isEqual(FinanceApp.c1, FinanceApp.c2);
            }

        }
    }
}
