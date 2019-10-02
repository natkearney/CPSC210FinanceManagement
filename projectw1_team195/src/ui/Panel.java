package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import Category.CategoryEditor;
import Math.Budget;

import static ui.UserInteraction.categoryPrompt;


public class Panel extends JPanel implements ActionListener {

    JButton budgetButton = new JButton("Budget");
    JButton categoryButton = new JButton("Category");
    JButton limitButton = new JButton("Limits");
    JButton quitButton = new JButton("Quit");



    public Panel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

        createButtons();
        JLabel welcomeMessage = new JLabel("<html><font size=+1>Welcome to your budgeting calculator!</font>", SwingConstants.CENTER);
        JLabel welcomeSubMessage = new JLabel("<html><i>What would you like to do?</i>", SwingConstants.CENTER) ;

        JPanel bottomPanel = new JPanel();
        GridLayout buttonLayout = new GridLayout(1, 4);
        bottomPanel.setLayout(buttonLayout);
        bottomPanel.add(budgetButton);
        bottomPanel.add(categoryButton);
        bottomPanel.add(limitButton);
        bottomPanel.add(quitButton);

        GridLayout screenLayout = new GridLayout(3,1);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(screenLayout);
        mainPanel.add(welcomeMessage);
        mainPanel.add(welcomeSubMessage);
        mainPanel.add(bottomPanel);

        add(mainPanel);
    }

    void createButtons() {

        budgetButton.setMnemonic(KeyEvent.VK_C);
        budgetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        budgetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                Budget.budget();
            }});

        categoryButton.setMnemonic(KeyEvent.VK_C);
        categoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        categoryButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                if (CategoryEditor.checkIfListEmpty() == true) {
                    CategoryEditor.categoryCreator();
                }
                categoryPrompt();
            }});

        limitButton.setMnemonic(KeyEvent.VK_C);
        limitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        limitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(FinanceApp.frame, "These are your current limits: \n" +
                        CategoryEditor.printLimit());
            }});

        quitButton.setMnemonic(KeyEvent.VK_C);
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                //do whatever should happen when the button is clicked...
                FinanceApp.end();
            }});

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
