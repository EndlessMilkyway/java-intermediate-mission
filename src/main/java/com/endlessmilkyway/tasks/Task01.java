package com.endlessmilkyway.tasks;

import com.endlessmilkyway.view.InputView;
import com.endlessmilkyway.view.OutputView;
import java.util.StringTokenizer;

public class Task01 {

    private final OutputView outputView = OutputView.getInstance();

    public void run() {
        int[] arr = createArrayFormConsoleInput();
        outputView.printArrayBeforeSort(arr);

        bubbleSort(arr);
        selectionSort(arr);
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

    // 버블 정렬 - 시간 복잡도 O(n^2)
    private void bubbleSort(int[] arr) {
        int[] copyArr = arr.clone();

        // 시간 측정 시작
        long beforeTime = System.currentTimeMillis();

        bubbleMainLogic(copyArr);

        // 시간 측정 종료
        long afterTime = System.currentTimeMillis();
        long diffTime = afterTime - beforeTime;

        outputView.printBubbleSortResult(copyArr);
        outputView.printSortingProcessTime(diffTime);
    }

    // 버블 정렬 메인 로직
    private void bubbleMainLogic(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                bubbleSwap(arr, j);
            }
        }
    }

    // 배열 요소 변경 메서드
    private void bubbleSwap(int[] arr, int idx) {
        if (arr[idx] > arr[idx + 1]) {
            int temp = arr[idx];
            arr[idx] = arr[idx + 1];
            arr[idx + 1] = temp;
        }
    }

    // 선택 정렬 - 시간 복잡도 O(n^2)
    private void selectionSort(int[] arr) {
        int[] copyArr = arr.clone();

        // 시간 측정 시작
        long beforeTime = System.currentTimeMillis();

        selectionMainLogic(copyArr);

        // 시간 측정 종료
        long afterTime = System.currentTimeMillis();
        long diffTime = afterTime - beforeTime;

        outputView.printSelectionSortResult(copyArr);
        outputView.printSortingProcessTime(diffTime);
    }

    private static void selectionMainLogic(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }

            selectionSwap(arr, min, i);
        }
    }

    private static void selectionSwap(int[] arr, int min, int i) {
        if (arr[min] < arr[i]) {
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
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
