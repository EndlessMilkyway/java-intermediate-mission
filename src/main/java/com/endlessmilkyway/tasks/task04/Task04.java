package com.endlessmilkyway.tasks.task04;

import com.endlessmilkyway.tasks.task04.thread.Thread_1;
import com.endlessmilkyway.tasks.task04.thread.Thread_2;

public class Task04 {

    public void run() {
        Thread t1 = new Thread_1();
        Thread t2 = new Thread_2();

        t1.setPriority(10);

        System.out.println("쓰레드 t1의 우선순위 = " + t1.getPriority());
        System.out.println("쓰레드 t2의 우선순위 = " + t2.getPriority());
        t1.start();
        t2.start();
    }
}
