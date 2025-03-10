package com.endlessmilkyway.tasks.task05_07_08_10.inter;

public class CircleImpl implements ShapeInter {

    private final double diameter;

    private CircleImpl(double diameter) {
        this.diameter = diameter;
    }

    public static CircleImpl fromDiameter(double diameter) {
        return new CircleImpl(diameter);
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
