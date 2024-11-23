// Назаренко Владислав, комп'ютерна механіка

package CourseProject;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class HistogramAnalysis {
    private Histogram histogram;

    // Конструктор для аналізу гістограми
    public HistogramAnalysis(Histogram histogram) {this.histogram = histogram;}

    // Розмах
    public double range() {return histogram.getMaxHist() - histogram.getMinHist();}

    // Кількість елементів в гістограмі
    public int num() {
        int total = 0;
        for (int count : histogram.getFrequency()) {
            total += count;
        }
        return total;
    }
    
    // Середнє значення
    public double mean() {
        int totalNum = num();  // Загальна кількість елементів
        if (totalNum == 0) return 0.0;
        double sum = 0.0;

        for (int i = 0; i < histogram.getM(); i++) {
            for (int j = 0; j < histogram.getFrequency()[i]; j++) {
                double value = histogram.getMinHist() + i * (histogram.getMaxHist() - histogram.getMinHist()) / histogram.getM();
                sum += value;
            }
        }
        return sum / totalNum;
    }

    // Мода
    public List<Double> mode() {
        int maxFrequency = Arrays.stream(histogram.getFrequency()).max().orElse(0);
        List<Double> modes = new ArrayList<>();

        if (maxFrequency == 0) return modes; // Якщо частота всюди 0, то мода відсутня

        double min = histogram.getMinHist();
        double interval = (histogram.getMaxHist() - min) / histogram.getM();

        for (int i = 0; i < histogram.getM(); i++) {
            if (histogram.getFrequency()[i] == maxFrequency) {
                double midpoint = min + (i + 0.5) * interval;
                modes.add(midpoint);
            }
        }
        return modes;
    }

    // Медіана
    public double median() {
        int totalNum = num();
        if (totalNum == 0) return 0.0;

        int[] cumulativeFrequency = new int[histogram.getM()];
        cumulativeFrequency[0] = histogram.getFrequency()[0];

        for (int i = 1; i < histogram.getM(); i++) {
            cumulativeFrequency[i] = cumulativeFrequency[i - 1] + histogram.getFrequency()[i];
        }

        int medianPosition = (totalNum + 1) / 2;
        double min = histogram.getMinHist();
        double interval = (histogram.getMaxHist() - min) / histogram.getM();

        for (int i = 0; i < histogram.getM(); i++) {
            if (cumulativeFrequency[i] >= medianPosition) {
                return min + (i + 0.5) * interval;
            }
        }
        return 0.0;
    }

    // Математичне сподівання
    public double expectedValue() {return mean();}

    // Дисперсія
    public double variance() {
        int totalNum = num();
        if (totalNum == 0) return 0.0;

        double meanValue = mean();
        double sum = 0.0;
        double min = histogram.getMinHist();
        double interval = (histogram.getMaxHist() - min) / histogram.getM();

        for (int i = 0; i < histogram.getM(); i++) {
            double midpoint = min + (i + 0.5) * interval;
            sum += Math.pow(midpoint - meanValue, 2) * histogram.getFrequency()[i];
        }
        return sum / totalNum;
    }

    // Середнє відхилення
    public double dev() {return Math.sqrt(variance());}

    // Виправлена дисперсія
    public double correctedVariance() {
        int totalNum = num();
        if (totalNum <= 1) return 0.0;

        return variance() * totalNum / (totalNum - 1);
    }

    // Виправлене середнє відхилення
    public double correctedStandardDeviation() {return Math.sqrt(correctedVariance());}

    // Коефіцієнт асиметрії
    public double skewness() {
        int totalNum = num();
        if (totalNum == 0) return 0.0;

        double meanValue = mean();
        double sum = 0.0;
        double min = histogram.getMinHist();
        double interval = (histogram.getMaxHist() - min) / histogram.getM();
        double stdDev = dev();

        for (int i = 0; i < histogram.getM(); i++) {
            double midpoint = min + (i + 0.5) * interval;
            sum += Math.pow((midpoint - meanValue) / stdDev, 3) * histogram.getFrequency()[i];
        }
        return sum / totalNum;
    }

    // Ексцес
    public double kurtosis() {
        int totalNum = num();
        if (totalNum == 0) return 0.0;

        double meanValue = mean();
        double sum = 0.0;
        double min = histogram.getMinHist();
        double interval = (histogram.getMaxHist() - min) / histogram.getM();
        double stdDev = dev();

        for (int i = 0; i < histogram.getM(); i++) {
            double midpoint = min + (i + 0.5) * interval;
            sum += Math.pow((midpoint - meanValue) / stdDev, 4) * histogram.getFrequency()[i];
        }

        return (sum / totalNum) - 3; // Віднімаємо 3 і отримуємо надлишковий ексцес
    }
}
