package test;

import Exceptions.NumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import Category.Category;
//import Category.Limits;
import ui.TextPrompts;
import Category.RegularCategory;

import java.util.Scanner;


public class CategoryTest {
    @Test
    public void testCreate() {
        Category c = new RegularCategory("Bob");
        assertEquals(c.percentage, 0);
        assertEquals(c.name, "Bob");
    }

    /*@Test public void percentageExcTest(){
        try {
            TextPrompts.mainMenu();
            reader = 1;
            //anObject.aMethod(nonExceptionalInputs);
        } catch (Exception e) {
            fail("I was not expecting SomeException!");
        }
    }

    @Test
    public void percentageExcTestThrown(){
        try {
            TextPrompts.mainMenu();
            //anObject.aMethod(problematicInputs);
            fail("I was not expecting to reach this line of code!");
        } catch (Exception e) {
            System.out.println("great!");
        }
    }*/

    @Test
    public void NumberExceptionNotThrown(){
        Scanner reader = new Scanner(System.in);
        int answer = 0;
        try {
            answer = NumberException.readerTry(reader);
        }
        catch(Exception e) {
            answer = NumberException.notInteger(reader);
        }
    }
}
