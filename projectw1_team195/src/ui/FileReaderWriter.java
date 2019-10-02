package ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderWriter {

    //this project illustrates reading from a file, and writing to a file
    //before you run this the first time, the outputfile will be empty
    //you can open outputfile to see that the entries have been written there
    //notice also that the default folder for the files is the main project folder
    //  not the src directory, or whichever package this class is in.

    //this project also illustrates splitting a line up by spaces


    public static List<String> load(int i) throws IOException {
        // 1 = Monthly Budget
        // 2 = Category Names
        // 3 = Category Budgets
        List<String> lines;
        if (i == 1) {
            lines = Files.readAllLines(Paths.get("UserdefinedTotalBudget"));
            return lines;
        } else if (i == 2) {
            lines = Files.readAllLines(Paths.get("CategoryNames"));
            return lines;
        } else {
            lines = Files.readAllLines(Paths.get("CategoryBudgets"));
            return lines;
        }
    }

    public static void save(int i, String str) throws IOException {
        // 1 = Monthly Budget
        // 2 = Category Names
        // 3 = Category Budgets
        PrintWriter writer;
        if (i == 1) {
            writer = new PrintWriter("UserdefinedTotalBudget", "UTF-8");
            writer.println(str);
        } else if (i == 2) {
            writer = new PrintWriter("CategoryNames", "UTF-8");
            writer.println(str);
        } else {
            writer = new PrintWriter("CategoryBudgets", "UTF-8");
            writer.println(str);
        }
        writer.close(); //note -- if you miss this, the file will not be written at all.
    }

    //    public static void test() throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));;
//        PrintWriter writer = new PrintWriter("outputfile.txt","UTF-8");
//        lines.add("Trey Coordinator");
//        for (String line : lines){
//            ArrayList<String> partsOfLine = splitOnSpace(line);
//            System.out.print("Name: "+partsOfLine.get(0)+" ");
//            System.out.println("Role: "+partsOfLine.get(1));
//            writer.println(line);
//        }
//        writer.close(); //note -- if you miss this, the file will not be written at all.
//    }
//
//
    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}



