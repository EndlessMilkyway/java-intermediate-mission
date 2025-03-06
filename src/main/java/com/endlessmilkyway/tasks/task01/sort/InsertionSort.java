package com.endlessmilkyway.tasks.task01.sort;

import com.endlessmilkyway.tasks.task01.Messages;
import com.endlessmilkyway.tasks.task01.view.OutputView;

public class InsertionSort {

    private final OutputView outputView = OutputView.getInstance();

    // 삽입 정렬 - 시간 복잡도 O(n^2)
    public void process(int[] arr) {
        int[] copyArr = arr.clone();

        // 시간 측정 시작
        long beforeTime = System.currentTimeMillis();

        mainLogic(copyArr);

        // 시간 측정 종료
        long afterTime = System.currentTimeMillis();
        long diffTime = afterTime - beforeTime;

        Messages msg = Messages.INSERTION_SORT_RESULT;
        msg.printMsg(copyArr);
        outputView.printSortingProcessTime(diffTime);
    }

    private void mainLogic(int[] arr) {
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
}
