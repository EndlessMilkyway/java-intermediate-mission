package com.endlessmilkyway.tasks;

import com.endlessmilkyway.view.InputView;
import com.endlessmilkyway.view.OutputView;
import java.util.StringTokenizer;

public class Task01 {

    private final OutputView outputView = OutputView.getInstance();

    public void run() {
        int[] arr = createArrayFormConsoleInput();
        outputView.printArrayElems(arr);

        bubbleSort(arr);
    }

    private int[] createArrayFormConsoleInput() {
        InputView inputView = InputView.getInstance();
        int size = inputView.getArrayLengthFromConsole();
        int[] arr = new int[size];

        String elems = inputView.getArrayElemsFromConsole();
        StringTokenizer st = new StringTokenizer(elems);

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        return arr;
    }

    private void bubbleSort(int[] arr) {
        int[] copyArr = arr.clone();

        // 시간 측정 시작
        long beforeTime = System.currentTimeMillis();

        bubbleMainLogic(copyArr);

        // 시간 측정 종료
        long afterTime = System.currentTimeMillis();
        long diffTime = afterTime - beforeTime;

        outputView.printBubbleSortResult(copyArr);
        System.out.println("소요 시간(ms) : " + diffTime);
    }

    // 버블 정렬 메인 로직
    private void bubbleMainLogic(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                swap(arr, j);
            }
        }
    }

    // 배열 요소 변경 메서드
    private void swap(int[] arr, int idx) {
        if (arr[idx] > arr[idx + 1]) {
            int temp = arr[idx];
            arr[idx] = arr[idx + 1];
            arr[idx + 1] = temp;
        }
    }

    private void selectionSort(int[] arr) {
        int[] copyArr = arr.clone();


    }

    private void insertionSort(int[] arr) {
        int[] copyArr = arr.clone();


    }

    private void quickSort(int[] arr) {
        int[] copyArr = arr.clone();


    }

    private void mergeSort(int[] arr) {
        int[] copyArr = arr.clone();


    }
}
