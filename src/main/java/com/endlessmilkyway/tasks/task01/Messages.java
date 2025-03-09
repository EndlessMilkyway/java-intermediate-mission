package com.endlessmilkyway.tasks.task01;

import com.endlessmilkyway.tasks.task01.view.OutputView;

public enum Messages {
    BEFORE_SORTING("정렬 전 배열 : "),
    BUBBLE_SORT_RESULT("버블 정렬 결과 : "),
    SELECTION_SORT_RESULT("선택 정렬 결과 : "),
    INSERTION_SORT_RESULT("삽입 정렬 결과 : "),
    QUICK_SORT_RESULT("퀵 정렬 결과 : "),
    MERGE_SORT_RESULT("병합 정렬 결과 : ");

    private final String msg;

    Messages(String msg) {
        this.msg = msg;
    }

    public void printMsg(int[] arr) {
        OutputView outputView = OutputView.getInstance();
        outputView.printArrayElems(msg, arr);
    }
}
