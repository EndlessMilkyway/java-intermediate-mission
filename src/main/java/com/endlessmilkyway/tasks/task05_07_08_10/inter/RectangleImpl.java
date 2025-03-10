package com.endlessmilkyway.tasks.task05_07_08_10.inter;

public class RectangleImpl implements ShapeInter {

    private final double length;
    private final double width;

    private RectangleImpl(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public static RectangleImpl of(double length, double width) {
        return new RectangleImpl(length, width);
    }

    @Override
    public double perimeter() {
        return (length * 2) + (width * 2);
    }

    @Override
    public double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return "사각형의 둘레 : " + perimeter() + ", 사각형의 넓이 : " + area();
    }
}
