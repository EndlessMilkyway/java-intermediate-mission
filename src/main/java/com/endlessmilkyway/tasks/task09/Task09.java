package com.endlessmilkyway.tasks.task09;

public class Task09 {

    public void run() {
        Employee hong = new Employee("홍길동", 2000000);
        Employee ga = new Employee("가나다", 3000000);

        Manager kim = new Manager("김영렬", 4000000, "팀장");

        hong.employeeInfo();
        ga.employeeInfo();
        kim.employeeInfo();
    }
}
