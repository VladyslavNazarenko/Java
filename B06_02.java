package Hw7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B06_02 {
    public static void main(String[] args) {
        String input = "+380 (66) 666-66-66 khfxjfi iuytckk  0671554875 khyfl;lnb 380965551322   067-155-48-75.";
        String phoneNumberPattern = "\\+?\\d{1,3}\\s?\\(?\\d{2,3}\\)?\\s?\\d{3}\\s?-?\\d{2}\\s?-?\\d{2}";

        Pattern pattern = Pattern.compile(phoneNumberPattern);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {System.out.println(matcher.group());}
    }
}
