package com.endlessmilkyway.tasks.task01.sort;

import com.endlessmilkyway.tasks.task01.Messages;
import com.endlessmilkyway.tasks.task01.view.OutputView;

public class QuickSort {

    private final OutputView outputView = OutputView.getInstance();

    // 퀵 정렬 - 시간 복잡도 O(n log n)
    public void process(int[] arr) {
        int[] copyArr = arr.clone();

        // 시간 측정 시작
        long beforeTime = System.currentTimeMillis();

        mainLogic(copyArr, 0, copyArr.length - 1);

        // 시간 측정 종료
        long afterTime = System.currentTimeMillis();
        double diffTime = (double) (afterTime - beforeTime) / 1000;

        Messages msg = Messages.QUICK_SORT_RESULT;
        msg.printMsg(copyArr);
        outputView.printSortingProcessTime(diffTime);
    }

    private void mainLogic(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            mainLogic(arr, start, pivot);
            mainLogic(arr, pivot + 1, end);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int low = start - 1;
        int high = end + 1;
        int pivot = arr[(start + end) / 2];

        while (true) {
            do {
                low++;
            } while (arr[low] < pivot);

            do {
                high--;
            } while (arr[high] > pivot && low <= high);

            if (low >= high) {
                return high;
            }

            quickSwap(arr, low, high);
        }
    }

    private void quickSwap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
