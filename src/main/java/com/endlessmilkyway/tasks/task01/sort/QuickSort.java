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
            mainLogic(arr, start, pivot - 1);
            mainLogic(arr, pivot + 1, end);
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
}
