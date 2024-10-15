package Hw6;

public class B05_01 {
    
    public static boolean correctBrackets(String input) {
        int openBrackets = 0;
        int closeBrackets = 0;
        
        for (char c : input.toCharArray()) {
            if (c == '(') {
                openBrackets++;
            } else if (c == ')') {
                closeBrackets++;
                if (closeBrackets > openBrackets) {
                    return false;
                }
            }
        }
        return openBrackets == closeBrackets;
    }
    
    public static String removeBracketsContent(String input) {
    	if (correctBrackets(input) == false) {
    	    return "Incorrect brackets!";
    	}
        
        StringBuilder result = new StringBuilder();
        boolean insideBrackets = false;
        
        for (char c : input.toCharArray()) {
            if (c == '(') {
                insideBrackets = true;
            } else if (c == ')') {
                insideBrackets = false;
            } else if (insideBrackets == false) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hello, (Bob)! How (are) you?";
        String result = removeBracketsContent(input);   
        System.out.println(result);
    }
}


