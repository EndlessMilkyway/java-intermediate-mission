package com.endlessmilkyway.tasks.task09;

public class Manager extends Employee {

    private String role;

    public Manager(String name, double salary, String role) {
        super(name, salary);
        this.role = role;
    }

    @Override
    public void employeeInfo() {
        super.employeeInfo();
        System.out.println("직책 : " + role);
    }
}
