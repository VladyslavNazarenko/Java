package Hw6;

import java.io.*;
import java.util.*;

class Line {
    double x1, y1, x2, y2;
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public double length() {return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));}
}

class Rectangle {
    double x1, y1, x2, y2;
    public Rectangle(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public double perimeter() {return 2 * (Math.abs(x2 - x1) + Math.abs(y2 - y1));}
}

class Circle {
    double x, y, r;
    public Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public double area() {return Math.PI * Math.pow(r, 2);}
}

public class B05_03 {

    public static void main(String[] args) {

        createShapesFile("B05_03__figures.txt");

        List<Line> lines = new ArrayList<>();
        List<Rectangle> rectangles = new ArrayList<>();
        List<Circle> circles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("B05_03__figures.txt"))) {
            String dataline;
            
            while ((dataline = br.readLine()) != null) {

                String[] elements = dataline.split(" ");
                List<String> notEmpty = new ArrayList<>();
                
                for (String i : elements) {
                    if (!i.isEmpty()) {notEmpty.add(i);}
                }
                int number = Integer.parseInt(notEmpty.get(0));

                if (number == 1) {
                    double lx1 = Double.parseDouble(notEmpty.get(1));
                    double ly1 = Double.parseDouble(notEmpty.get(2));
                    double lx2 = Double.parseDouble(notEmpty.get(3));
                    double ly2 = Double.parseDouble(notEmpty.get(4));
                    lines.add(new Line(lx1, ly1, lx2, ly2));
                } else if (number == 2) {
                    double rx1 = Double.parseDouble(notEmpty.get(1));
                    double ry1 = Double.parseDouble(notEmpty.get(2));
                    double rx2 = Double.parseDouble(notEmpty.get(3));
                    double ry2 = Double.parseDouble(notEmpty.get(4));
                    rectangles.add(new Rectangle(rx1, ry1, rx2, ry2));
                } else if (number == 3) {
                    double cx = Double.parseDouble(notEmpty.get(1));
                    double cy = Double.parseDouble(notEmpty.get(2));
                    double cr = Double.parseDouble(notEmpty.get(3));
                    circles.add(new Circle(cx, cy, cr));
                } else {
                    System.out.println("Unknown figure.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading.");
        }

        Line longestLine = lines.stream().max(Comparator.comparing(Line::length)).orElse(null);
        String lineResult = longestLine != null ? "Longest line length: " + longestLine.length() : "No lines found.";

        Rectangle biggestRectangle = rectangles.stream().max(Comparator.comparing(Rectangle::perimeter)).orElse(null);
        String rectangleResult = biggestRectangle != null ? "Biggest rectangle perimeter: " + biggestRectangle.perimeter() : "No rectangles found.";

        Circle smallestCircle = circles.stream().min(Comparator.comparing(Circle::area)).orElse(null);
        String circleResult = smallestCircle != null ? "Smallest circle area: " + smallestCircle.area() : "No circles found.";

        try (PrintWriter writer = new PrintWriter(new FileWriter("B05_03__results.txt"))) {
            writer.println(lineResult);
            writer.println(rectangleResult);
            writer.println(circleResult);
        } catch (IOException e) {
            System.out.println("Error writing.");
        }
    }

    private static void createShapesFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("1 0 0 4 0");
            writer.println("1 0 0 5 0");
            writer.println("2 0 4 4 0");
            writer.println("2 0 5 5 0");
            writer.println("3 5 4 10");
            writer.println("3 0 0 1");
        } catch (IOException e) {
            System.out.println("Error creating.");
        }
    }
}




