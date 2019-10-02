package Category;
import Math.BudgetCalculator;
import ui.FinanceApp;
import ui.TextPrompts;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;


public abstract class Category implements Loadable, Saveable {
    public double percentage;
    public String name;
    public double limit;
    public boolean isSpecial;

    //REQUIRES: Any String
    //MODIFIES: name & percentage
    //EFFECTS: Defines new Category, assigning it name and an initial percentage
    public Category (String name) {
        this.name = name;
        percentage = 0;
    }

    protected abstract String getType();

    //REQUIRES: 100 >= int percentage >= 0
    //MODIFIES: percentage
    //EFFECTS: Assigns new percentage to Category
    public void changePercentage(int percentage) {

        this.percentage = new Double(percentage);
    }
    //REQUIRES: Any String
    //MODIFIES: name
    //EFFECTS: Assigning new name to Category
    public void changeName(String name){
        this.name = name;
    }


    public List<String> load() throws IOException {
        List<String> names = Files.readAllLines(Paths.get("CategoryNames"));
        return names;
    }

    public void save(String str) throws IOException {
        PrintWriter writer = new PrintWriter("CategoryNames", "UTF-8");
        writer.println(str);
        writer.close();
    }

    public void addCategory() {
        String answerString;
        int answer;
        answerString = JOptionPane.showInputDialog(FinanceApp.frame,
                "Insert Category Name:", null);
        name = answerString;
        TextPrompts.CategoryNameCreated(name);
        answer = Integer.valueOf(JOptionPane.showInputDialog(FinanceApp.frame,
                "Category " + answerString + " created. Assign percentage:", null));
        boolean percentageOK = BudgetCalculator.PercentageCheck(FinanceApp.ListOfCategories);
        if (percentageOK == true) {
            JOptionPane.showMessageDialog(FinanceApp.frame, "Category Created.");
            TextPrompts.CategoryCreated(answerString, answer);
            System.out.println(" ");
        } else {
            JOptionPane.showMessageDialog(FinanceApp.frame, "Assigned percentages over 100%. Please Re-assign.");
            //TextPrompts.over100();
            CategoryEditor.percentageFix();
        }
        changePercentage(answer);

        CategoryEditor.check();


    }


    public boolean checkIfEmpty(){
        if (name != "") {return false;}
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

