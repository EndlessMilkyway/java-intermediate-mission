package com.endlessmilkyway.tasks.task01.sort;

import com.endlessmilkyway.tasks.task01.Messages;
import com.endlessmilkyway.tasks.task01.view.OutputView;

public class MergeSort {

    private final OutputView outputView = OutputView.getInstance();

    public void process(int[] arr) {
        int[] copyArr = arr.clone();

        // 시간 측정 시작
        long beforeTime = System.currentTimeMillis();

        mainLogic(copyArr, 0, copyArr.length - 1);

        // 시간 측정 종료
        long afterTime = System.currentTimeMillis();
        double diffTime = (double) (afterTime - beforeTime) / 1000;

        Messages msg = Messages.MERGE_SORT_RESULT;
        msg.printMsg(copyArr);
        outputView.printSortingProcessTime(diffTime);
    }

    private void mainLogic(int[] arr, int startIdx, int endIdx) {
        if (endIdx - startIdx < 1) {
            return;
        }

        int median = startIdx + (endIdx - startIdx) / 2;
        mainLogic(arr, startIdx, median);
        mainLogic(arr, median + 1, endIdx);
        merge(arr, startIdx, median, endIdx);
    }

    private void merge(int[] arr, int startIdx, int midIdx, int endIdx) {
        int[] sortedArr = new int[arr.length];

        int i = startIdx;
        int j = midIdx + 1;
        int k = startIdx;

        // 분할 정렬된 배열들을 합병
        while (i <= midIdx && j <= endIdx) {
            if (arr[i] <= arr[j]) {
                sortedArr[k++] = arr[i++];
            } else {
                sortedArr[k++] = arr[j++];
            }
        }

        // 남아 있는 값들을 모두 복사
        if (i > midIdx) {
            for (int l = j; l <= endIdx; l++) {
                sortedArr[k++] = arr[l];
            }
        } else {
            for (int l = i; l <= midIdx; l++) {
                sortedArr[k++] = arr[l];
            }
        }

        // 정렬해둔 값을 임시로 저장해놓은 sortedArr을 arr로 복사
        for (int l = startIdx; l <= endIdx; l++) {
            arr[l] = sortedArr[l];
        }
    }
}
