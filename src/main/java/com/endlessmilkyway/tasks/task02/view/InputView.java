package com.endlessmilkyway.tasks.task02.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputView {

    private static final String INPUT_NUMBERS_MSG = "계산할 두 개의 숫자를 입력해주세요 : ";
    private static final String INPUT_OPERATOR_MSG = "어떤 연산을 수행하시겠습니까? (+, -, *, /, **) : ";

    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public List<Long> getNumbersFromConsole() {
        List<Long> numbers = new ArrayList<>();
        try {
            System.out.print(INPUT_NUMBERS_MSG);
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                numbers.add(Long.parseLong(st.nextToken()));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return numbers;
    }

    public String getOperatorFromConsole() {
        String operator = "";
        try {
            System.out.print(INPUT_OPERATOR_MSG);
            operator = br.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return operator;
    }
}
