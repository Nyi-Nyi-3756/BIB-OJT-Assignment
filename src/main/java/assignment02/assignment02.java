package main.java.assignment02;

public class assignment02 {
    public static void main(String[] args) {
        int k = 7; //assign k value

        for (int i = 1; i <= k; i++) {

            for (int n = 1; n < i; n++) {
                System.out.print(" ");
            }

            for (int j = i; j <= k; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        } // upper loop


        for (int i = k - 1; i >= 1; i--) {

            for (int n = 1; n < i; n++) {
                System.out.print(" ");
            }

            for (int j = i; j <= k; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        } // lower loop
    }
}
