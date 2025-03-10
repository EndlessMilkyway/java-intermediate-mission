package com.endlessmilkyway.tasks.task05_07_08_10.abs;

public class Rectangle extends ShapeAbs {

    private final double length;
    private final double width;

    private Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public static Rectangle of(double length, double width) {
        return new Rectangle(length, width);
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
