package Hw3;

import java.util.Scanner;

public class B02_17b {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter x (abs(x) < 1): ");
        double x = scan.nextDouble();
        
        System.out.print("Enter epsilon (epsilon > 0): ");
        double eps = scan.nextDouble();

        if ((Math.abs(x) >= 1) | (eps <= 0)) {System.out.println("ERROR!");}
        
        double result = logSum(x, eps);
        System.out.printf("f(x): %.6f%n", result);
        scan.close();
    }

    public static double logSum(double x, double eps) {
        double sum = 0.0;
        double i = x;
        int k = 1;

        while (Math.abs(i) >= eps) {
            sum += i;
            k += 2;
            i = Math.pow(x, k) / k;
        }

        return sum;
    }
}

