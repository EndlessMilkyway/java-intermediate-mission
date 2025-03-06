package com.endlessmilkyway.view;

import java.util.Arrays;

public class OutputView {

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

    public void printBubbleSortResult(int[] arr) {
        System.out.print("버블 정렬 결과 : ");
        printArrayElems(arr);
    }
}
