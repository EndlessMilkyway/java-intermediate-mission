package com.endlessmilkyway.tasks.task01;

import com.endlessmilkyway.tasks.task01.view.InputView;
import com.endlessmilkyway.tasks.task01.view.OutputView;
import java.util.StringTokenizer;

public class Task01 {

    private final OutputView outputView = OutputView.getInstance();

    public void run() {
        int[] arr = createArrayFormConsoleInput();
        Messages msg = Messages.BEFORE_SORTING;
        msg.printMsg(arr);

        bubbleSort(arr);
        selectionSort(arr);
        insertionSort(arr);
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

        Messages msg = Messages.BUBBLE_SORT_RESULT;
        msg.printMsg(arr);
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
        // 해당 요소가 해당 요소의 다음 인덱스 보다 값이 크면 서로 교환
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

        Messages msg = Messages.SELECTION_SORT_RESULT;
        msg.printMsg(arr);
        outputView.printSortingProcessTime(diffTime);
    }

    private void selectionMainLogic(int[] arr) {
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

    private void selectionSwap(int[] arr, int min, int i) {
        if (arr[min] < arr[i]) {
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    // 삽입 정렬 - 시간 복잡도 O(n^2)
    private void insertionSort(int[] arr) {
        int[] copyArr = arr.clone();

        // 시간 측정 시작
        long beforeTime = System.currentTimeMillis();

        insertionSortMainLogic(copyArr);

        // 시간 측정 종료
        long afterTime = System.currentTimeMillis();
        long diffTime = afterTime - beforeTime;

        Messages msg = Messages.INSERTION_SORT_RESULT;
        msg.printMsg(arr);
        outputView.printSortingProcessTime(diffTime);
    }

    private void insertionSortMainLogic(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertIdx = i;
            int insertVal = arr[i];

            insertIdx = findInsertIdx(arr, i, insertIdx);
            pushDataToBack(arr, i, insertIdx);

            // 삽입 위치에 현재 데이터 삽입하기
            arr[insertIdx] = insertVal;
        }
    }

    // 현재 위치에서 삽입 위치 찾기
    private int findInsertIdx(int[] arr, int i, int insertIdx) {
        for (int j = i - 1; j >= 0; j--) {
            if (arr[j] < arr[i]) {
                insertIdx = j + 1;
                break;
            }
            if (j == 0) {
                insertIdx = 0;
            }
        }

        return insertIdx;
    }

    // 삽입을 위해 삽입 위치에서 i까지 데이터를 한 칸씩 뒤로 밀기
    private void pushDataToBack(int[] arr, int i, int insertIdx) {
        for (int j = i; j > insertIdx; j--) {
            arr[j] = arr[j - 1];
        }
    }

    private void quickSort(int[] arr) {
        int[] copyArr = arr.clone();


    }

    private void mergeSort(int[] arr) {
        int[] copyArr = arr.clone();


    }
}
