package ru.job4j.oop;

import static java.lang.Math.sqrt;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }
    /**
     * Метод вычисления периметра по длинам сторон.
     */
    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }
    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     */
    public boolean exist(double a, double c, double b) {
        boolean result = a + b > c && a + c > b && b + c > a;
        return result;
    }
    /**
     * Метод должен вычислить площадь треугольника.
     */
    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            /* написать формулу для расчета площади треугольника. */
            rsl = sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return rsl;
    }
}
