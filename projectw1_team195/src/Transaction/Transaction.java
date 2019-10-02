package Transaction;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Transaction {
    public static Map<String, String> transaction = new HashMap<>();

    public static void createTransaction() {
        Double answer;
        String name;
        Scanner reader = new Scanner(System.in);
        System.out.println("Transaction name:");
        name = reader.next();
        System.out.println("Amount Spent:");
        answer = reader.nextDouble();
        recordTransaction(name, answer);

    }

    public static void recordTransaction(String name, double amount){

        transaction.put(name, Double.toString(amount));

    }

    public static void searchTransactions(){
        //STUB: Have it search for transaction
        String name;
        Scanner reader = new Scanner(System.in);

        System.out.println("Search – Name of transaction:");
        name = reader.next();
        fetchTransaction(name);

    }

    public static String fetchTransaction(String name){
        String amount = transaction.get(name);
        return amount;
    }


}
