package com.endlessmilkyway.tasks.task05_07_08_10.abs;

public class Circle extends ShapeAbs {

    private final double diameter;

    private Circle(double diameter) {
        this.diameter = diameter;
    }

    public static Circle fromDiameter(double diameter) {
        return new Circle(diameter);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * diameter;
    }

    @Override
    public double area() {
        return Math.PI * diameter * diameter;
    }

    @Override
    public String toString() {
        return "원의 둘레 : " + perimeter() + ", 원의 넓이 : " + area();
    }
}
