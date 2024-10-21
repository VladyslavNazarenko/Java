package Hw7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_03 {
    private static final String mathPattern = "\\s*[+-]?\\s*\\d+\\s*(\\s*[*/+-]\\s*[+-]?\\s*\\d+\\s*)*";

    public static boolean isValidExpression(String expression) {
        Pattern pattern = Pattern.compile(mathPattern);
        Matcher matcher = pattern.matcher(expression);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] data = {
            "+2 -    57*33   + 25/ -  4",
            "1 + 1",
            "2 **/ 6",
            "7 / -10 + 1",
            "1 + 2 3"
        };

        for (String expression : data) {
            System.out.println(expression + " is " + (isValidExpression(expression) ? "correct" : "incorrect"));
        }
    }
}
