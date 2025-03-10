package com.endlessmilkyway.tasks.task05_07_08_10;

import com.endlessmilkyway.tasks.task05_07_08_10.abs.Circle;
import com.endlessmilkyway.tasks.task05_07_08_10.abs.Rectangle;
import com.endlessmilkyway.tasks.task05_07_08_10.abs.ShapeAbs;
import com.endlessmilkyway.tasks.task05_07_08_10.abs.Triangle;
import com.endlessmilkyway.tasks.task05_07_08_10.inter.CircleImpl;
import com.endlessmilkyway.tasks.task05_07_08_10.inter.RectangleImpl;
import com.endlessmilkyway.tasks.task05_07_08_10.inter.ShapeInter;
import com.endlessmilkyway.tasks.task05_07_08_10.inter.TriangleImpl;
import java.util.Arrays;

public class Task {

    public void run() {
        processAbstractClass();
        processInterface();
    }

    private void processAbstractClass() {
        System.out.println("--------추상 클래스 시작--------");

        ShapeAbs[] shapeArr = new ShapeAbs[3];

        ShapeAbs circle = Circle.fromDiameter(5.0);
        shapeArr[0] = circle;

        Rectangle rectangle = Rectangle.of(10.0, 5.0);
        shapeArr[1] = rectangle;

        ShapeAbs triangle = Triangle.of(3.0, 5.0, 4.0);
        shapeArr[2] = triangle;

        Arrays.stream(shapeArr).forEach(System.out::println);

        System.out.println("--------추상 클래스 종료--------");
    }

    private void processInterface() {
        System.out.println("--------인터페이스 시작--------");

        ShapeInter[] shapeArr = new ShapeInter[3];

        ShapeInter circle = CircleImpl.fromDiameter(7.0);
        shapeArr[0] = circle;

        ShapeInter rectangle = RectangleImpl.of(21.0, 10.0);
        shapeArr[1] = rectangle;

        TriangleImpl triangle = TriangleImpl.of(8.0, 10.0, 7.0);
        shapeArr[2] = triangle;

        Arrays.stream(shapeArr).forEach(System.out::println);

        System.out.println("--------인터페이스 종료--------");
    }
}
