package Hw9;

import java.util.Stack;

public class B08_02 {

    public static boolean isCorrect(String line) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            char bracket = line.charAt(i);

            if (bracket == '(' || bracket == '[' || bracket == '{') {stack.push(bracket);}
            else if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (stack.isEmpty()) {return false;}
                char openBracket = stack.pop();
                if (!isMatchingPair(openBracket, bracket)) {return false;}
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String data = "{[((()]]}";

        if (isCorrect(data)) {
            System.out.println("Correct.");
        } else {
        	System.out.println("Incorrect.");
        }
    }
}
