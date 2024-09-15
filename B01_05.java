package Hw2;

import java.util.Scanner;

public class B01_05 {
    public static void main(String[] args) {
        int N, M;

        if (args.length == 2) {
            try {
                N = Integer.parseInt(args[0]);
                M = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.err.println("Bad argument!");
                return;
            }
        } else {
            Scanner scan = new Scanner(System.in);
            System.out.print("N = ");
            N = scan.nextInt();
            System.out.print("M = ");
            M = scan.nextInt();
            scan.close();
        }

        if (N <= 0 || M <= 0) {
            System.err.println("Bad argument!");
            return;
        }

        for (int i = 0; i < N; i++) {
            int result = (int) (Math.random() * M);
            System.out.println(result);
        }
    }
}
