package com.endlessmilkyway.tasks.task01.view;

import java.util.Arrays;

public class OutputView {

    private static final String PROCESS_TIME = "소요 시간(ms) : ";

    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printArrayElems(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public void printArrayElems(String msg, int[] arr) {
        System.out.print(msg);
        printArrayElems(arr);
    }

    public void printSortingProcessTime(double diffTime) {
        System.out.println(PROCESS_TIME + diffTime);
    }
}
