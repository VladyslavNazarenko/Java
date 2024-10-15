package Hw6;

public class B05_02 {

    public static boolean a(String input) {
        if (input.length() < 2 || !Character.isDigit(input.charAt(0)) || input.charAt(0) == '0') {
        	return false;
        	}
        
        int digValue = Character.getNumericValue(input.charAt(0));
        String letterPart = input.substring(1);

        if (letterPart.length() != digValue) {return false;}

        for (char c : letterPart.toCharArray()) {
            if (!Character.isLetter(c)) {return false;}
        }

        return true;
    }

    public static boolean b(String input) {
        int count = 0;
        int digValue = 0;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
                digValue = Character.getNumericValue(c);
            }
        }

        return count == 1 && digValue == input.length();
    }

    public static boolean c(String input) {
        int digSum = 0;

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {digSum += Character.getNumericValue(c);}
        }

        return digSum == input.length();
    }

    public static void main(String[] args) {
        String input = "9 morning";

        boolean resultA = a(input);
        boolean resultB = b(input);
        boolean resultC = c(input);

        System.out.println("a: " + (resultA ? "YES" : "NO"));
        System.out.println("b: " + (resultB ? "YES" : "NO"));
        System.out.println("c: " + (resultC ? "YES" : "NO"));
    }
}

