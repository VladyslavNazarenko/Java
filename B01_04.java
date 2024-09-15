package Hw2;

import java.util.Scanner;

public class B01_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int a = scan.nextInt();
        System.out.print("Enter the second number: ");
        int b = scan.nextInt();
        System.out.print("Enter the third number: ");
        int c = scan.nextInt();

        double result = Math.cbrt(a * b * c);
        System.out.printf("Result: %.4f", result);
        scan.close();
    }
}

