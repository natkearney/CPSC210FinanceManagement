package ui;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Category.Category;
import Category.RegularCategory;

import Category.SpecialCategory;

import javax.swing.*;

public class FinanceApp {
public static int budget;

public static ArrayList<Category> ListOfCategories = new ArrayList<>();
public static RegularCategory c1 = new RegularCategory("");
public static RegularCategory c2 = new RegularCategory("");
public static RegularCategory c3 = new RegularCategory("");
public static RegularCategory c4 = new RegularCategory("");
public static RegularCategory c5 = new RegularCategory("");
public static Category s1 = new SpecialCategory("");
public static Category s2 = new SpecialCategory("");
public static Category s3 = new SpecialCategory("");
public static JFrame frame = new JFrame("Budget Calculator");

    public static void main(String[] args) throws IOException {
        ReadWebPageEx.ReadWebPageEx();
        loadData();
        createCategoryList();
        createAndShowGUI();
        UserInteraction.WhatToDo();
    }

    public static void end(){
        System.exit(0);
    }

    public static void loadData() throws IOException {
        List<String> list = FileReaderWriter.load(1);
        List<String> categoryNames = FileReaderWriter.load(2);
        List<String> categoryLimitList = FileReaderWriter.load(3);
        budget = Integer.parseInt(list.get(0));
        for (Category c: ListOfCategories) {
            int i=0;
            c.name = categoryNames.get(i);
            c.percentage = Integer.parseInt(categoryLimitList.get(i));
            i++;
        }
    }

    public static void createAndShowGUI() {
        //Create and set up the window.

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Panel());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    public static void createCategoryList(){
        ListOfCategories.add(s1);
        ListOfCategories.add(s2);
        ListOfCategories.add(s3);
        ListOfCategories.add(c1);
        ListOfCategories.add(c2);
        ListOfCategories.add(c3);
        ListOfCategories.add(c4);
        ListOfCategories.add(c5);

    }


}
