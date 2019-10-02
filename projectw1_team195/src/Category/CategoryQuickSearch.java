package Category;

import java.util.HashMap;
import java.util.Map;
import Math.BudgetCalculator;

public class CategoryQuickSearch {

    public static Map<Category, String> categoryValue = new HashMap<>();
    public static void addCategory (Category category){
        if (!categoryValue.containsKey(category)){
        categoryValue.put(category, new String());
        }
    }

    public static void addLimit (Category category){
        String budget = categoryValue.get(category);
        double amount = BudgetCalculator.MaximumQuantity(category.percentage);
        budget = "$" + Double.toString(amount);
    }


}
