package Hw8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class B07_01 {

    public static void writeToFile(String filename, double[] numbers) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
        	for (int i = 0; i < numbers.length; i++) {
        	    out.writeDouble(numbers[i]);
        	}
        }
    }

    public static double[] readFromFile(String filename) throws IOException {
        List<Double> numbersList = new ArrayList<>();
        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            while (in.available() > 0) {
                numbersList.add(in.readDouble());
            }
        }

        double[] numbers = new double[numbersList.size()];
        for (int i = 0; i < numbersList.size(); i++) {
            numbers[i] = numbersList.get(i);
        }
        return numbers;
    }

    public static void createFileG(String input, String output, double a) throws IOException {
        double[] numbers = readFromFile(input);
        List<Double> numbersG = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > a) {
                numbersG.add(numbers[i]);
            }
        }

        double[] result = new double[numbersG.size()];
        for (int i = 0; i < numbersG.size(); i++) {
            result[i] = numbersG.get(i);
        }
        writeToFile(output, result);
    }

    public static void main(String[] args) {
        String fileF = "F.bin";
        String fileG = "G.bin";
        double[] numbers = {0.2, 0.5, 0.7, 3.8, 1.0, 5.9, 10.0, 4.0};
        double a = 2.5;

        try {
            writeToFile(fileF, numbers);
            createFileG(fileF, fileG, a);

            double[] numbersFromF = readFromFile(fileF);
            System.out.print("File F: ");
            for (int i = 0; i < numbersFromF.length; i++) {
                System.out.print(numbersFromF[i] + " ");
            }
            System.out.println();
            
            double[] numbersFromG = readFromFile(fileG);
            System.out.print("File G: ");
            for (int i = 0; i < numbersFromG.length; i++) {
                System.out.print(numbersFromG[i] + " ");
            }
            System.out.println();

        } catch (IOException e) {System.out.println("ERROR: " + e.getMessage());}
    }
}
