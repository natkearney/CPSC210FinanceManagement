package test;

import Category.Category;
//import Category.Limits;
import Category.RegularCategory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testLoadSave {

    @Test
    public void testLoadandSave() {
        Category c = new RegularCategory("Bob");
        List<String> name = null;
        try {
            c.save("Bob");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            name = c.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("Bob", name.get(0));

    }

    @Test
    public void testXXXXXX() {
        // template for unit tests
    }
}
