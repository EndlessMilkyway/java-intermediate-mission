package com.endlessmilkyway.tasks.task01.sort;

import com.endlessmilkyway.tasks.task01.Messages;
import com.endlessmilkyway.tasks.task01.view.OutputView;

public class SelectionSort {

    private final OutputView outputView = OutputView.getInstance();

    // 선택 정렬 - 시간 복잡도 O(n^2)
    public void process(int[] arr) {
        int[] copyArr = arr.clone();

        // 시간 측정 시작
        long beforeTime = System.currentTimeMillis();

        mainLogic(copyArr);

        // 시간 측정 종료
        long afterTime = System.currentTimeMillis();
        double diffTime = (double) (afterTime - beforeTime) / 1000;

        Messages msg = Messages.SELECTION_SORT_RESULT;
        msg.printMsg(copyArr);
        outputView.printSortingProcessTime(diffTime);
    }

    private void mainLogic(int[] arr) {
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
}
