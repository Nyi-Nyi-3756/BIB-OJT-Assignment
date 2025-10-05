package main.java.assignment03;
import java.util.Scanner;

public class assignment03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Get number from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Check positive, negative or zero
        if (number > 0) {
            System.out.println(number + " is Positive.");
        } else if (number < 0) {
            System.out.println(number + " is Negative.");
        } else {
            System.out.println("The number is Zero.");
        }

        sc.close();
    }
}
