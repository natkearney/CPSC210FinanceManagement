package Category;

import ui.FinanceApp;

public class SpecialCategoryEditor extends CategoryEditor {

    public static void addCategoryCheck(){
        if (FinanceApp.s1.checkIfEmpty() == true){
            FinanceApp.s1.addCategory();
        }
        else if (FinanceApp.s2.checkIfEmpty() == true){
            FinanceApp.s2.addCategory();
        }
        else if (FinanceApp.s3.checkIfEmpty() == true){
            FinanceApp.s3.addCategory();
        }
        else {System.out.println("All special category slots taken. Please delete category before adding a new one.");}
    }
}
