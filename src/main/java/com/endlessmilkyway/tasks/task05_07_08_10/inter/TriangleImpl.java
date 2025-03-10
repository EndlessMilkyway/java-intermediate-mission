package com.endlessmilkyway.tasks.task05_07_08_10.inter;

public class TriangleImpl implements ShapeInter {

    private final double l1;
    private final double l2;
    private final double l3;

    private TriangleImpl(double l1, double l2, double l3) {
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
    }

    public static TriangleImpl of(double l1, double l2, double l3) {
        return new TriangleImpl(l1, l2, l3);
    }

    @Override
    public double perimeter() {
        return l1 + l2 + l3;
    }

    @Override
    public double area() {
        double semiPeri = perimeter() / 2;

        return Math.sqrt(semiPeri * (semiPeri - l1) * (semiPeri - l2) * (semiPeri - l3));
    }

    @Override
    public String toString() {
        return "삼각형의 둘레 : " + perimeter() + ", 삼각형의 넓이 : " + area();
    }
}
