package Hw1;

public class B01_03 {

    public static void main(String[] args) {
        double d = 1.0;

        for (int j = 0; j < args.length; j++) {
            System.out.println(args[j]);
            try {
                d *= Double.parseDouble(args[j]);
            } catch (NumberFormatException e) {
                System.err.println("Bad argument!");
                return;
            }
        }
        System.out.printf("Добуток: %.4f", d);
    }
}
