package Hw2;

import java.util.Scanner;

public class B02_13 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a two-byte number: ");
        short number = scan.nextShort();

        int first = firstSignificantBit(number);
        int last = lastSignificantBit(number);

        if (first == -1 || last == -1) {
            System.out.println("No significant bits.");
        } else {
            System.out.println("Number of the first significant bit: " + first);
            System.out.println("Number of the last significant bit: " + last);
        }

        scan.close();
    }

    public static int firstSignificantBit(short number) {
        for (int i = 15; i >= 0; i--) { // Перебір від старшого біта до молодшого
            if ((number & (1 << i)) != 0) {
                return i;               // Перший значущий біт
            }
        }
        return -1;
    }

    public static int lastSignificantBit(short number) {
        for (int i = 0; i <= 15; i++) { // Перебір від молодшого біта до старшого
            if ((number & (1 << i)) != 0) {
                return i;               // Останній значущий біт
            }
        }
        return -1;
    }
}

