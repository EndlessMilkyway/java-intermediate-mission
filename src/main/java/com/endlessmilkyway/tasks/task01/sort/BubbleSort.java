package com.endlessmilkyway.tasks.task01.sort;

import com.endlessmilkyway.tasks.task01.Messages;
import com.endlessmilkyway.tasks.task01.view.OutputView;

public class BubbleSort {

    private final OutputView outputView = OutputView.getInstance();

    // 버블 정렬 - 시간 복잡도 O(n^2)
    public void process(int[] arr) {
        int[] copyArr = arr.clone();

        // 시간 측정 시작
        long beforeTime = System.currentTimeMillis();

        mainLogic(copyArr);

        // 시간 측정 종료
        long afterTime = System.currentTimeMillis();
        double diffTime = (double) (afterTime - beforeTime) / 1000;

        Messages msg = Messages.BUBBLE_SORT_RESULT;
        msg.printMsg(copyArr);
        outputView.printSortingProcessTime(diffTime);
    }

    // 버블 정렬 메인 로직
    private void mainLogic(int[] arr) {
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
}
