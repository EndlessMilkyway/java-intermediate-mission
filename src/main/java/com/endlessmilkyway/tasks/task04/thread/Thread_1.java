package com.endlessmilkyway.tasks.task04.thread;

import java.util.Calendar;

public class Thread_1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread_1_Start - " + Calendar.getInstance().getTime());
        for (int i = 0; i < 1000; i++) {
            System.out.print("-");
            for (int x = 0; x < 10000000; x++);
        }
        System.out.println("\nThread_1_End - " + Calendar.getInstance().getTime());
    }
}
