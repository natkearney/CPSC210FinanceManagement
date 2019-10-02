package Category;

import ui.FinanceApp;


import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class SpecialCategory extends Category {
    public SpecialCategory(String name) {
        super(name);
        isSpecial = true;
    }

    public List<String> load() throws IOException {
        List<String> names = Files.readAllLines(Paths.get("SpecialCategoryNames"));
        return names;
    }

    public void save(String str) throws IOException {
        PrintWriter writer = new PrintWriter("SpecialCategoryNames", "UTF-8");
        writer.println(str);
        writer.close();
    }

    @Override
    public void addCategory() {
        String answerString;
        int answer;
        answerString = JOptionPane.showInputDialog(FinanceApp.frame,
                "Insert Special Category Name:", null);
        name = answerString;
        answer = Integer.valueOf(JOptionPane.showInputDialog(FinanceApp.frame,
                "Category " + answerString + " created. Assign Budget:", null));
        System.out.println(" ");
        changePercentage(answer);
    }

    protected String getType() {
        return "Special";
    }

}
