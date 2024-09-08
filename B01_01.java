package Hw1;

import java.util.Scanner;

public class B01_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введіть ім'я: ");
        String name = scan.nextLine();
        System.out.println("Привіт, " + name);
        scan.close();
    }
}

