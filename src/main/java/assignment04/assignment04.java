package main.java.assignment04;
import java.util.ArrayList;
import java.util.Scanner;

public class assignment04 {

    // Split full name into words and store in ArrayList
    public static ArrayList<String> splitName(String fullName) {
        ArrayList<String> userName = new ArrayList<>();
        for (String word : fullName.split(" ")) {
            userName.add(word);
        }
        return userName;
    }

    // Store reversed name in a new ArrayList and return it
    public static ArrayList<String> storeReverse(ArrayList<String> userName) {
        ArrayList<String> reversedName = new ArrayList<>();
        for (int i = userName.size() - 1; i >= 0; i--) {
            reversedName.add(userName.get(i));
        }
        return reversedName;
    }

    // Print name in reverse immediately
    public static void printReverse(ArrayList<String> userName) {
        System.out.print("Your reversed name is: ");
        for (int i = userName.size() - 1; i >= 0; i--) {
            System.out.print(userName.get(i) + " ");
        }
        System.out.println();
    }

    // Print stored reverse data as converse
    public static void printConverse(ArrayList<String> reversedName) {
        System.out.print("Your converse name is: ");
        for (int i = reversedName.size() - 1; i >= 0; i--) {
            System.out.print(reversedName.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Please enter your name: ");
        String fullName = sc.nextLine();

        // Store in ArrayList
        ArrayList<String> userName = splitName(fullName);

        // Output - print reverse immediately
        printReverse(userName);

        // Store reversed data in method
        ArrayList<String> reversedName = storeReverse(userName);

        // Print reverse data from method as converse
        printConverse(reversedName);

        sc.close();
    }
}
