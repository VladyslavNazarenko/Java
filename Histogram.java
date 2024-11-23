// Назаренко Владислав, комп'ютерна механіка

package CourseProject;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Histogram {
    private double minHist;     // Мінімальне значення гістограми
    private double maxHist;     // Максимальне значення гістограми
    private int m;              // Кількість стовпців гістограми
    private int[] frequency;    // Масив частот для кожного інтервалу

    // Конструктор структури
    public Histogram(double minHist, double maxHist, int m) {
        this.minHist = minHist;
        this.maxHist = maxHist;
        this.m = m;
        this.frequency = new int[m];
    }

    // Гетери для мінімуму, максимуму, кількості інтервалів та частот
    public double getMinHist() {return minHist;}
    public double getMaxHist() {return maxHist;}
    public int getM() {return m;}
    public int[] getFrequency() {return frequency;}

    // Додавання значення в гістограму
    public void addValue(double value) {
        if (value < minHist || value >= maxHist) {return;}
        
        // Індекс інтервалу, до якого відноситься значення
        int index = (int) ((value - minHist) / (maxHist - minHist) * m);

        // Якщо значення дорівнює максимальному, віднести його до останнього інтервалу
        if (index == m) {index = m - 1;}
        frequency[index]++; // Збільшуємо частоту
    }

    public void clear() {Arrays.fill(frequency, 0);} // Скидаємо частоти

    // Обчислення інтервалів
    public List<String> getIntervals() {
        List<String> intervals = new ArrayList<>();
        double intervalWidth = (maxHist - minHist) / m;

        for (int i = 0; i < m; i++) {
            double start = minHist + i * intervalWidth;
            double end = start + intervalWidth;
            intervals.add("[" + start + ", " + end + ")");
        }
        return intervals;
    }

    // Отримання загальної інформації про гістограму
    public String getHistogramInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Інтервали гістограми та їх частоти:\n");

        List<String> intervals = getIntervals();
        for (int i = 0; i < m; i++) {
            sb.append(intervals.get(i)).append(": ").append(frequency[i]).append("\n");
        }
        return sb.toString();
    }

    // Виведення інформації про гістограму в консоль
    public void printHistogram() {System.out.println(getHistogramInfo());}

    // Встановлення нових параметрів гістограми
    public void setParameters(double minHist, double maxHist, int m) {
        this.minHist = minHist;
        this.maxHist = maxHist;
        this.m = m;
        this.frequency = new int[m]; // Очищення частот при зміні параметрів
    }
}
