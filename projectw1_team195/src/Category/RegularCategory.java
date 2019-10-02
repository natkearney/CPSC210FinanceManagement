package Category;


import static ui.FinanceApp.budget;

public class RegularCategory extends Category {
    public RegularCategory(String name) {
        super(name);
        isSpecial = false;
        limit = (percentage/100) * budget;
    }

    protected String getType() {
        return "Regular";
    }



}
