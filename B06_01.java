package Hw7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;

public class B06_01 {
	
	private static String formatDate(LocalDate date) {
        int day = date.getDayOfMonth();
        int month = date.getMonthValue();
        int year = date.getYear();

        String formattedDay = (day < 10 ? "0" : "") + day;
        String formattedMonth = (month < 10 ? "0" : "") + month;

        return formattedDay + "." + formattedMonth + "." + year;
    }

    public static void main(String[] args) {
        String input = "18.10.2024   01.01.2000   __.__.____";

        LocalDate currentDate = LocalDate.now();
        String currentDateString = formatDate(currentDate);

        String datePattern = "(\\d{2}\\.\\d{2}\\.\\d{4}|__\\.__\\.____)";

        Pattern pattern = Pattern.compile(datePattern);
        Matcher matcher = pattern.matcher(input);

        String result = matcher.replaceAll(currentDateString);

        System.out.println("Before: " + input);
        System.out.println("After: " + result);
    }
}
