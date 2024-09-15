package Hw2;

import java.util.Scanner;

public class B02_01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Array size: ");
        int n = scan.nextInt();

        double[] array = new double[n];
        System.out.println("Array elements: ");
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextDouble();
        }

        double result = minElement(array);
        System.out.printf("Minimum in array: %.4f%n", result);
        scan.close();
    }

    public static double minElement(double[] array) {
        double min = array[0];
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }
}


