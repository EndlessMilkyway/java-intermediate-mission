package com.endlessmilkyway.tasks.task01;

import com.endlessmilkyway.tasks.task01.sort.BubbleSort;
import com.endlessmilkyway.tasks.task01.sort.InsertionSort;
import com.endlessmilkyway.tasks.task01.sort.MergeSort;
import com.endlessmilkyway.tasks.task01.sort.QuickSort;
import com.endlessmilkyway.tasks.task01.sort.SelectionSort;
import com.endlessmilkyway.tasks.view.InputView;
import java.util.StringTokenizer;

public class Task01 {

    public void run() {
        int[] arr = createArrayFromConsoleInput();
        Messages msg = Messages.BEFORE_SORTING;
        msg.printMsg(arr);

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.process(arr);

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.process(arr);

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.process(arr);

        QuickSort quickSort = new QuickSort();
        quickSort.process(arr);

        MergeSort mergeSort = new MergeSort();
        mergeSort.process(arr);
    }

    private int[] createArrayFromConsoleInput() {
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
}
