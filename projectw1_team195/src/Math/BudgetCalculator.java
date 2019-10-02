package Math;

import java.util.ArrayList;
import Category.Category;
import ui.FinanceApp;

public class BudgetCalculator {

    //REQUIRES: TotalBudget >= 0,  givenPercentage >= 0.
    //EFFECTS: returns max portion of budget allowed to be used
    public static double MaximumQuantity(double givenPercentage) {
        double p = new Double(givenPercentage);
        double percentage = p / 100;
        double maxQ = FinanceApp.budget * percentage;
        return maxQ;
    }
    //REQUIRES: Category theList >= 1
    //MODIFIES: this
    //EFFECTS: User input percentage !> 100.
    //         - If p > 100, return false. Else return true.
    public static boolean PercentageCheck(ArrayList<Category> theList) {
        double p = 0;
        for (Category c : theList) {
            if (c.isSpecial == false) {
                p = p + c.percentage; //change to p+c.percentage
            }
        }
        if (p > 100) {
            return false;
        } else {
            return true;
        }
    }

    public static void updateLimits() {
        double p;
        for (Category c : FinanceApp.ListOfCategories) {
            p = c.percentage/100;
            c.limit = FinanceApp.budget * p;
        }
    }
}