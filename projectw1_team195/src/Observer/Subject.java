package Observer;

import java.util.ArrayList;
import java.util.List;
import Math.Budget;

public class Subject {
    private static List<BudgetObserver> observers = new ArrayList<>();

    public static void addObserver(BudgetObserver budgetObserver){
        if (!observers.contains(budgetObserver)){
            observers.add(budgetObserver);
        }
    }

    public static void notifyObserver(){

    }

}
