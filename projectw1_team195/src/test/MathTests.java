package test;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import Math.BudgetCalculator;
import Category.Category;
import Category.RegularCategory;
//import Category.Limits;

public class MathTests {
    Category c1 = new RegularCategory("A");
    Category c2 = new RegularCategory("B");
    Category c3 = new RegularCategory("C");
    Category c4 = new RegularCategory("D");
    Category c5 = new RegularCategory("E");
    ArrayList<Category> ListOfCategories = new ArrayList<>();

    @BeforeEach
    public void runBefore() {
        c1.percentage = 20;
        c2.percentage = 20;
        c3.percentage = 20;
        c4.percentage = 20;
        c5.percentage = 20;
        ListOfCategories.add(c1);
        ListOfCategories.add(c2);
        ListOfCategories.add(c3);
        ListOfCategories.add(c4);
        ListOfCategories.add(c5);
    }

   /* @Test
    public void testMaxQ() {
        int maxBudget = 1000;
        assertEquals (BudgetCalculator.MaximumQuantity(maxBudget, c1.percentage), 200);

        maxBudget = 1232;
        assertEquals (BudgetCalculator.MaximumQuantity(maxBudget, c1.percentage), 246.4);

        c1.percentage = 23.5;
        assertEquals (BudgetCalculator.MaximumQuantity(maxBudget, c1.percentage), 289.52);

        maxBudget = 0;
        c1.percentage = 0;
        assertEquals (BudgetCalculator.MaximumQuantity(maxBudget, c1.percentage), 0);
    }*/

    @Test
    public void testPercentageCheck() {
        assertTrue(BudgetCalculator.PercentageCheck(ListOfCategories));

        c1.percentage = 30;
        assertFalse(BudgetCalculator.PercentageCheck(ListOfCategories));
    }

    @Test
    public void testXXXXXX() {
        // template for unit tests
    }
}
