package com.endlessmilkyway.tasks.task09;

public class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void employeeInfo() {
        System.out.println("이름 : " + name);
        System.out.println("급여 : " + salary);
    }
}
