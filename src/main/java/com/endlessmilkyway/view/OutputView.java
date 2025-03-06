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

    public void printArrayBeforeSort(int[] arr) {
        System.out.print("\n정렬 전 배열 : ");
        printArrayElems(arr);
    }

    public void printBubbleSortResult(int[] arr) {
        System.out.print("\n버블 정렬 결과 : ");
        printArrayElems(arr);
    }

    public void printSelectionSortResult(int[] arr) {
        System.out.print("\n선택 정렬 결과 : ");
        printArrayElems(arr);
    }

    public void printInsertionSortResult(int[] arr) {
        System.out.print("\n삽입 정렬 결과 : ");
        printArrayElems(arr);
    }

    public void printSortingProcessTime(long diffTime) {
        System.out.println("소요 시간(ms) : " + diffTime);
    }
}
