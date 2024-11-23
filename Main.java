// Назаренко Владислав, комп'ютерна механіка

package CourseProject;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Histogram histogram = null;
        HistogramAnalysis analysis = null;

        System.out.println("Виберіть спосіб введення даних:");
        System.out.println("1 - Ввести з консолі");
        System.out.println("2 - Ввести з текстового файлу");

        int inputChoice = scanner.nextInt();
        scanner.nextLine(); // Очистка після введення числа

        if (inputChoice == 1) {
            histogram = inputFromConsole(scanner); // Введення з консолі
            analysis = new HistogramAnalysis(histogram);
            outputToConsole(histogram, analysis);  // Виведення на консоль
            
        } else if (inputChoice == 2) {
            histogram = inputFromFile(); // Введення даних з файлу
            
            if (histogram != null) {
            	analysis = new HistogramAnalysis(histogram);
                outputToFile(histogram, analysis); // Запис результатів у файл
            } else {
                System.out.println("Помилка при читанні файлу. Завершення програми.");
            }
        } else {System.out.println("Некоректний вибір. Завершення програми.");}

        scanner.close();
    }

    // Введення даних з консолі
    private static Histogram inputFromConsole(Scanner scanner) {
        System.out.println("Введіть мінімальне значення гістограми:");
        double minHist = scanner.nextDouble();
        System.out.println("Введіть максимальне значення гістограми:");
        double maxHist = scanner.nextDouble();
        System.out.println("Введіть кількість інтервалів гістограми:");
        int m = scanner.nextInt();

        Histogram histogram = new Histogram(minHist, maxHist, m);

        System.out.println("Введіть елементи (завершити введення - 'OK')");
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("OK")) {break;}
            
            try {
                double value = Double.parseDouble(input);
                histogram.addValue(value);
            } catch (NumberFormatException e) {
                System.out.println("Невірне значення, спробуйте ще раз.");
            }
        }
        return histogram;
    }

    // Введення даних з текстового файлу
    private static Histogram inputFromFile() {
        String filePath = "src\\resources\\Test.txt";
        Histogram histogram = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            double minHist = 0.0;
            double maxHist = 0.0;
            int m = 0;
            boolean parametersSet = false;

            while ((line = reader.readLine()) != null) {
                if (!parametersSet) {
                    // Регулярний вираз для пошуку параметрів гістограми
                    Pattern pattern = Pattern.compile("min\\s*=\\s*(-?\\d+(\\.\\d+)?)\\s*,\\s*max\\s*=\\s*(-?\\d+(\\.\\d+)?)\\s*,\\s*m\\s*=\\s*(\\d+)");
                    Matcher matcher = pattern.matcher(line);

                    if (matcher.find()) {
                        minHist = Double.parseDouble(matcher.group(1));
                        maxHist = Double.parseDouble(matcher.group(3));
                        m = Integer.parseInt(matcher.group(5));
                        histogram = new Histogram(minHist, maxHist, m);
                        parametersSet = true;
                    }
                } else {
                    // Регулярний вираз для числових значень у другому рядку файлу
                    Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
                    Matcher matcher = pattern.matcher(line);

                    while (matcher.find()) {
                        double value = Double.parseDouble(matcher.group());
                        histogram.addValue(value);
                    }
                }
            }
        } catch (IOException e) {System.out.println("Помилка при читанні файлу: " + e.getMessage());}

        return histogram;
    }

    // Виведення результатів на консоль
    private static void outputToConsole(Histogram histogram, HistogramAnalysis analysis) {
        System.out.println(histogram.getHistogramInfo());

        // Виведення результатів аналізу
        System.out.println("Аналіз гістограми:");
        System.out.println("Розмах: " + analysis.range());
        System.out.println("Кількість елементів: " + analysis.num());
        System.out.println("Середнє значення: " + analysis.mean());
        System.out.println("Мода: " + analysis.mode());
        System.out.println("Медіана: " + analysis.median());
        System.out.println("Математичне сподівання: " + analysis.expectedValue());
        System.out.println("Дисперсія: " + analysis.variance());
        System.out.println("Середнє відхилення: " + analysis.dev());
        System.out.println("Виправлена дисперсія: " + analysis.correctedVariance());
        System.out.println("Виправлене середнє квадратичне відхилення: " + analysis.correctedStandardDeviation());
        System.out.println("Коефіцієнт асиметрії: " + analysis.skewness());
        System.out.println("Ексцес: " + analysis.kurtosis());
    }

    // Запис результатів у файл
    private static void outputToFile(Histogram histogram, HistogramAnalysis analysis) {
        String outputPath = "src\\resources\\Result.txt";

        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(histogram.getHistogramInfo());
            writer.write("Аналіз гістограми:\n");
            writer.write("Розмах: " + analysis.range() + "\n");
            writer.write("Кількість елементів: " + analysis.num() + "\n");
            writer.write("Середнє значення: " + analysis.mean() + "\n");
            writer.write("Мода: " + analysis.mode() + "\n");
            writer.write("Медіана: " + analysis.median() + "\n");
            writer.write("Математичне сподівання: " + analysis.expectedValue() + "\n");
            writer.write("Дисперсія: " + analysis.variance() + "\n");
            writer.write("Середнє відхилення: " + analysis.dev() + "\n");
            writer.write("Виправлена дисперсія: " + analysis.correctedVariance() + "\n");
            writer.write("Виправлене середнє квадратичне відхилення: " + analysis.correctedStandardDeviation() + "\n");
            writer.write("Коефіцієнт асиметрії: " + analysis.skewness() + "\n");
            writer.write("Ексцес: " + analysis.kurtosis() + "\n");
        } catch (IOException e) {
            System.out.println("Помилка при записі файлу: " + e.getMessage());
        }
    }
}
