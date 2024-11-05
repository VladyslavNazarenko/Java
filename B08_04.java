package Hw9;

import java.util.PriorityQueue;
import java.util.Comparator;

public class B08_04 {

    static class Point {
        double x;
        double y;

        Point(double x, double y) {this.x = x; this.y = y;}

        double distance() {return Math.sqrt(x*x + y*y);}

        @Override
        public String toString() {return "(" + x + "; " + y + ")";}
    }

    public static void main(String[] args) {
        PriorityQueue<Point> point = new PriorityQueue<>(Comparator.comparingDouble(Point::distance));

        point.offer(new Point(0, 0));
        point.offer(new Point(8, 6));
        point.offer(new Point(3, 4));
        point.offer(new Point(1, 1));

        System.out.println("Points list:");
        while (!point.isEmpty()) {System.out.println(point.poll());}
    }
}

