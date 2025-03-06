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
        quickSort(arr);
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
        msg.printMsg(copyArr);
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
        msg.printMsg(copyArr);
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
        msg.printMsg(copyArr);
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

    // 퀵 정렬 - 시간 복잡도 O(n log n)
    private void quickSort(int[] arr) {
        int[] copyArr = arr.clone();

        // 시간 측정 시작
        long beforeTime = System.currentTimeMillis();

        quickMainLogic(copyArr, 0, copyArr.length - 1);

        // 시간 측정 종료
        long afterTime = System.currentTimeMillis();
        long diffTime = afterTime - beforeTime;

        Messages msg = Messages.QUICK_SORT_RESULT;
        msg.printMsg(copyArr);
        outputView.printSortingProcessTime(diffTime);
    }

    private void quickMainLogic(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickMainLogic(arr, start, pivot - 1);
            quickMainLogic(arr, pivot + 1, end);
        }
    }

    // 피벗을 산출하는 메서드
    private int partition(int[] arr, int start, int end) {
        // 데이터가 2개인 경우에는 바로 비교하여 정렬
        if (start + 1 == end) {
            if (arr[start] > arr[end]) {
                quickSwap(arr, start, end);
            }
            return end;
        }

        // 중앙값 계산
        int median = (start + end) / 2;
        // 중앙값을 시작 위치와 swap
        quickSwap(arr, start, median);
        // pivot을 시작 위치로 설정 - 위에서 swap 하였으므로
        int pivot = arr[start];
        // 시작점 종료점 선언
        int j = search(arr, start, end, pivot);
        // pivot 데이터를 나눠진 두 그룹의 경계 index에 저장
        arr[start] = arr[j];
        arr[j] = pivot;
        // 경계 index 반환
        return j;
    }

    private int search(int[] arr, int start, int end, int pivot) {
        int i = start + 1;
        int j = end;
        while (i <= j) {
            // 피벗보다 작은 수가 나올 때까지 j--
            while (pivot < arr[j] && j >= start + 1) {
                j--;
            }
            // 피벗보다 큰 수가 나올 때까지 i++
            while (pivot > arr[i] && j <= end) {
                i++;
            }
            // 찾은 i와 j를 swap
            if (i < j) {
                quickSwap(arr, i++, j--);
            } else {
                break;
            }
        }
        return j;
    }

    private void quickSwap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void mergeSort(int[] arr) {
        int[] copyArr = arr.clone();


    }
}
